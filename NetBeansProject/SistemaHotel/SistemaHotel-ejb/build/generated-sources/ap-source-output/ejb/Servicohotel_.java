package ejb;

import ejb.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-07T20:05:28")
@StaticMetamodel(Servicohotel.class)
public class Servicohotel_ { 

    public static volatile SingularAttribute<Servicohotel, Double> preco;
    public static volatile SingularAttribute<Servicohotel, Integer> codigo;
    public static volatile SingularAttribute<Servicohotel, String> nome;
    public static volatile CollectionAttribute<Servicohotel, Reserva> reservaCollection;

}