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
public class ReservaFachada {

    @PersistenceContext(unitName = "SistemaHotelPersistencia")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<ejb.Usuariohotel> getListaReserva() {
        Query query = em.createNamedQuery("Quarto.findAll");
        return query.getResultList();
    }

    public int getMaxCodigo() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(codigo) FROM QUARTO");
        return (Integer) query.getSingleResult();
    }
 
    public void cadastrarReserva(Reserva reserva) {  // Cadastra o cliente 
       em.persist(reserva);
    }
    
    public void salvarReserva(Reserva reserva) {
        em.merge(reserva);
        em.flush();
    }

    public List getListaReservaByCodigo(String codigo) {
        if (codigo == null || codigo.equals("")) 
            return getListaReserva();
        Query query = em.createNamedQuery("Reserva.findByCodigo");
        query.setParameter("codigo", codigo);
        return query.getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}