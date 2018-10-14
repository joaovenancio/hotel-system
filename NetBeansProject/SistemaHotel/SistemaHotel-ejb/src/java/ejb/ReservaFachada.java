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
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author joaov
 */
@Stateful
@LocalBean
public class ReservaFachada {

    @PersistenceContext(unitName = "SistemaHotelPersistencia")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<ejb.Reserva> getListaReserva() {
        Query query = em.createNamedQuery("Reserva.findAll");
        return query.getResultList();
    }

    public int getMaxCodigo() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(codigo) FROM RESERVA");
        BigDecimal resultado = (BigDecimal) query.getSingleResult();
        return resultado.intValue();
    }
 
    public void cadastrarReserva(Reserva reserva) {  // Cadastra o cliente 
       int codigo = getMaxCodigo()+1;
       reserva.getReservaPK().setCodigo(codigo);
       em.persist(reserva);
    }
    
    public void salvarReserva(Reserva reserva) {
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+reserva.getReservaPK().getCodigo());
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
