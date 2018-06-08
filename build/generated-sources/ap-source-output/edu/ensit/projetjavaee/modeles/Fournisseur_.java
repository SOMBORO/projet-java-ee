package edu.ensit.projetjavaee.modeles;

import edu.ensit.projetjavaee.modeles.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-17T10:03:55")
@StaticMetamodel(Fournisseur.class)
public class Fournisseur_ { 

    public static volatile CollectionAttribute<Fournisseur, Produit> produitCollection;
    public static volatile SingularAttribute<Fournisseur, Integer> id;
    public static volatile SingularAttribute<Fournisseur, String> typeFournisseur;
    public static volatile SingularAttribute<Fournisseur, String> nom;

}