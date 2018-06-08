/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.modeles;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author SOMBORO
 */
public class Formulaire {
    private Client client;
    private Map<String, String>erreurs;
    private HttpServletRequest request;
    
    public Formulaire(HttpServletRequest request){
        this.request = request;
        setClient();
        setErreurs();
    }
    
    public void setClient(){
        this.client = new Client();
        this.client.setEmail(this.request.getParameter("email"));
        this.client.setNom(this.request.getParameter("nom"));
        this.client.setPrenom(this.request.getParameter("prenom"));
        this.client.setPassword(this.request.getParameter("password"));
    }
    
    public Client getClient(){
        return this.client;
    }
    
    public void setErreurs(){
        erreurs = new HashMap<String, String>();
        
        if(!isEmailValid(this.request.getParameter("email"))){
            erreurs.put("email", "Email invalide!!!");
        }
        if(!isPassWordCorrect(this.request.getParameter("password"), this.request.getParameter("confirmation"))){
            erreurs.put("confirmation", "Mots de passe Incorrects !!!");
        }
        if(this.request.getParameter("password").length() == 0){
            erreurs.put("password", "Mot de passe vide !!!");
            erreurs.put("confirmation", "Mots de passe Incorrects !!!");
        }
    }
    public void setErreursEmail(){
        erreurs.replace("email", "Cet email existe deja !!!!");
    }
    
    public Map<String, String> getErreurs(){
        return this.erreurs;
    }
    
    private boolean isEmailValid( String email ){
        return email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" );
    }
    
    private boolean isPassWordCorrect( String motDePasse, String confirmation ){
        return motDePasse.equals(confirmation);
    }
}
