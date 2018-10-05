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
public class QuartoFachada {

    @PersistenceContext(unitName = "UnidadeDePersistenciaEJB")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

       public int getMaxCodigo() {  // pega o maior ID de cliente na tabela
       Query query = em.createNativeQuery("SELECT MAX(codigo) FROM QUARTO");
       return (Integer) query.getSingleResult();
    }
    
    void cadastrarQuarto(Quarto quarto) {
        quarto.setCodigo(this.getMaxCodigo());
        this.em.persist(quarto);
    }
}
