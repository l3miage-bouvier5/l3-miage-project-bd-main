package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class EntreeCatalogue {

    @Id
    @GeneratedValue
    @Column(name="idEntree")
    private Long id;

    @Column(name="refEntree")
    private String ref;

    @Column(name="prixEntree")
    private float prix;

    // (UML) Relation ContientEntrees
    @ManyToOne
    private Catalogue catalogue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof EntreeCatalogue)){
            return false;
        }

        EntreeCatalogue otherEntreeCatalogue = (EntreeCatalogue) other;
        
        return otherEntreeCatalogue.getRef().equals(this.ref)
        && otherEntreeCatalogue.getCatalogue().equals(this.catalogue);
    }
}
