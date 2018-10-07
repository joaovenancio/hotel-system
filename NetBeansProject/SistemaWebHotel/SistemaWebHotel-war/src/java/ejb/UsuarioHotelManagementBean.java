/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author andre
 */
@Named(value = "usuarioHotelManagementBean")
@Dependent
public class UsuarioHotelManagementBean {

    @EJB
    private UsuariohotelFachada usuariohotelFachada;

    /**
     * Creates a new instance of UsuarioHotelManagementBean
     */
    public UsuarioHotelManagementBean() {
    }
    
    private Usuariohotel usuario = new Usuariohotel();  // Guarda os dados do formulário

    public Usuariohotel getUsuario() {
        return usuario;
    }

    public void setCliente(Usuariohotel usuario) {
        this.usuario = usuario;
    }

    public String cadastrarUsuario() {          // Chama o método do bean de sessão
        usuariohotelFachada.cadastrarUsuario(usuario);
        usuario = new Usuariohotel();
        return "index";
    }
    
}
