package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.repo.AdresseRepository;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class AdresseServiceImpl implements AdresseService {

    private final ClientRepository clientRepository;
    private final AdresseRepository adresseRepository;

    @Autowired
    public AdresseServiceImpl(AdresseRepository adresseRepository, ClientRepository clientRepository) {
        this.adresseRepository = adresseRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public Adresse save(Long id,Adresse adresse) throws EntityNotFoundException{
        adresseRepository.save(adresse);
        bind(id, adresse);
        return adresse;
    }

    @Override
    public Adresse get(Long id) throws EntityNotFoundException {
        return adresseRepository.get(id);
    }

    @Override
    public Collection<Adresse> list() {
        return adresseRepository.all();
    }

    @Override
    public Adresse update(Adresse object) throws EntityNotFoundException {
        return adresseRepository.save(object);
    }


    @Override
    public void delete(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public void bind(Long id, Adresse adresse) throws EntityNotFoundException {
        Client client = clientRepository.get(id);
        if (client == null) {
            throw new EntityNotFoundException("client with id=%d not found".formatted(id));
        }
        client.addAdresse(adresse);
        adresse.addClient(client);

        
    }

    public List<Adresse> listByClient(Long id) throws EntityNotFoundException {
        Client client = clientRepository.get(id);
        if (client == null) {
            throw new EntityNotFoundException("client with id=%d not found".formatted(id));
        }
        client.getAdressesPostales().size();
        return client.getAdressesPostales();
    }
}
