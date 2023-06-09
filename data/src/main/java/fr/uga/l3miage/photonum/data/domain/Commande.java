package fr.uga.l3miage.photonum.data.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Commande {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="prix_total")
    private float prixTotal;

    @Column(name="validee")
    private boolean validee;

    // (UML) Relation ContientArticles
    @ManyToMany
    private List<Article> articles;

    @ManyToOne
    private Client client;
    
    @ManyToOne
    private Adresse adresseLivraison;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(Adresse adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Commande) || other == null){
            return false;
        }
        Commande otherCommande = (Commande) other;
        return otherCommande.getArticles().equals(this.articles)
        && otherCommande.getClient().equals(this.client)
        && otherCommande.getDate().equals(this.date);
    }

}
