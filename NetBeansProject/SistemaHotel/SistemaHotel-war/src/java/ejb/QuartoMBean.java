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
@Named(value = "quartoMBean")
@RequestScoped
public class QuartoMBean {

    @EJB
    private QuartoFachada quartoFachada;
    private Quarto quarto = new Quarto();  // Guarda os dados do formulário
    
    /**
     * Creates a new instance of QuartoMBean
     */
    public QuartoMBean() {
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto cliente) {
        this.quarto = cliente;
    }

    public String cadastrarQuarto() {          // Chama o método do bean de sessão
        quartoFachada.cadastrarQuarto(quarto);
        quarto = new Quarto();
        return "paginaFuncionario";
    }
    
    public List<Quarto> getListaQuarto() {
        return this.quartoFachada.getListaQuarto();
    }
    
}
