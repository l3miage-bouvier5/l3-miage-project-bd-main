package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Article;
import fr.uga.l3miage.photonum.data.domain.Calendrier;
import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.data.repo.ArticleRepository;
import fr.uga.l3miage.photonum.data.repo.CalendrierRepository;
import fr.uga.l3miage.photonum.data.repo.ClientRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class CalendrierServiceImpl implements CalendrierService {

    private final CalendrierRepository calendrierRepository;
    private final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public CalendrierServiceImpl(CalendrierRepository calendrierRepository, ClientRepository clientRepository,ArticleRepository articleRepository) {
        this.calendrierRepository = calendrierRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public Calendrier save(Calendrier calendrier, Long idClient) throws EntityNotFoundException {
        calendrierRepository.save(calendrier);
        
        bindClient(idClient,calendrier);
        
        return calendrier;
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Calendrier calendrier = calendrierRepository.get(id);
        if(calendrier == null){
            throw new EntityNotFoundException("calendrier with id=%d not found".formatted(id));
        }
        calendrierRepository.delete(calendrier);
    }

    public void bindArticle(Long id, Calendrier calendrier) throws EntityNotFoundException {
        Article article = articleRepository.get(id);
        if (article == null) {
            throw new EntityNotFoundException("article with id=%d not found".formatted(id));
        }
        article.setImpression(calendrier);
        calendrier.addArticle(article);
    }

    public void bindClient(Long id, Calendrier calendrier) throws EntityNotFoundException {
        Client client = clientRepository.get(id);
        if (client == null) {
            throw new EntityNotFoundException("client with id=%d not found".formatted(id));
        }
        client.addImpression(calendrier);
        calendrier.setProprietaireImpression(client);
    }

    @Override
    public Calendrier get(Long id) throws EntityNotFoundException {
        return calendrierRepository.get(id);
    }

    @Override
    public Collection<Calendrier> list() {
        return calendrierRepository.all();
    }

    @Override
    public Calendrier update(Calendrier object) throws EntityNotFoundException {
        return calendrierRepository.save(object);
    }
    
}
