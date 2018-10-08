package ejb;

import ejb.Quarto;
import ejb.ReservaPK;
import ejb.Servicohotel;
import ejb.Usuariohotel;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-08T17:20:07")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, ReservaPK> reservaPK;
    public static volatile SingularAttribute<Reserva, Usuariohotel> usuariohotel;
    public static volatile CollectionAttribute<Reserva, Servicohotel> servicohotelCollection;
    public static volatile SingularAttribute<Reserva, Quarto> quarto;
    public static volatile SingularAttribute<Reserva, Double> valor;
    public static volatile SingularAttribute<Reserva, Boolean> checkout;
    public static volatile SingularAttribute<Reserva, Integer> diarias;

}