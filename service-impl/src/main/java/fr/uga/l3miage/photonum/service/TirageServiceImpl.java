package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Tirage;
import fr.uga.l3miage.photonum.data.repo.TirageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class TirageServiceImpl implements TirageService {

    private final TirageRepository tirageRepository;

    @Autowired
    public TirageServiceImpl(TirageRepository tirageRepository) {
        this.tirageRepository = tirageRepository;
    }


    @Override
    public Tirage save(Tirage tirage) {
        return null;
    }

    @Override
    public Tirage get(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public Collection<Tirage> list() {
        return null;
    }

    @Override
    public Tirage update(Tirage object) throws EntityNotFoundException {
        return null;
    }
}
