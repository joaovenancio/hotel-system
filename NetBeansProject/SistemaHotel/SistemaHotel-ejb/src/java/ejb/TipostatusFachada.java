/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
@Stateless
@LocalBean
public class TipostatusFachada {

    @PersistenceContext(unitName = "SistemaHotelPersistencia")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<ejb.Tipostatus> getListaTipostatus() {
        Query query = em.createNamedQuery("Tipostatus.findAll");
        return query.getResultList();
    }
    
    public List<ejb.Tipostatus> getListTipostatusByCodigo(String codigo) {
        if (codigo == null || codigo.equals("")) 
            return getListaTipostatus();
        Query query = em.createNamedQuery("Tipostatus.findByCodigo");
        query.setParameter("codigo", Integer.valueOf(codigo));
        return query.getResultList();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
