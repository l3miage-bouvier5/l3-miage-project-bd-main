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
    private List<Tirage> tirages = new ArrayList<>();
    
    @ManyToMany
    private List<Page> pages = new ArrayList<>();

    @OneToMany(mappedBy = "couverture")
    private List<Album> albums = new ArrayList<>();

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


    public List<Page> getPages() {
        return pages;
    }

    public List<Album> getAlbums() {
        return albums;
    }



    public List<Cadre> getCadres() {
        return cadres;
    }


    public void addAlbums(Album album) {
        albums.add(album);
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
        for(Page p : this.getPages()){
            impressions.addAll(p.getCalendriers());
            impressions.addAll(p.getAlbums());
        }
        return impressions;
        
    }
}
