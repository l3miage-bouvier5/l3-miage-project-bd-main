package fr.uga.l3miage.photonum.data.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Commande {
    
    @Id
    @GeneratedValue
    @Column(name="cmdId")
    private Long id;

    @Column(name="dateCmd")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="prixCmd")
    private float prixTotal;

    @Column(name="etatCmd")
    private boolean validee;

    // (UML) Relation ContientArticles
    @ManyToMany
    private Article article;
}
