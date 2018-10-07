package ejb;

import ejb.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-07T16:53:45")
@StaticMetamodel(Usuariohotel.class)
public class Usuariohotel_ { 

    public static volatile SingularAttribute<Usuariohotel, String> senha;
    public static volatile SingularAttribute<Usuariohotel, String> telefone;
    public static volatile SingularAttribute<Usuariohotel, String> endereco;
    public static volatile SingularAttribute<Usuariohotel, String> cpf;
    public static volatile SingularAttribute<Usuariohotel, String> nome;
    public static volatile SingularAttribute<Usuariohotel, Integer> id;
    public static volatile SingularAttribute<Usuariohotel, Boolean> funcionario;
    public static volatile CollectionAttribute<Usuariohotel, Reserva> reservaCollection;
    public static volatile SingularAttribute<Usuariohotel, String> login;

}