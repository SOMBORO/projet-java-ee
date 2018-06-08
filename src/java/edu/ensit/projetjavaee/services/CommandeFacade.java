/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.services;

import edu.ensit.projetjavaee.modeles.Commande;
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
public class CommandeFacade extends AbstractFacade<Commande> {

    @PersistenceContext(unitName = "projetJavaEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
    public List<Commande> findAll(){
        Query query = em.createNamedQuery("Commande.findAll");
        List<Commande>Commandes = (List<Commande>)query.getResultList();
        return Commandes;
    }
    
    public List<Commande> findClientCommande(int id){
        Query query = em.createNamedQuery("Commande.findClientCommande");
        query.setParameter("id_Client", id);
        List<Commande>Commandes = (List<Commande>)query.getResultList();
        return Commandes;
    }
    
    public void add(Commande commande){
        em.persist(commande);
    }
    
}
