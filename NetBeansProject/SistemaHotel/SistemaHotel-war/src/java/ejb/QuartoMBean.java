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
    private TipostatusFachada tipostatusFachada;

    @EJB
    private QuartoFachada quartoFachada;
    private Quarto quarto = new Quarto();  // Guarda os dados do formulário
    private String codigoStatus;
    
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

    public String getCodigoStatus() {
        return codigoStatus;
    }

    public void setCodigoStatus(String codigoStatus) {
        this.codigoStatus = codigoStatus;
    }
    
    public String cadastrarQuarto() {          // Chama o método do bean de sessão
        quarto.setFkStatus(this.recuperarStatus(this.codigoStatus));
        quartoFachada.cadastrarQuarto(quarto);
        quarto = new Quarto();
        return "paginaFuncionario";
    }
    
    public List<Quarto> getListaQuarto() {
        return this.quartoFachada.getListaQuarto();
    }
    
    private Tipostatus recuperarStatus (String codigo) {
        Tipostatus status = (Tipostatus) this.tipostatusFachada.getListTipostatusByCodigo(String.valueOf(codigo)).get(0);
        return status;
    }
    
    
}
