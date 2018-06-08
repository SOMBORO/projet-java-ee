/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.controleurs;

import edu.ensit.projetjavaee.modeles.Client;
import edu.ensit.projetjavaee.modeles.Commande;
import edu.ensit.projetjavaee.modeles.FicheTechnique;
import edu.ensit.projetjavaee.modeles.Formulaire;
import edu.ensit.projetjavaee.modeles.Fournisseur;
import edu.ensit.projetjavaee.modeles.NOM_A_Z;
import edu.ensit.projetjavaee.modeles.NOM_Z_A;
import edu.ensit.projetjavaee.modeles.Panier;
import edu.ensit.projetjavaee.modeles.PrixCroissant;
import edu.ensit.projetjavaee.modeles.PrixDecroissant;
import edu.ensit.projetjavaee.modeles.Produit;
import edu.ensit.projetjavaee.services.ClientFacade;
import edu.ensit.projetjavaee.services.CommandeFacade;
import edu.ensit.projetjavaee.services.FicheTechniqueFacade;
import edu.ensit.projetjavaee.services.FournisseurFacade;
import edu.ensit.projetjavaee.services.ProduitFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 *
 * @author SOMBORO
 */
@WebServlet(name = "Controleur", urlPatterns = {"/Controleur"})
public class Controleur extends HttpServlet  implements HttpSessionBindingListener{
    @EJB
    private ClientFacade clientFacade;
    @EJB
    private ProduitFacade produitFacade;
    @EJB
    private FournisseurFacade fournisseurFacade;
    @EJB
    private FicheTechniqueFacade ficheTechniqueFacade;
    @EJB
    private CommandeFacade commandeFacade;
    
    private Client client;
    private Produit produit;
    private List<Produit> produits;
    private Fournisseur fournisseur;
    private List<Fournisseur> fournisseurs;
    private FicheTechnique ficheTechnique;
    
    HttpSession session;
    
    Formulaire form;
    Commande commande;
    
    Panier panier;
    
    List<Produit> commandes;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("q") != null && !request.getParameter("q").isEmpty()){
            if(request.getParameter("q").equals("connexion")){
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/profil.jsp").forward(request, response);
            }else if(request.getParameter("q").equals("inscription")){
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/inscription.jsp").forward(request, response);
            }else if(request.getParameter("q").equals("deconnexion")){
                stopSession();
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/accueil.jsp").forward(request, response);
            }else{
                String catProduit = request.getParameter("q");
                chargerProduits(catProduit,request);
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/vue.jsp").forward(request, response);
            }
        }
        else if(request.getParameter("search") != null && !request.getParameter("search").isEmpty()){
            search(request.getParameter("search"), request.getParameter("cat"), request);
            request.setAttribute("tri", request.getParameter("search"));
            this.getServletContext().getRequestDispatcher("/WEB-INF/include/vue.jsp").forward(request, response);
        }
        else if(request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
            getFicheTechnique(Integer.parseInt(request.getParameter("id")), request);
            this.getServletContext().getRequestDispatcher("/WEB-INF/include/decri.jsp").forward(request, response);
        }
        else if(request.getParameter("tri") != null){
            if(request.getParameter("produit") != null && !request.getParameter("produit").isEmpty()){
                search(request.getParameter("produit"), request.getParameter("cat"), request);
            }else{
                chargerProduits(request.getParameter("cat"), request);
            }
            trier(request.getParameter("cri"), this.produits);
            request.setAttribute("produits", this.produits);
            this.getServletContext().getRequestDispatcher("/WEB-INF/include/vue.jsp").forward(request, response);
        }
        else if(request.getParameter("panier") != null && !request.getParameter("panier").isEmpty()){
            this.produit = produitFacade.findById(Integer.parseInt(request.getParameter("panier")));
            this.panier = (Panier)this.session.getAttribute("panier");
            this.panier.add(this.produit);
            this.session.setAttribute("panier", this.panier);
            chargerProduits(request.getParameter("cat"), request);
            this.getServletContext().getRequestDispatcher("/WEB-INF/include/vue.jsp").forward(request, response);
        }
        else if(request.getParameter("annuler") != null){
            this.produit = produitFacade.findById(Integer.parseInt(request.getParameter("annuler")));
            this.panier = (Panier)this.session.getAttribute("panier");
            this.panier.removeProduit(this.produit);
            this.session.setAttribute("panier", this.panier);
            this.getServletContext().getRequestDispatcher("/WEB-INF/include/profil.jsp").forward(request, response);
        }
        else if(request.getParameter("commander") != null){
            this.client = (Client)this.session.getAttribute("client");
            this.produit = produitFacade.findById(Integer.parseInt(request.getParameter("commander")));
            this.commande = new Commande(this.client.getId(), this.produit.getId());
            this.commande.setDateCommande(new Date());
            this.commande.setQte(1);
            this.commande.setTotal(this.produit.getPrix());
            commandeFacade.add(this.commande);
            this.panier = (Panier) this.session.getAttribute("panier");
            this.panier.removeProduit(this.produit);
            this.commandes.add(this.produit);
            
            this.session.setAttribute("commandes", this.commandes);
            this.session.setAttribute("panier", this.panier);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/include/profil.jsp").forward(request, response);
        }
        else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/include/accueil.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("login") != null){
            stopSession();
            this.client = clientFacade.findByEmail(request.getParameter("email"));

            if(this.client == null){
                request.setAttribute("login", "Login incorrect !!!");
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/profil.jsp").forward(request, response);
            }
            else if(!this.client.getPassword().equals(request.getParameter("password"))){
                request.setAttribute("email", this.client.getEmail());
                request.setAttribute("password", "password Incorrect !!!");
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/profil.jsp").forward(request, response);
            }
            else{
                startSession(request);
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/accueil.jsp").forward(request, response);
            }
        }
        else if(request.getParameter("logon") != null){
            logon(request);
            if(!this.form.getErreurs().isEmpty()){
                request.setAttribute("formulaire", this.form);
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/inscription.jsp").forward(request, response);
            }
            else{
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/accueil.jsp").forward(request, response);
            }
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void search(String s, String cri, HttpServletRequest request){
        this.produits = produitFacade.findLike(s, cri);
        this.fournisseurs = fournisseurFacade.findByType(request.getParameter("cat"));
        request.setAttribute("cat", request.getParameter("cat"));
        request.setAttribute("tri", request.getParameter("produit"));
        request.setAttribute("produits", this.produits);
        request.setAttribute("fournisseurs", this.fournisseurs);
    }
    
    public void chargerProduits(String categorie, HttpServletRequest request){
        this.produits = produitFacade.findByCategorie(categorie);
        this.fournisseurs = fournisseurFacade.findByType(categorie);
        request.setAttribute("produits", this.produits);
        request.setAttribute("fournisseurs", this.fournisseurs);
        request.setAttribute("cat", categorie);
    }
    
    public void getFicheTechnique(int id,HttpServletRequest request){
        this.produit = produitFacade.findById(id);
        int idF = (int)this.produit.getIdFournisseur().getId();
        this.ficheTechnique = ficheTechniqueFacade.findById(idF, id);
        request.setAttribute("produit", this.produit);
        request.setAttribute("fiche", ficheTechnique);
    }
    
    
    private void logon(HttpServletRequest request){
        stopSession();
        this.form = new Formulaire(request);
        this.form.setClient();
        this.form.setErreurs();
        this.client = clientFacade.findByEmail(request.getParameter("email"));
        if(this.client != null){
            this.form.setErreursEmail();
        }else{
            if(this.form.getErreurs().isEmpty()){
                this.client = this.form.getClient();
                clientFacade.add(this.client);
                startSession(request);
            }
        }
    }
    
    private void startSession(HttpServletRequest request){
        this.session = request.getSession(true);
        this.panier = new Panier();
        this.commandes = produitFacade.findClientCommande(16);
        this.session.setAttribute("client", this.client);
        this.session.setAttribute("panier", this.panier);
        this.session.setAttribute("commandes", this.commandes);
    }
    
    private void stopSession(){
        if(this.session != null){
            this.session.removeAttribute("client");
            this.session.removeAttribute("panier");
            this.session.removeAttribute("commandes");
            this.session = null;
        }
    }
    
    private void trier(String cri, List<Produit> p){
        
        if(cri.equals("az")){
            Collections.sort(p, new NOM_A_Z());
        }
        else if(cri.equals("za")){
            Collections.sort(p, new NOM_Z_A());
        }
        else if(cri.equals("prixC")){
            Collections.sort(p, new PrixCroissant());
        }
        else{
            Collections.sort(p, new PrixDecroissant());
        }
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
