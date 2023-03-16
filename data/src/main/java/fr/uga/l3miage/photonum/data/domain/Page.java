package fr.uga.l3miage.photonum.data.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Page {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "page")
    private List<Photo> photos;
    
    @ManyToMany
    private List<Calendrier> calendriers;

    @ManyToMany
    private List<Album> albums;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Calendrier> getCalendriers() {
        return calendriers;
    }

    public void setCalendriers(List<Calendrier> calendriers) {
        this.calendriers = calendriers;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Page) || other == null){
            return false;
        }
        Page otherPage = (Page) other;
        
        return otherPage.getPhotos().equals(this.photos) 
        && otherPage.getCalendriers().equals(this.calendriers) 
        && otherPage.getAlbums().equals(this.albums);
    }
}
