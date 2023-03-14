package fr.uga.l3miage.photonum.data.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class Tirage extends Impression{
    
    @OneToMany
    private Set<Photo> photos = new HashSet<Photo>();

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }
}
