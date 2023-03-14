package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String infoPriseDeVue;

    private String cheminAcces;
    
    private Long resolution;

    private Boolean estPartage;

    @ManyToOne
    private Client proprietaireImage;

    @OneToMany(mappedBy = "image")
    List<Photo> photos;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfoPriseDeVue() {
        return infoPriseDeVue;
    }

    public void setInfoPriseDeVue(String info) {
        infoPriseDeVue = info;
    }

    public String getCheminAcces() {
        return cheminAcces;
    }

    public void setCheminAcces(String chemin) {
        cheminAcces = chemin;
    }

    public Long getResolution() {
        return resolution;
    }

    public void setResolution(Long resolution) {
        this.resolution = resolution;
    }

    public Boolean getEstPartage() {
        return estPartage;
    }

    public void setEstPartage(Boolean p) {
        estPartage = p;
    }

    public Client getClient() {
        return this.proprietaireImage;
    }

    public void setClient(Client propieretaireImage) {
        this.proprietaireImage = propieretaireImage;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    // add photos?

    // hashcode and equals?

    
}
