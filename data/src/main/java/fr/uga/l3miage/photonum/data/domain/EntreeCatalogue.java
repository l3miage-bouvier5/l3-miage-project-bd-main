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
}
