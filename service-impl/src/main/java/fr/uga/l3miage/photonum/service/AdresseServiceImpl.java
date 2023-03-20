package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.repo.AdresseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;

    @Autowired
    public AdresseServiceImpl(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }


    @Override
    public Adresse save(Adresse adresse) {
        return null;
    }

    @Override
    public Adresse get(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public Collection<Adresse> list() {
        return null;
    }

    @Override
    public Adresse update(Adresse object) throws EntityNotFoundException {
        return null;
    }
}
