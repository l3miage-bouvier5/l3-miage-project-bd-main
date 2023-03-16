package fr.uga.l3miage.photonum.data.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.OneToMany;

public class Tirage extends Impression{
    
    @OneToMany
    private Set<Photo> photos;
}
