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
                    } else {
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
