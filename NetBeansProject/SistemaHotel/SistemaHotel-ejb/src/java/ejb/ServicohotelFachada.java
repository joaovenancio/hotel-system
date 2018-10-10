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
        Query query = em.createNamedQuery("Usuariohotel.findAll");
        return query.getResultList();
    }

    public int getMaxCodigo() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(codigo) FROM SERVICOHOTEL");
        return (Integer) query.getSingleResult();
    }
 
    public void cadastrarServicohotel(Servicohotel servicohotel) {  // Cadastra o cliente 
       servicohotel.setCodigo(getMaxCodigo()+1);
       em.persist(servicohotel);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
