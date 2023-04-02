package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Article {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @GeneratedValue
    @Column(name="ref")
    private String ref;

    @Column(name="prix")
    private float prix;

    @Column(name="qualite")
    private Qualite qualite;

    @Column(name="impression")
    private TypeImpression typeImpression;

    @Column(name="format")
    private Format format;

    // (UML) Relation AppartientA
    @ManyToOne
    private Catalogue catalogue;

    // (UML) Relation ContientArticles
    @ManyToMany
    private List<Commande> commandes = new ArrayList<Commande>();
    

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



    public Catalogue getCatalogue() {
        return catalogue;
    }


    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }


    public void addCommande(Commande commande){
        this.commandes.add(commande);
    }


    public void removeCommande(Commande commande){
        this.commandes.remove(commande);
    }



    @Override
    public boolean equals(Object other){
        if(!(other instanceof Article) || other == null){
            return false;
        }
        Article otherArticle = (Article) other;

        return otherArticle.getImpression().equals(this.impression)
        && otherArticle.qualite.equals(this.qualite);
    }


    public TypeImpression getTypeImpression() {
        return typeImpression;
    }


    public void setTypeImpression(TypeImpression typeImpression) {
        this.typeImpression = typeImpression;
    }

}
