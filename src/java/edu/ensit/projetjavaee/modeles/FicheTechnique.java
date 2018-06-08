/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ensit.projetjavaee.modeles;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SOMBORO
 */
@Entity
@Table(name = "fiche_technique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FicheTechnique.findAll", query = "SELECT f FROM FicheTechnique f")
    , @NamedQuery(name = "FicheTechnique.findByIdFournisseur", query = "SELECT f FROM FicheTechnique f WHERE f.ficheTechniquePK.idFournisseur = :idFournisseur")
    , @NamedQuery(name = "FicheTechnique.findByIdProduit", query = "SELECT f FROM FicheTechnique f WHERE f.ficheTechniquePK.idProduit = :idProduit")
    , @NamedQuery(name = "FicheTechnique.findByEcran", query = "SELECT f FROM FicheTechnique f WHERE f.ecran = :ecran")
    , @NamedQuery(name = "FicheTechnique.findByProcesseur", query = "SELECT f FROM FicheTechnique f WHERE f.processeur = :processeur")
    , @NamedQuery(name = "FicheTechnique.findByRefProcesseur", query = "SELECT f FROM FicheTechnique f WHERE f.refProcesseur = :refProcesseur")
    , @NamedQuery(name = "FicheTechnique.findByMemoire", query = "SELECT f FROM FicheTechnique f WHERE f.memoire = :memoire")
    , @NamedQuery(name = "FicheTechnique.findByStockage", query = "SELECT f FROM FicheTechnique f WHERE f.stockage = :stockage")
    , @NamedQuery(name = "FicheTechnique.findByCamera", query = "SELECT f FROM FicheTechnique f WHERE f.camera = :camera")
    , @NamedQuery(name = "FicheTechnique.findByOs", query = "SELECT f FROM FicheTechnique f WHERE f.os = :os")
    , @NamedQuery(name = "FicheTechnique.findByCarteGraphique", query = "SELECT f FROM FicheTechnique f WHERE f.carteGraphique = :carteGraphique")
    , @NamedQuery(name = "FicheTechnique.findByRefCarteGraphique", query = "SELECT f FROM FicheTechnique f WHERE f.refCarteGraphique = :refCarteGraphique")
    , @NamedQuery(name = "FicheTechnique.findByDoubleSIM", query = "SELECT f FROM FicheTechnique f WHERE f.doubleSIM = :doubleSIM")
    , @NamedQuery(name = "FicheTechnique.findByExtensible", query = "SELECT f FROM FicheTechnique f WHERE f.extensible = :extensible")
    , @NamedQuery(name = "FicheTechnique.findByGarantie", query = "SELECT f FROM FicheTechnique f WHERE f.garantie = :garantie")})
public class FicheTechnique implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FicheTechniquePK ficheTechniquePK;
    @Size(max = 50)
    @Column(name = "ecran")
    private String ecran;
    @Size(max = 50)
    @Column(name = "processeur")
    private String processeur;
    @Size(max = 255)
    @Column(name = "ref_processeur")
    private String refProcesseur;
    @Size(max = 50)
    @Column(name = "memoire")
    private String memoire;
    @Size(max = 10)
    @Column(name = "stockage")
    private String stockage;
    @Lob
    @Size(max = 65535)
    @Column(name = "specificites")
    private String specificites;
    @Size(max = 50)
    @Column(name = "camera")
    private String camera;
    @Size(max = 50)
    @Column(name = "os")
    private String os;
    @Size(max = 50)
    @Column(name = "carte_Graphique")
    private String carteGraphique;
    @Size(max = 255)
    @Column(name = "ref_carte_graphique")
    private String refCarteGraphique;
    @Size(max = 5)
    @Column(name = "double_SIM")
    private String doubleSIM;
    @Size(max = 50)
    @Column(name = "extensible")
    private String extensible;
    @Size(max = 10)
    @Column(name = "garantie")
    private String garantie;

    public FicheTechnique() {
    }

    public FicheTechnique(FicheTechniquePK ficheTechniquePK) {
        this.ficheTechniquePK = ficheTechniquePK;
    }

    public FicheTechnique(int idFournisseur, int idProduit) {
        this.ficheTechniquePK = new FicheTechniquePK(idFournisseur, idProduit);
    }

    public FicheTechniquePK getFicheTechniquePK() {
        return ficheTechniquePK;
    }

    public void setFicheTechniquePK(FicheTechniquePK ficheTechniquePK) {
        this.ficheTechniquePK = ficheTechniquePK;
    }

    public String getEcran() {
        return ecran;
    }

    public void setEcran(String ecran) {
        this.ecran = ecran;
    }

    public String getProcesseur() {
        return processeur;
    }

    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }

    public String getRefProcesseur() {
        return refProcesseur;
    }

    public void setRefProcesseur(String refProcesseur) {
        this.refProcesseur = refProcesseur;
    }

    public String getMemoire() {
        return memoire;
    }

    public void setMemoire(String memoire) {
        this.memoire = memoire;
    }

    public String getStockage() {
        return stockage;
    }

    public void setStockage(String stockage) {
        this.stockage = stockage;
    }

    public String getSpecificites() {
        return specificites;
    }

    public void setSpecificites(String specificites) {
        this.specificites = specificites;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCarteGraphique() {
        return carteGraphique;
    }

    public void setCarteGraphique(String carteGraphique) {
        this.carteGraphique = carteGraphique;
    }

    public String getRefCarteGraphique() {
        return refCarteGraphique;
    }

    public void setRefCarteGraphique(String refCarteGraphique) {
        this.refCarteGraphique = refCarteGraphique;
    }

    public String getDoubleSIM() {
        return doubleSIM;
    }

    public void setDoubleSIM(String doubleSIM) {
        this.doubleSIM = doubleSIM;
    }

    public String getExtensible() {
        return extensible;
    }

    public void setExtensible(String extensible) {
        this.extensible = extensible;
    }

    public String getGarantie() {
        return garantie;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ficheTechniquePK != null ? ficheTechniquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FicheTechnique)) {
            return false;
        }
        FicheTechnique other = (FicheTechnique) object;
        if ((this.ficheTechniquePK == null && other.ficheTechniquePK != null) || (this.ficheTechniquePK != null && !this.ficheTechniquePK.equals(other.ficheTechniquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ensit.projetjavaee.modeles.FicheTechnique[ ficheTechniquePK=" + ficheTechniquePK + " ]";
    }
    
}
