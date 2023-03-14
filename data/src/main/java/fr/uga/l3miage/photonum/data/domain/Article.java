package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

enum Qualite{ //A COMPLETER ...?
    MAT,
    BRILLANT
}

enum Format{ //A COMPLETER
    A1,
    A2,
    A3,
    A4,
    A5
}

public class Article {

    @Id
    @GeneratedValue
    @Column(name="artId")
    private Long id;

    @GeneratedValue
    @Column(name="refArticle")
    private String ref;

    @Column(name="prixArticle")
    private float prix;

    @Column(name="qualiteArticle")
    private Qualite qualite;

    @Column(name="formatArticle")
    private Format format;

    @Column(name="quantiteCmd")
    private int quantite;

    // (UML) Relation AppartientA
    @ManyToOne
    private Catalogue catalogue;

    // (UML) Relation ContientArticles
    @ManyToMany
    private Commande commande;
    
}
