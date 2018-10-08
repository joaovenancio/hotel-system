/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author joaov
 */
@Named(value = "servicohotelMBean")
@RequestScoped
public class ServicohotelMBean {

    @EJB
    private ServicohotelFachada servicohotelFachada;
    private Servicohotel servico = new Servicohotel();  // Guarda os dados do formulário

    /**
     * Creates a new instance of ServicohotelMBean
     */
    public ServicohotelMBean() {
    }

    public Servicohotel getServicohotel() {
        return servico;
    }

    public void setServicohotel(Servicohotel cliente) {
        this.servico = cliente;
    }

    public String cadastrarServicohotel() {          // Chama o método do bean de sessão
        servicohotelFachada.cadastrarServicohotel(servico);
        servico = new Servicohotel();
        return "paginaFuncionario";
    }
    
    
}
