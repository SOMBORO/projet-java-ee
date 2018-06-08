/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.services;

import edu.ensit.projetjavaee.modeles.FicheTechnique;
import edu.ensit.projetjavaee.modeles.FicheTechniquePK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author SOMBORO
 */
@Stateless
public class FicheTechniqueFacade extends AbstractFacade<FicheTechnique> {

    @PersistenceContext(unitName = "projetJavaEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FicheTechniqueFacade() {
        super(FicheTechnique.class);
    }
    
    public FicheTechnique findById(Integer idF, Integer idP){
//        Query query = em.createNamedQuery("FicheTechnique.find");
//        query.setParameter("id_Fournisseur", idF);
//        query.setParameter("id_Produit", idP);
        FicheTechniquePK f = new FicheTechniquePK(idF, idP);
        FicheTechnique ficheT = (FicheTechnique)em.find(FicheTechnique.class, f);
        return ficheT;
    }
    
}
