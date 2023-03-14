package fr.uga.l3miage.photonum.data.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Album extends Impression{
    
    @Column( name = "titreCouverture")
    private String titreCouverture;

    @ManyToOne
    private Photo couverture;

    @ManyToMany(mappedBy="albums")
    private List<Page> pages = new ArrayList<Page>();

    public String getTitreCouverture() {
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
        return this.pages;
    }

    
    public Photo getCouverture() {
        return couverture;
    }
    
    public void setCouverture(Photo couverture) {
        this.couverture = couverture;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
    
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Album)){
            return false;
        }
        Album otherAlbum = (Album) other;
    
        return otherAlbum.getPages().equals(this.pages)
        && otherAlbum.getTitreCouverture().equals(this.titreCouverture)
        && otherAlbum.getCouverture().equals(this.couverture);
    }
}
