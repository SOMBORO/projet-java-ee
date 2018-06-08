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
public class CommandePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Client")
    private int idClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Produit")
    private int idProduit;

    public CommandePK() {
    }

    public CommandePK(int idClient, int idProduit) {
        this.idClient = idClient;
        this.idProduit = idProduit;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
        hash += (int) idClient;
        hash += (int) idProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandePK)) {
            return false;
        }
        CommandePK other = (CommandePK) object;
        if (this.idClient != other.idClient) {
            return false;
        }
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ensit.projetjavaee.modeles.CommandePK[ idClient=" + idClient + ", idProduit=" + idProduit + " ]";
    }
    
}
