package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "texte_descriptif")
    private String texteDescriptif;
    // this is optional

    @Column(name = "param_retouche_img")
    private String paramRetoucheImg;

    @ManyToOne
    private Image image;

    @ManyToMany
    private List<Tirage> tirages;
    
    @ManyToMany
    private List<Page> pages;

    @OneToMany(mappedBy = "couverture")
    private List<Album> albums;

    @ManyToMany
    private List<Cadre> cadres;

    public long getId() {
        return id;
    }

    public String getTexteDescriptif() {
        return texteDescriptif;
    }

    public void setTexteDescriptif(String text) {
        texteDescriptif = text;
    }

    public String getParamRetoucheImg() {
        return paramRetoucheImg;
    }

    public void setParamRetoucheImg(String p) {
        paramRetoucheImg = p;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image img) {
        image = img;
    }

    public List<Tirage> getTirages() {
        return tirages;
    }

    public void setTirages(List<Tirage> tirages) {
        this.tirages = tirages;
    }

    public List<Page> getPage() {
        return pages;
    }

    public void setPage(List<Page> pages) {
        this.pages = pages;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Cadre> getCadres() {
        return cadres;
    }

    public void setCadres(List<Cadre> cadres) {
        this.cadres = cadres;
    }

    // add cadres, add albums, add tirage?
    // equals, hash code


    @Override
    public boolean equals(Object other){
        if(!(other instanceof Photo) || other == null){
            return false;
        }

        Photo otherPhoto = (Photo) other;
        return otherPhoto.getImage().equals(this.image)
        && otherPhoto.getParamRetoucheImg().equals(this.paramRetoucheImg);
    }


    public List<Impression> getImpressions(){
        List<Impression> impressions = new ArrayList<>();
        impressions.addAll(this.getAlbums());
        impressions.addAll(this.getCadres());
        impressions.addAll(this.getTirages());
        for(Page p : this.getPage()){
            impressions.addAll(p.getCalendriers());
            impressions.addAll(p.getAlbums());
        }
        return impressions;
        
    }
}
