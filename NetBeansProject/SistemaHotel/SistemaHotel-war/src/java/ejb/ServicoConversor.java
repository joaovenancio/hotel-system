/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author andre
 */
@Named(value = "servicoConversor")
@ApplicationScoped
//@FacesConverter(forClass = Servicohotel.class)
public class ServicoConversor implements Converter {

    @EJB
    private ServicohotelFachada servicohotelFachada;

    /**
     * Creates a new instance of ServicoConversor
     */
    public ServicoConversor() {
    }
    
    @Inject
    private ServicohotelMBean servicoHotelMBean;

    public ServicohotelFachada getServicohotelFachada() {
        return servicohotelFachada;
    }

    public void setServicohotelFachada(ServicohotelFachada servicohotelFachada) {
        this.servicohotelFachada = servicohotelFachada;
    }

    public ServicohotelMBean getServicoHotelMBean() {
        return servicoHotelMBean;
    }

    public void setServicoHotelMBean(ServicohotelMBean servicoHotelMBean) {
        this.servicoHotelMBean = servicoHotelMBean;
    }

    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        for (Servicohotel servico : this.servicoHotelMBean.getListaServicohotel()) {
            if (servico.toString().equals(value)) {
                return servico;
            }
        }
        
        return new Servicohotel();
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        Servicohotel servico = (Servicohotel) value;
        return servico.toString();
        
    }
    
}
