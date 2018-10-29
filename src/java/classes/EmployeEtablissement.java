/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author salah
 */
@Entity
public class EmployeEtablissement {
    
    @EmbeddedId
    private EmployeEtablissementPK id;
    @JoinColumn(name = "employe", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Employe employe;
    @JoinColumn(name = "etablissement", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Etablissement etablissement;
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    public EmployeEtablissement(EmployeEtablissementPK id, Employe employe, Etablissement etablissement, Date dateFin) {
        this.id = id;
        this.employe = employe;
        this.etablissement = etablissement;
        this.dateFin = dateFin;
    }

    public EmployeEtablissement() {
    }

    public EmployeEtablissementPK getId() {
        return id;
    }

    public void setId(EmployeEtablissementPK id) {
        this.id = id;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    
}
