package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import fr.uga.l3miage.photonum.data.repo.ImpressionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class ImpressionServiceImpl implements ImpressionService {


    private final ClientRepository clientRepository;
    private final ImpressionRepository impressionRepository;

    @Autowired
    public ImpressionServiceImpl(ImpressionRepository impressionRepository, ClientRepository clientRepository) {
        this.impressionRepository = impressionRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public Impression save(Long id, Impression impression) throws EntityNotFoundException {
        impressionRepository.save(impression);
        bind(id, impression);
        return impression;
    }

    @Override
    public Impression get(Long id) throws EntityNotFoundException {
        return impressionRepository.get(id);
    }

    @Override
    public Collection<Impression> list() {
        return impressionRepository.all();
    }

    @Override
    public Impression update(Impression object) throws EntityNotFoundException {
        return impressionRepository.save(object);
    }


    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Impression impression = get(id);
        if (impression == null) {
            throw new EntityNotFoundException("impression with id=%d not found".formatted(id));
        }

        impressionRepository.delete(impression);
    }

    public void bind(Long id, Impression impression) throws EntityNotFoundException{
        Client client = clientRepository.get(id);

        if (client == null) {
            throw new EntityNotFoundException("client with id=%d not found".formatted(id));
        }

        client.addImpression(impression);
        impression.setProprietaireImpression(client);
    }


}

