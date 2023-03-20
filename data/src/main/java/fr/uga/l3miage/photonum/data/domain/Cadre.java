package fr.uga.l3miage.photonum.data.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;




@Entity
public class Cadre extends Impression{
    
    @Column(name = "taille_cadre")
    private TailleCadre taille;

    @Column(name = "qualite_cadre")
    private QualiteCadre qualiteCadre;

    @Column(name="mise_en_page")
    private String miseEnPage;

    @ManyToMany
    private Set<Photo> photos;



    public TailleCadre getTaille() {
        return taille;
    }

    public void setTaille(TailleCadre taille) {
        this.taille = taille;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    
    public QualiteCadre getQualiteCadre() {
        return qualiteCadre;
    }
    
    public void setQualiteCadre(QualiteCadre qualiteCadre) {
        this.qualiteCadre = qualiteCadre;
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

        return otherCadre.getQualiteCadre().equals(this.qualiteCadre)
        && otherCadre.getTaille().equals(this.taille)
        && otherCadre.getPhotos().equals(this.photos)
        && otherCadre.getMiseEnPage().equals(this.miseEnPage);
    }

}
