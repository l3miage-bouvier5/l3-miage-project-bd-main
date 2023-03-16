package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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


@Entity
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
    

    @ManyToOne
    private Impression impression;


    public Impression getImpression() {
        return impression;
    }


    public void setImpression(Impression impression) {
        this.impression = impression;
    }


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


    public Qualite getQualite() {
        return qualite;
    }


    public void setQualite(Qualite qualite) {
        this.qualite = qualite;
    }


    public Format getFormat() {
        return format;
    }


    public void setFormat(Format format) {
        this.format = format;
    }


    public int getQuantite() {
        return quantite;
    }


    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


    public Catalogue getCatalogue() {
        return catalogue;
    }


    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }


    public Commande getCommande() {
        return commande;
    }


    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Article)){
            return false;
        }
        Article otherArticle = (Article) other;

        return otherArticle.getImpression().equals(this.impression)
        && otherArticle.getFormat().equals(this.format)
        && otherArticle.qualite.equals(this.qualite);
    }
}
