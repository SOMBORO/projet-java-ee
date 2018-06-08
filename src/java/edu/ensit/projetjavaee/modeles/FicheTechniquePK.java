/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.modeles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author SOMBORO
 */
@Embeddable
public class FicheTechniquePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Fournisseur")
    private int idFournisseur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Produit")
    private int idProduit;

    public FicheTechniquePK() {
    }

    public FicheTechniquePK(int idFournisseur, int idProduit) {
        this.idFournisseur = idFournisseur;
        this.idProduit = idProduit;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFournisseur;
        hash += (int) idProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FicheTechniquePK)) {
            return false;
        }
        FicheTechniquePK other = (FicheTechniquePK) object;
        if (this.idFournisseur != other.idFournisseur) {
            return false;
        }
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ensit.projetjavaee.modeles.FicheTechniquePK[ idFournisseur=" + idFournisseur + ", idProduit=" + idProduit + " ]";
    }
    
}
