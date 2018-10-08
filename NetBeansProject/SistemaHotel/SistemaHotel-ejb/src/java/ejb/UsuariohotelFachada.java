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

    public int getMaxId() {  // pega o maior ID de cliente na tabela
        Query query = em.createNativeQuery("SELECT MAX(id) FROM USUARIOHOTEL");
        BigDecimal resultado = (BigDecimal) query.getSingleResult();
        return resultado.intValue();
    }
 
    public void cadastrarUsuariohotel(Usuariohotel usuariohotel) {  // Cadastra o cliente 
        int id = getMaxId()+1;
       usuariohotel.setId(id);
        System.out.println(id);
       em.persist(usuariohotel);
    }
    
    public void salvarUsuariohotel(Usuariohotel usuariohotel) {
        em.merge(usuariohotel);
        em.flush();
    }

    public List getListaUsuariohotelByCpf(String cpf) {
        if (cpf == null || cpf.equals("")) 
            return getListaUsuariohotel();
        Query query = em.createNamedQuery("Usuariohotel.findByCpf");
        query.setParameter("cpf", cpf);
        return query.getResultList();
    }
    
    
}
