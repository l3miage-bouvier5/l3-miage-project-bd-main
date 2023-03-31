package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "Client")
public class Client {
    
    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "adresse_mail")
    private String adresseMail;


    @Column(name = "nom")
    private String nom;


    @Column(name = "prenoms")
    private String prenoms;


    @Column(name = "mot_de_passe")
    private String motDePasse;


    @ManyToMany
    List<Adresse> adressesPostales;


    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;


    @OneToMany(mappedBy = "proprietaireImage")
    private List<Image> images;

    @OneToMany(mappedBy = "proprietaireImpression")
    private List<Impression> impressions;

    public List<Impression> getImpressions() {
        return impressions;
    }

    public void setImpressions(List<Impression> impressions) {
        this.impressions = impressions;
    }



    public Long getId() {
        return id;
    }




    public String getAdresseMail() {
        return adresseMail;
    }


    public void setAdresseMail(String adrMail) {
        this.adresseMail = adrMail;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenoms() {
        return prenoms;
    }


    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }


    public String getMotDePasse() {
        return motDePasse;
    }


    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public List<Adresse> getAdressesPostales() {
        return adressesPostales;
    }

    public void setAdressesPostales(List<Adresse> adressesPostales) {
        this.adressesPostales = adressesPostales;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Client) || other == null){
            return false;
        }

        Client otherClient = (Client) other;

        return otherClient.adresseMail.equals(this.adresseMail); 
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
