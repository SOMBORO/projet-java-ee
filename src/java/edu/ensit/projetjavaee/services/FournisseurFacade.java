/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.services;

import edu.ensit.projetjavaee.modeles.Fournisseur;
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
public class FournisseurFacade extends AbstractFacade<Fournisseur> {

    @PersistenceContext(unitName = "projetJavaEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FournisseurFacade() {
        super(Fournisseur.class);
    }
    
    public void add(Fournisseur fournisseur){
        em.persist(fournisseur);
    }
    
    public List<Fournisseur> findAll(){
        Query query = em.createNamedQuery("Fournisseur.findAll");
        List<Fournisseur> fournisseurs = (List<Fournisseur>)query.getResultList();
        return fournisseurs;
    }
    
    public List<Fournisseur> findByType(String type){
        Query query = em.createNamedQuery("Fournisseur.findByType");
        query.setParameter("typeFournisseur", type);
        List<Fournisseur> fournisseurs = (List<Fournisseur>)query.getResultList();
        return fournisseurs;
    }
    
}
