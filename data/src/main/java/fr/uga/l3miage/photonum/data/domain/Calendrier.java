package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Entity
public class Calendrier extends Impression{
    
    @Column(name = "annee")
    private Long annee;
    
    @ManyToMany(mappedBy="calendriers")
    private Page[] pages = new Page[12];

    public Long getAnnee() {
        return annee;
    }

    public void setAnnee(Long annee) {
        this.annee = annee;
    }

    public void setPages(Page[] pages) {
        this.pages = pages;
    }
    
    @Override
    public List<Article> getArticles() {
        // TODO Auto-generated method stub
        return super.getArticles();
    }

    
    public Page[] getPages() {
        return pages;
    }
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Calendrier)){
            return false;
        }

        Calendrier otherCalendrier = (Calendrier) other;

        return otherCalendrier.getPages().equals(this.pages)
        && otherCalendrier.annee.equals(this.annee);
    }
}
