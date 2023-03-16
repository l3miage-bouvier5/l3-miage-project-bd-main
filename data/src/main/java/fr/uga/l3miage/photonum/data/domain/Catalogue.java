package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Catalogue {

    // (UML) Relation ContientEntrees
    @OneToMany(mappedBy = "catalogue")
    private List<EntreeCatalogue> entreesCatalogue;

    public List<EntreeCatalogue> getEntreesCatalogue() {
        return entreesCatalogue;
    }

    public void setEntreesCatalogue(List<EntreeCatalogue> entreesCatalogue) {
        this.entreesCatalogue = entreesCatalogue;
    }
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Catalogue) || other == null){
            return false;
        }

        Catalogue otherCatalogue = (Catalogue) other;


        return otherCatalogue.getEntreesCatalogue().equals(this.entreesCatalogue);
    }
}
