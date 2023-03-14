package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
public abstract class Impression {

    @Id
    @GeneratedValue
    private Long id; // remplacer car String si besoin

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Client proprietaireImpression;

    @OneToMany
    private List<Article> articles = new ArrayList<Article>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    };

    public Long getId() {
        return id;
    }
}
