/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.services;

import edu.ensit.projetjavaee.modeles.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SOMBORO
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> {

    @PersistenceContext(unitName = "projetJavaEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }
    
    public void add(Produit p){
        em.persist(p);
    }
    
    public void update(Produit produit){
        em.merge(produit);
    }
    
    public void delete(int id){
        Produit p = em.find(Produit.class, id);
        em.remove(p);
    }
    
    public Produit findById(Integer id){
        Produit produit = (Produit)em.find(Produit.class, id);
        return produit;
    }
    
    public List<Produit> findByNom(String nom){
        Query query = em.createNamedQuery("Produit.findByNom");
        query.setParameter("nom", nom);
        List<Produit> produits = (List<Produit>)query.getResultList();
        return produits;
    }
    
    public List<Produit> findClientCommande(int id){
        Query query = em.createNamedQuery("Produit.findClientCommande");
        query.setParameter("idClient", id);
        List<Produit> produits = (List<Produit>)query.getResultList();
        return produits;
    }
    
    public List<Produit> findByModele(String modele){
        Query query = em.createNamedQuery("Produit.findByModele");
        query.setParameter("modele", modele);
        List<Produit> produits = (List<Produit>)query.getResultList();
        return produits;
    }
    
    public List<Produit> findByType(String type){
        Query query = em.createNamedQuery("Produit.findByType");
        query.setParameter("type", type);
        List<Produit> produits = (List<Produit>)query.getResultList();
        return produits;
    }
    
    public List<Produit> findByPrix(String prix){
        Query query = em.createNamedQuery("Produit.findByPrix");
        query.setParameter("prix", Double.parseDouble(prix));
        List<Produit> produits = (List<Produit>)query.getResultList();
        return produits;
    }
    
    public List<Produit> findByCategorie(String cat){
        Query query = em.createNamedQuery("Produit.findByCategorie");
        query.setParameter("categorie", cat);
        List<Produit> produits = (List<Produit>)query.getResultList();
        return produits;
    }
    
    public List<Produit> findByNomAndCat(String nom, String cat){
       Query query = em.createNamedQuery("Produit.findByNomAndCat");
        query.setParameter("categorie", cat);
        query.setParameter("nom", nom);
        List<Produit> produits = (List<Produit>)query.getResultList();
        return produits;
    }
    
    
    public List<Produit> findAll(){
        Query query = em.createNamedQuery("Produit.findAll");
        List<Produit> produits = (List<Produit>)query.getResultList();
        return produits;
    }
    
    public List<Produit> findLike(String s, String critere){
        List<Produit> p;
        if(critere.equals("nom")){
            p = findByNom(s);
        }else if(critere.equals("modele")){
            p = findByModele(s);
        }else if(critere.equals("type")){
            p = findByType(s);
        }else if(critere.equals("categorie")){
            p = findByCategorie(s);
        }else{
            p = findByNomAndCat(s, critere);
        }
        return p;
    }
}
