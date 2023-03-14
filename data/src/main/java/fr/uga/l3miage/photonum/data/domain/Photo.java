package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String texteDescriptif;
    // this is optional

    private String paramRetoucheImg;

    @ManyToOne
    private Image image;

    @ManyToMany
    private List<Tirage> tirages;
    
    @ManyToOne
    private Page page;

    @OneToMany
    private List<Album> albums;

    @ManyToMany
    private List<Cadre> cadres;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page p) {
        page = p;
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
}
