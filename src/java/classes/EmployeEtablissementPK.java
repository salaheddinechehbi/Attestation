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
public class EmployeEtablissementPK implements Serializable{
    
    private int employe;
    private int etablissement;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    public EmployeEtablissementPK(int employe, int etablissement, Date dateDebut) {
        this.employe = employe;
        this.etablissement = etablissement;
        this.dateDebut = dateDebut;
    }

    public EmployeEtablissementPK() {
    }

    public int getEmploye() {
        return employe;
    }

    public void setEmploye(int employe) {
        this.employe = employe;
    }

    public int getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(int etablissement) {
        this.etablissement = etablissement;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    
    
    
}
