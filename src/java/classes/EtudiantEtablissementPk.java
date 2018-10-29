/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author salah
 */
@Embeddable
public class EtudiantEtablissementPk implements Serializable{
    
    private int etudiant;
    private int etablissement;
    private int numIncription;
    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    public EtudiantEtablissementPk(int etudiant, int etablissement, int numIncription, Date dateDepart) {
        this.etudiant = etudiant;
        this.etablissement = etablissement;
        this.numIncription = numIncription;
        this.dateDepart = dateDepart;
    }

    public EtudiantEtablissementPk() {
    }

    public int getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(int etudiant) {
        this.etudiant = etudiant;
    }

    public int getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(int etablissement) {
        this.etablissement = etablissement;
    }

    public int getNumIncription() {
        return numIncription;
    }

    public void setNumIncription(int numIncription) {
        this.numIncription = numIncription;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }
    
    
    
}
