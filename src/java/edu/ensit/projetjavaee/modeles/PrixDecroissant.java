/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.modeles;

import java.util.Comparator;

/**
 *
 * @author SOMBORO
 */
public class PrixDecroissant implements Comparator<Produit>{
    public int compare(Produit p1, Produit p2){
        return p2.getPrix().compareTo(p1.getPrix());
    }
}    

