package fr.uga.l3miage.photonum.data.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;




@Entity
public class Cadre extends Impression{
    
    @Column(name = "taille_cadre")
    private Format taille;

    @Column(name="mise_en_page")
    private String miseEnPage;

    @ManyToMany
    private Set<Photo> photos;
    

    public Format getTaille() {
        return taille;
    }

    public void setTaille(Format taille) {
        this.taille = taille;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    
    public String getMiseEnPage() {
        return miseEnPage;
    }
    
    public void setMiseEnPage(String miseEnPage) {
        this.miseEnPage = miseEnPage;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Cadre) || other == null){
            return false;
        }
        Cadre otherCadre = (Cadre) other;

        return otherCadre.getTaille().equals(this.taille)
        && otherCadre.getPhotos().equals(this.photos)
        && otherCadre.getMiseEnPage().equals(this.miseEnPage);
    }

}
