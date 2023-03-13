package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.OneToMany;

public class Catalogue {

    // (UML) Relation ContientEntrees
    @OneToMany
    private EntreesCatalogue entree;
}
