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
public class NOM_Z_A implements Comparator<Produit>{
    public int compare(Produit p1, Produit p2){
        return p2.getNom().compareToIgnoreCase(p1.getNom());
    }
}
