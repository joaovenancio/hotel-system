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

    /**
     * Creates a new instance of UsuariohotelMBean
     */
    public UsuariohotelMBean() {
    }
    
    public List<Usuariohotel> getListaUsuariohotel() {
        return usuariohotelFachada.getListaUsuariohotel();
    }
    
}
