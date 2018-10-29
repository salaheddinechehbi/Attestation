/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author salah
 */
@Entity
public class EtudiantEtablissement {
    
    @EmbeddedId
    private EtudiantEtablissementPk id;
    @JoinColumn(name = "etudiant" , referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Etudiant etudiant;
    @JoinColumn(name = "etablissement" , referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Etablissement etablissement;
    private String decision;
    private int numDossier;

    public EtudiantEtablissement(Etudiant etudiant, Etablissement etablissement, String decision, int numDossier) {
        this.etudiant = etudiant;
        this.etablissement = etablissement;
        this.decision = decision;
        this.numDossier = numDossier;
    }

    public EtudiantEtablissement() {
    }

    public int getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(int numDossier) {
        this.numDossier = numDossier;
    }

    
    public EtudiantEtablissementPk getId() {
        return id;
    }

    public void setId(EtudiantEtablissementPk id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }
    
    
}
