/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andre
 */
@Named(value = "reservaMBean")
@ApplicationScoped
public class ReservaMBean {

    @EJB
    private ReservaFachada reservaFachada;
    private Reserva reserva = new Reserva();  // Guarda os dados do formulário
    private boolean limpeza = true;
    private boolean manutencao = true;
    private Servicohotel servico = new Servicohotel();
    private String toStringServico = "";
    
    @Inject
    private ServicohotelMBean servicohotelMBean;
    
    /**
     * Creates a new instance of ReservaMBean
     */
    public ReservaMBean() {
    }

    public String getToStringServico() {
        return toStringServico;
    }

    public void setToStringServico(String toStringServico) {
        this.toStringServico = toStringServico;
    }
    
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Servicohotel getServico() {
        return servico;
    }

    public void setServico(Servicohotel servico) {
        this.servico = servico;
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
    
    public List<Reserva> getListaReserva() {
        return this.reservaFachada.getListaReserva();
    }
    
    public String solicitarLimpezaManutencao () {
        if (this.limpeza) { //Limpeza custa 30
            this.getReserva().setValor(this.reserva.getValor() + 30);
        }
        if (this.manutencao) { //Manutencao custa 60
            this.getReserva().setValor(this.reserva.getValor() + 60);
        }
        
        this.salvarReserva();
        
        return "paginaCliente";
    }
    
    public String solicitarServico() {
        for (Servicohotel servico : this.servicohotelMBean.getListaServicohotel()) {
            if (servico.toString().equals(this.toStringServico)) {
                this.servico = servico;
            }
        }
        
        reserva.getServicohotelCollection().add(this.servico);
        //Atualizar o valor da reserva:
        this.reserva.setValor(this.reserva.getValor() + this.servico.getPreco());
        
        this.salvarReserva();
        
        this.servico = new Servicohotel();
        
        return "paginaCliente";
    }
    
    public double calcularValorTotal () {
        double servicoQuartoManutencao = this.reserva.getValor();
        double valorTotalDiarias = this.reserva.getQuarto().getValordiaria() * this.reserva.getDiarias();
        double valorTotalServicos = 0;
        for (Servicohotel servico : this.getReserva().getServicohotelCollection()) {
            valorTotalServicos += servico.getPreco();
        }
        
        
        return 0;
    }
}
