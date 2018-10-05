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
 * @author joaov
 */
@Named(value = "quartoManagementBean")
@Dependent
public class QuartoManagementBean {

    @EJB
    private QuartoFachada quartoFachada;
    private Quarto quarto = new Quarto(); //Objeto para armazenar os dados do formulário

    /**
     * Creates a new instance of QuartoManagementBean
     */
    public QuartoManagementBean() {
    }
    

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String cadastrarQuarto() {          // Chama o método do bean de sessão
        this.quartoFachada.cadastrarQuarto(quarto);
        this.quarto = new Quarto();
        return "index";
    }
    
    
    
}
