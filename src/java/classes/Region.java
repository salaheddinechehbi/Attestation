/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author salah
 */
@Entity
public class Region {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String code;

    public Region(String nom, String code) {
        this.nom = nom;
        this.code = code;
    }
    
    public Region() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Region(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
