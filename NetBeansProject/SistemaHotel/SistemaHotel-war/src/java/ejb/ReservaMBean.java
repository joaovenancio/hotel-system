/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author andre
 */
@Named(value = "reservaMBean")
@RequestScoped
public class ReservaMBean {

    @EJB
    private ReservaFachada reservaFachada;
    private Reserva reserva = new Reserva();  // Guarda os dados do formulário
    private boolean limpeza = true;
    private boolean manutencao = true;
    
    
    /**
     * Creates a new instance of ReservaMBean
     */
    public ReservaMBean() {
    }
    
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public boolean isLimpeza() {
        return limpeza;
    }

    public void setLimpeza(boolean limpeza) {
        this.limpeza = limpeza;
    }

    public boolean isManutencao() {
        return manutencao;
    }

    public void setManutencao(boolean manutencao) {
        this.manutencao = manutencao;
    }
    
    public String cadastrarReserva() {          // Chama o método do bean de sessão
        reservaFachada.cadastrarReserva(reserva);
        reserva = new Reserva();
        return "paginaFuncionario";
    }
    
    public String salvarReserva() {
        reservaFachada.salvarReserva(this.reserva);
        return "paginaCliente";
    }
    
    public List<Reserva> getListaQuarto() {
        return this.reservaFachada.getListaReserva();
    }
}
