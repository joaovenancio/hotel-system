/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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

    @PersistenceContext(unitName = "UnidadeDePersistenciaEJB")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public int getMaxCodigo() {  // pega o maior ID de cliente na tabela
       Query query = em.createNativeQuery("SELECT MAX(id) FROM USUARIOHOTEL");
       return (Integer) query.getSingleResult();
    }
    
    void cadastrarUsuario(Usuariohotel usuario) {
        usuario.setId(this.getMaxCodigo());
        this.em.persist(usuario);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
