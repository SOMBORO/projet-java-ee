package edu.ensit.projetjavaee.modeles;

import edu.ensit.projetjavaee.modeles.Fournisseur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-17T10:03:55")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, String> img;
    public static volatile SingularAttribute<Produit, Fournisseur> idFournisseur;
    public static volatile SingularAttribute<Produit, String> categorie;
    public static volatile SingularAttribute<Produit, Double> prix;
    public static volatile SingularAttribute<Produit, String> modele;
    public static volatile SingularAttribute<Produit, String> couleur;
    public static volatile SingularAttribute<Produit, Integer> id;
    public static volatile SingularAttribute<Produit, String> type;
    public static volatile SingularAttribute<Produit, String> nom;
    public static volatile SingularAttribute<Produit, Integer> quantite;

}