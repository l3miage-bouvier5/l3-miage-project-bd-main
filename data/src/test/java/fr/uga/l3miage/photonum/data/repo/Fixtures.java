package fr.uga.l3miage.photonum.data.repo;

import com.github.javafaker.Faker;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Album;
import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Page;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.data.domain.Tirage;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fixtures {

    private static final Faker FAKER = Faker.instance(new Random(42));

    public static Tirage newTirage() {
        Tirage tirage = new Tirage();
        // ...
        return tirage;
    }

    public static Adresse newAdresse() {
        Adresse adresse = new Adresse();
        adresse.setCodePostal(Integer.parseInt(FAKER.address().zipCode()));
        // adresse.setNomRue();
        // adresse.setNumDePorte();
        // adresse.setVille();
        return adresse;
    }
    
    public static Album newAlbum() {
        Album album = new Album();
        // ...
        return album;
    }
    
    public static Article newArticle() {
        Article article = new Article();
        // ...
        return article;
    }
    
        public static Page newPage() {
        Page page = new Page();
        // ...
        return page;
    }

    public static Client newClient(){
        Client client = new Client();
        client.setNom(FAKER.name().name());
        client.setAdresseMail(FAKER.internet().emailAddress());
        return client;
    }

    public static Impression newImpression(Client client, Date date, Article... articles){
        Impression impr = new Impression();
        impr.setProprietaireImpression(client);
        impr.setDate(date);
        return impr;
    }

}
