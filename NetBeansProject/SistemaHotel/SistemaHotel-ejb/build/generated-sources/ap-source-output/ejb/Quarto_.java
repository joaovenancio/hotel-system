package ejb;

import ejb.Reserva;
import ejb.Tipostatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T15:19:38")
@StaticMetamodel(Quarto.class)
public class Quarto_ { 

    public static volatile SingularAttribute<Quarto, Boolean> banheira;
    public static volatile SingularAttribute<Quarto, Integer> codigo;
    public static volatile SingularAttribute<Quarto, Double> valordiaria;
    public static volatile SingularAttribute<Quarto, Tipostatus> fkStatus;
    public static volatile SingularAttribute<Quarto, Boolean> frigobar;
    public static volatile SingularAttribute<Quarto, Boolean> homeoffice;
    public static volatile SingularAttribute<Quarto, String> tipoquarto;
    public static volatile SingularAttribute<Quarto, Boolean> televisao;
    public static volatile SingularAttribute<Quarto, Integer> numcamasolteiro;
    public static volatile CollectionAttribute<Quarto, Reserva> reservaCollection;
    public static volatile SingularAttribute<Quarto, Boolean> internet;
    public static volatile SingularAttribute<Quarto, Integer> numcamacasal;

}