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
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

/**
 *
 * @author joaov
 */
@Named(value = "usuariohotelMBean")
@RequestScoped
public class UsuariohotelMBean {

    @EJB
    private UsuariohotelFachada usuariohotelFachada;
    private Usuariohotel usuariohotel = new Usuariohotel();  // Guarda os dados do formulário
    private String filtroCpf = "";
    private String login = "";
    private String senha = "";
    
    @Inject
    private ReservaMBean reservaMBean;
    
    public ReservaMBean getReservaMBean() {
        return reservaMBean;
    }

    public void setReservaMBean(ReservaMBean reservaMBean) {
        this.reservaMBean = reservaMBean;
    }
    
    /**
     * Creates a new instance of UsuariohotelMBean
     */
    public UsuariohotelMBean() {
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //Metodo para validar o funcionario/cliente
    public String realizarLogin() {
        for (Usuariohotel user : this.getListaUsuariohotel()) {
            if (user.getLogin().equals(login)) {
                if (user.getSenha().equals(senha)) {
                    if (user.getFuncionario()) {
                        return "paginaFuncionario";
                    } else {//Caso for um cliente, configurar o bean JSF de Reserva para carregar o quarto desse cliente
                        
                        List<Reserva> listaReserva = this.reservaMBean.getListaReserva(); //Problema pode vir dessa getListaQuarto()
                        for (Reserva reserva : listaReserva) {
                            if (reserva.getUsuariohotel().equals(user)) {
                                this.reservaMBean.setReserva(reserva);
                            }
                        }
                              
                        return "paginaCliente";
                        
                    }
                }
                return "index";
            }
        }
        return "index";
    }
    
    
    
    public List<Usuariohotel> getListaUsuariohotel() {
        return usuariohotelFachada.getListaUsuariohotel();
    }

    public String getFiltroCpf() {
        return filtroCpf;
    }

    public void setFiltroCpf(String filtroUf) {
        this.filtroCpf = filtroUf;
    }
    
    public List getListaClientesPorCpf() {
        return usuariohotelFachada.getListaUsuariohotelByCpf(filtroCpf);
    }

    public Usuariohotel getUsuariohotel() {
        return usuariohotel;
    }

    public void setUsuariohotel(Usuariohotel usuariohotel) {
        this.usuariohotel = usuariohotel;
    }

    public String cadastrarUsuariohotel() {          // Chama o método do bean de sessão
        usuariohotel.setFuncionario(false);
        usuariohotelFachada.cadastrarUsuariohotel(usuariohotel);
        usuariohotel = new Usuariohotel();
        return "index";
    }
    
    public String salvarUsuariohotel() {
        usuariohotelFachada.salvarUsuariohotel(this.usuariohotel);
        return "index";
    }
    
    public String botaoListar() {
        return "listagem";
    }
    
    
    
}
