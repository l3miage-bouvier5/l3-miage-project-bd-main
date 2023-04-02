package fr.uga.l3miage.photonum.data.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Catalogue {

    // (UML) Relation ContientEntrees
    @Id
    @GeneratedValue
    Long id;

    String nom;

    public Long getId() {
        return id;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
}
