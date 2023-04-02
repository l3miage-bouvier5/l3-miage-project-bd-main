package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "info_prise_de_vue")
    private String infoPriseDeVue;

    @Column(name = "chemin_acces")
    private String cheminAcces;

    @Column(name = "resolution")
    private Long resolution;

    @Column(name = "est_partage")
    private boolean estPartage;

    @ManyToOne
    private Client proprietaireImage;

    @OneToMany(mappedBy = "image")
    List<Photo> photos;

    public Long getId() {
        return id;
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

    // changed here
    public boolean getEstPartage() {
        return estPartage;
    }

    public void setEstPartage(Boolean p) {
        if(estPartage){
            throw new IllegalArgumentException("L'image est déjà partagée");
        }else{
            estPartage = p;
        }
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

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Image) || other == null){
            return false;
        }

        Image otherImage = (Image) other;

        return otherImage.getCheminAcces().equals(this.cheminAcces);
    }
    
    public Client getProprietaireImage() {
        return proprietaireImage;
    }

    public void setProprietaireImage(Client proprietaireImage) {
        this.proprietaireImage = proprietaireImage;
    }
}
