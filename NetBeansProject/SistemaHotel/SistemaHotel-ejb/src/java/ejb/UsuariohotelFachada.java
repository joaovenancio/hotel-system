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
public class UsuariohotelFachada {

    @PersistenceContext(unitName = "SistemaHotelPersistencia")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    // Metodo que retorna a lista de clientes armazenada na tabela Clientes
    public List<ejb.Usuariohotel> getListaUsuariohotel() {
        Query query = em.createNamedQuery("Usuariohotel.findAll");
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
