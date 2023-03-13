package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

public class Calendrier extends Impression{
    
    @Column(name = "annee")
    private Long annee;
    
    public Long getAnnee() {
        return annee;
    }

    public void setAnnee(Long annee) {
        this.annee = annee;
    }

    @OneToMany
    private Page[] pages = new Page[12];
}
