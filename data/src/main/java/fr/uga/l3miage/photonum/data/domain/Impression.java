package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Impression {

    @Id
    @GeneratedValue
    private Long id; // remplacer car String si besoin

    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "impression")
    private List<Article> articles;

    @ManyToOne
    private Client proprietaireImpression;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    };

    public Long getId() {
        return id;
    }

    public Client getProprietaireImpression() {
        return proprietaireImpression;
    }

    public void setProprietaireImpression(Client proprietaireImpression) {
        this.proprietaireImpression = proprietaireImpression;
    }

    @Override
    public abstract boolean equals(Object other);

}
