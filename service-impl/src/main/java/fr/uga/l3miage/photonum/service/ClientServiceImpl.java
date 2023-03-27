package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.domain.Commande;
import fr.uga.l3miage.photonum.data.domain.Image;
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
    private final ImageService imageService;
    private final CommandeService commandeService;
    private final AdresseService adresseService;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ImpressionService impressionService, ImageService imageService, CommandeService commandeService, AdresseService adresseService) {
        this.clientRepository = clientRepository;
        this.impressionService = impressionService;
        this.imageService = imageService;
        this.commandeService = commandeService;
        this.adresseService = adresseService;
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

        List<Image> images = client.getImages();

        if(images != null){
            for(Image im : images){
                imageService.delete(im.getId());
            }
        }

        List<Commande> commandes = client.getCommandes();

        if(commandes != null){
            for(Commande co : commandes){
                commandeService.delete(co.getId());
            }
        }


        List<Adresse> adresses = client.getAdressesPostales();

        if(adresses != null){
            for(Adresse ad: adresses){
                adresseService.delete(ad.getId());
            }
        }

        clientRepository.delete(client);
    }


}
