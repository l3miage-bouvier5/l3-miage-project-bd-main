package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Tirage;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import fr.uga.l3miage.photonum.data.repo.TirageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class TirageServiceImpl implements TirageService {


    private final ClientRepository clientRepository;
    private final TirageRepository tirageRepository;

    @Autowired
    public TirageServiceImpl(TirageRepository tirageRepository, ClientRepository clientRepository) {
        this.tirageRepository = tirageRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public Tirage save(Long id,Tirage tirage) throws EntityNotFoundException{
        tirageRepository.save(tirage);
        bind(id, tirage);
        return tirage;

    }

    @Override
    public Tirage get(Long id) throws EntityNotFoundException {
        return tirageRepository.get(id);
    }

    @Override
    public Collection<Tirage> list() {
        return tirageRepository.all();
    }

    @Override
    public Tirage update(Tirage object) throws EntityNotFoundException {
        return tirageRepository.save(object);
    }


    public void bind(Long id, Tirage tirage) throws EntityNotFoundException {
        Client client = clientRepository.get(id);

        if (client == null) {
            throw new EntityNotFoundException("client with id=%d not found".formatted(id));
        }

        
    }


    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Tirage tirage = get(id);
        if (tirage == null) {
            throw new EntityNotFoundException("tirage with id=%d not found".formatted(id));
        }

        tirageRepository.delete(tirage);
    }
}
