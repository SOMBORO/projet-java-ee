package edu.ensit.projetjavaee.modeles;

import edu.ensit.projetjavaee.modeles.CommandePK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-17T10:03:55")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Double> total;
    public static volatile SingularAttribute<Commande, Integer> qte;
    public static volatile SingularAttribute<Commande, CommandePK> commandePK;
    public static volatile SingularAttribute<Commande, Date> dateCommande;

}