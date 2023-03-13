package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class Album extends Impression{
    
    @Column( name = "titreCouverture")
    private String titreCouverture;

    @OneToOne
    private Photo couverture;

    @OneToMany
    private List<Page> pages = new ArrayList<Page>();

    public Photo getTitreCouverture() {
        return this.titreCouverture;
    }

    public void setTitreCouverture(String titreCouverture) {
        this.titreCouverture = titreCouverture;
    }

    public void addPage(Page page) {
        // TODO
    }

    public void addPages(List<Page> pages) {
        // TODO
    }

    public List<Page> getPages() {
        // TODO
        return null;
    }
}
