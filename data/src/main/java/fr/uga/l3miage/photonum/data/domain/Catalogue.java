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

    float prix;

    Format format;

    Qualite qualite;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public Format getFormat() {
        return format;
    }
    public void setFormat(Format format) {
        this.format = format;
    }
    public Qualite getQualite() {
        return qualite;
    }
    public void setQualite(Qualite qualite) {
        this.qualite = qualite;
    }
}
