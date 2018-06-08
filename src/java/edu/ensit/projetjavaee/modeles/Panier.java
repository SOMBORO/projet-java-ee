/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author SOMBORO
 */
public class Panier {
    int nbProduit;
     List<Produit> list;
    Map<Produit, Integer> panier;
    
    public Panier(){
        this.nbProduit = 0;
        this.panier = new HashMap<Produit, Integer>();
        this.list = new ArrayList<Produit>();
    }
    
    public Map<Produit, Integer> getMap(){
        return this.panier;
    }
    
    public void add(Produit p){
        if((this.panier.containsKey(p))){
            int qte = this.panier.get(p);
            this.panier.replace(p, qte+1);
        }else{
            this.nbProduit++;
            this.panier.put(p, 1);
            this.list.add(p);
        }
    }
    
    public void removeProduit(Produit p){
        if((this.panier.containsKey(p))){
            int qte = this.panier.get(p);
            if(qte <= 1){
                this.nbProduit--;
                if(this.nbProduit <= 0){
                    this.nbProduit = 0;
                }
                this.panier.remove(p);
                this.list.remove(p);
            }
            else{
                this.panier.replace(p, qte-1);
            }
        }
    }
    
    public int getQte(Produit p){
        if(this.panier.containsKey(p)){
            return this.panier.get(p);
        }else{
            return 1;
        }
    }
    
    public List<Produit> getAll(){
        return this.list;
    }
    
    public int getNbProduit(){
        return this.nbProduit;
    }
}
