package fr.uga.l3miage.photonum.data.repo;

import com.github.javafaker.Faker;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Album;
import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Catalogue;
import fr.uga.l3miage.photonum.data.domain.Page;
import fr.uga.l3miage.photonum.data.domain.Photo;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.domain.Image;
import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.data.domain.Tirage;

import java.util.Date;
import java.util.Random;

public class Fixtures {

    private static final Faker FAKER = Faker.instance(new Random(42));

    public static Tirage newTirage() {
        Tirage tirage = new Tirage();
        tirage.setDate(FAKER.date().birthday());
        return tirage;
    }

    public static Adresse newAdresse() {
        Adresse adresse = new Adresse();
        adresse.setCodePostal(Integer.parseInt(FAKER.address().zipCode().replaceAll("-", "")));
        adresse.setNomRue(FAKER.address().streetName());
        adresse.setNumDePorte((int) FAKER.number().randomNumber());
        adresse.setVille(FAKER.address().city());
        return adresse;
    }

    public static Photo newPhoto() {
        Photo photo = new Photo();
        photo.setTexteDescriptif(FAKER.lorem().sentence());
        photo.setAlbums(null);
        photo.setCadres(null);
        photo.setPage(null);
        photo.setTirages(null);
        photo.setParamRetoucheImg("param");
        return photo;
    }
    
    public static Album newAlbum() {
        Album album = new Album();
        album.setDate(FAKER.date().birthday());
        album.setTitreCouverture(FAKER.book().title());
        return album;
    }
    
    public static Article newArticle() {
        Article article = new Article();
        article.setPrix(Float.parseFloat(FAKER.commerce().price()));
        article.setQuantite((int) FAKER.number().randomNumber());
        article.setRef(FAKER.code().isbn10());    
        return article;
    }
    
        public static Page newPage() {
        Page page = new Page();
        return page;
    }

    public static Client newClient(){
        Client client = new Client();
        client.setNom(FAKER.name().name());
        client.setAdresseMail(FAKER.internet().emailAddress());
        return client;
    }

    public static Impression newImpression(Client client, Date date, Article... articles) {
        Impression impr = new Impression();
        impr.setProprietaireImpression(client);
        impr.setDate(date);
        return impr;
    }

    public static Commande newCommande(){
        Commande commande = new Commande();
        commande.setDate(FAKER.date().birthday());

        Random r = new Random();
        float random = (float) (r.nextFloat() * 10.0);
        commande.setPrixTotal(random);
        commande.setValidee(FAKER.random().nextBoolean());
        return commande;
    }

    public static Image newImage() {
        Image image = new Image();
        image.setEstPartage(FAKER.random().nextBoolean());
        image.setCheminAcces(FAKER.file().fileName());
        return image;
    }

}
