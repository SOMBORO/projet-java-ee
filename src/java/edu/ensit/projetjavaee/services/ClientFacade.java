/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.services;

import edu.ensit.projetjavaee.modeles.Client;
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
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "projetJavaEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    public Integer add(Client client){
        em.persist(client);
        return client.getId();
    }
    
    public void update(Client client){
        em.merge(client);
    }
    
    public void delete(Client client){
        em.merge(client);
        em.remove(client);
    }
    
    public Client findById(Integer id){
        Client client = em.find(Client.class, id);
        return client;
    }
    
    public Client findByEmailPassword(String email, String password){
        Query query = em.createNamedQuery("Client.findByEmailPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<Client> client = (List<Client>)query.getResultList();
        if(client.isEmpty())
            return null;
        else
            return client.get(0);
    }
    
    public Client findByEmail(String email){
        Query query = em.createNamedQuery("Client.findByEmail");
        query.setParameter("email", email);
        List<Client> client = (List<Client>)query.getResultList();
        if(client.isEmpty())
            return null;
        else
            return client.get(0);
    }
    
    public List<Client> getL(){
        Query query = em.createNamedQuery("Client.findB");
        List<Client> c = (List<Client>)query.getResultList();
        return c;
    }
}
