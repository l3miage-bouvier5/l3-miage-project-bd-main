package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.*;

// TODO : faire le addClient pour ajouter un client à une adresse

@Entity
@Table(name = "Adresse")
public class Adresse {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "numDePorte")
    private int numDePorte;


    @Column(name = "nomRue")
    private String nomRue;


    @Column(name = "ville")
    private String ville;


    @Column(name = "codePostal")
    private int codePostal;


    @ManyToMany(mappedBy = "adressesPostales")
    List<Client> clients;


    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public int getNumDePorte() {
        return numDePorte;
    }

    public void setNumDePorte(int numDePorte) {
        this.numDePorte = numDePorte;
    }

    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Client> getClients() {
        return clients;
    }


}
