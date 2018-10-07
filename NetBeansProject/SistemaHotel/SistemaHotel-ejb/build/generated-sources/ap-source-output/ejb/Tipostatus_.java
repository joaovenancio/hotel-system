package ejb;

import ejb.Quarto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-07T20:05:28")
@StaticMetamodel(Tipostatus.class)
public class Tipostatus_ { 

    public static volatile SingularAttribute<Tipostatus, Integer> codigo;
    public static volatile CollectionAttribute<Tipostatus, Quarto> quartoCollection;
    public static volatile SingularAttribute<Tipostatus, String> nomestatus;

}