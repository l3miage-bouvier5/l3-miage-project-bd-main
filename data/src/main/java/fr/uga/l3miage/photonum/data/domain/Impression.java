package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public abstract class Impression {

    @Id
    @GeneratedValue
    private Long id; // remplacer car String si besoin

    @Temporal(TemporalType.DATE)
    private Date date;

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
