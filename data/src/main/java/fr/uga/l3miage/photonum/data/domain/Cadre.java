package fr.uga.l3miage.photonum.data.domain;

import java.util.HashSet;
import java.util.Set;

import fr.uga.l3miage.photonum.data.repo.ImpressionRepository;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;

public class Cadre extends Impression{
    
    @Column(name = "tailleCadre")
    private TailleCadre taille;

    @Column(name = "qualiteCadre")
    private QualiteCadre cadre;

    @ManyToMany
    private Set<Photo> photos = new HashSet<Photo>();
}
