/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author joaov
 */
@Stateless
@LocalBean
public class ServicohotelFachada {

    @PersistenceContext(unitName = "SistemaHotelPersistencia")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<ejb.Servicohotel> getListaServicohotel() {
        Query query = em.createNamedQuery("Servicohotel.findAll");
        return query.getResultList();
    }

    public int getMaxCodigo() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(codigo) FROM SERVICOHOTEL");
        BigDecimal resultado = (BigDecimal) query.getSingleResult();
        return resultado.intValue();
    }
 
    public void cadastrarServicohotel(Servicohotel servicohotel) {  // Cadastra o cliente 
        int codigo = this.getMaxCodigo()+1;
        servicohotel.setCodigo(codigo);
        em.persist(servicohotel);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
