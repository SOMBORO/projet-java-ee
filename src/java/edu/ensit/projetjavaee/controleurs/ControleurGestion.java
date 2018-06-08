/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.controleurs;

import edu.ensit.projetjavaee.modeles.Fournisseur;
import edu.ensit.projetjavaee.modeles.Produit;
import edu.ensit.projetjavaee.services.FournisseurFacade;
import edu.ensit.projetjavaee.services.ProduitFacade;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author SOMBORO
 */
@WebServlet(name = "ControleurGestion", urlPatterns = {"/admin"})
@MultipartConfig
public class ControleurGestion extends HttpServlet {
    private Produit p;
    @EJB
    private ProduitFacade produitFacade;
    @EJB
    private FournisseurFacade fournisseurFacade;
    
    Produit produit;
    List<Produit> produits;
    
    Fournisseur fournisseur;
    List<Fournisseur> fournisseurs;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("q") != null){
            if(request.getParameter("q").equals("ajout")){
                this.fournisseurs = fournisseurFacade.findAll();
                request.setAttribute("fournisseurs", this.fournisseurs);
                request.setAttribute("type", request.getParameter("cat"));
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/editer.jsp").forward(request, response);
            }else if(request.getParameter("q").equals("refresh")){
                chargerProduits(request.getParameter("produit"), request);
            }
            else{
                chargerProduits(request.getParameter("q"), request);
            }
        }
        else if(request.getParameter("id") != null && !request.getParameter("id").isEmpty() && request.getParameter("value") != null && !request.getParameter("value").isEmpty()){
            this.produit = produitFacade.findById(Integer.parseInt(request.getParameter("id")));
            
            if(this.produit == null){
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/gestionProduits.jsp").forward(request, response);
            }
            else if(request.getParameter("value").equals("editer")){
                request.setAttribute("produit", this.produit);
                this.getServletContext().getRequestDispatcher("/WEB-INF/include/editer.jsp").forward(request, response);
            }else{
                produitFacade.delete(Integer.parseInt(request.getParameter("id")));
                chargerProduits("Ordinateur", request);
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/include/gestionProduits.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("login") != null){
            loginAsAdmin(request);
        }
        else if(request.getParameter("editer") != null){
            if(request.getParameter("editer").equals("ajouter")){
                this.produit = new Produit();
                saisirDonnees(request, this.produit);
                if(request.getPart("img") != null){
                    setProduitImg(request.getPart("img"), this.produit);
                }
                produitFacade.add(this.produit);
            }
            else{
                this.produit = produitFacade.findById(Integer.parseInt(request.getParameter("id")));
                saisirDonnees(request, this.produit);
                if(request.getPart("img") != null){
                    setProduitImg(request.getPart("img"), this.produit);
                }
                produitFacade.update(this.produit);
            }
            
            chargerProduits(request.getParameter("cat"), request);
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/include/gestionProduits.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void loginAsAdmin(HttpServletRequest request){
        if(request.getParameter("login") != null){
            if(request.getParameter("email").equals("bernard.somboro@admin.com")){
                if(request.getParameter("password").equals("MAlolo1234")){
                    request.setAttribute("admin", "true");
                }else{
                    request.setAttribute("password", "password incorrect");                    
                }
            }else{
                request.setAttribute("email", "email incorrect");                
            }
        }
    }
    
    public void chargerProduits(String categorie, HttpServletRequest request){
        this.produits = produitFacade.findByCategorie(categorie);
        request.setAttribute("produits", this.produits);
        request.setAttribute("type", categorie);
        request.setAttribute("admin", "true");
    }
    
    public void saisirDonnees(HttpServletRequest request, Produit p){
        p.setNom(request.getParameter("nom"));
        p.setModele(request.getParameter("modele"));
        p.setType(request.getParameter("type"));
        p.setCategorie(request.getParameter("cat"));
        p.setPrix(Double.parseDouble(request.getParameter("prix")));
        p.setQuantite(Integer.parseInt(request.getParameter("qte")));
        p.setCouleur(request.getParameter("couleur"));
        if(request.getParameter("nomF") != null){
            if(!request.getParameter("nomF").isEmpty()){
                this.fournisseur = new Fournisseur();
                this.fournisseur.setNom(request.getParameter("nomF"));
                this.fournisseur.setTypeFournisseur(request.getParameter("catF"));
                fournisseurFacade.add(this.fournisseur);
                p.setIdFournisseur(this.fournisseur);
            }
            else{
                p.setIdFournisseur(fournisseurFacade.find(Integer.parseInt(request.getParameter("fournisseur"))));
            }
        }
        
    }
    
    public void setProduitImg(Part imgPart, Produit p){
        try{
            InputStream in = imgPart.getInputStream();
            BufferedInputStream entree = new BufferedInputStream( in, 10240 );
            BufferedOutputStream sortie = new BufferedOutputStream( new FileOutputStream( new File("C:\\Users\\SOMBORO\\Documents\\NetBeansProjects\\projetJavaEE\\web\\images\\"+imgPart.getSubmittedFileName()) ), 10240 );
            byte[] tampon = new byte[10240];
            int longueurTampon;
            while ( ( longueurTampon = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueurTampon );
            }
            
            in.close();
            entree.close();
            sortie.close();
            
            p.setImg(imgPart.getSubmittedFileName());
            
        }catch(IOException ex){
            Logger.getLogger(ControleurGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
