/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author salah
 */
@Entity
public class Attestation {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date dateAttestation;
    private int numExemplair;
    @OneToOne
    private Etudiant etudiant;
    @OneToOne
    private Employe employe;

    public Attestation(Date dateAttestation, int numExemplair, Etudiant etudiant, Employe employe) {
        this.dateAttestation = dateAttestation;
        this.numExemplair = numExemplair;
        this.etudiant = etudiant;
        this.employe = employe;
    }

    public Attestation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateAttestation() {
        return dateAttestation;
    }

    public void setDateAttestation(Date dateAttestation) {
        this.dateAttestation = dateAttestation;
    }

    public int getNumExemplair() {
        return numExemplair;
    }

    public void setNumExemplair(int numExemplair) {
        this.numExemplair = numExemplair;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    
    
    
    
}
