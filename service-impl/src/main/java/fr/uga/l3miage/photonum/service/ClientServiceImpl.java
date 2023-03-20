package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Impression;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ImpressionService impressionService;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client get(Long id) throws EntityNotFoundException {
        return clientRepository.get(id);
    }

    @Override
    public Collection<Client> list() {
        return clientRepository.all();
    }

    @Override
    public Client update(Client client) throws EntityNotFoundException {
        return clientRepository.save(client);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Client client = get(id);
        if(client == null){
            throw new EntityNotFoundException("client with id=%d not found".formatted(id));
        }
        List<Impression> impressions= client.getImpressions();
        if(impressions != null ){
            for (Impression impr : impressions){
                impressionService.delete(impr.getId());
            }
        }

        List<>

        clientRepository.delete(client);
    }


}
