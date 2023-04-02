package fr.uga.l3miage.photonum.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.l3miage.photonum.data.domain.Catalogue;
import fr.uga.l3miage.photonum.data.repo.CatalogueRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class CatalogueServiceImpl implements CatalogueService {

    private final CatalogueRepository catalogueRepository;

    @Autowired
    public CatalogueServiceImpl(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Override
    public Catalogue get(Long id) throws EntityNotFoundException {
        return catalogueRepository.get(id);
    }

    @Override
    public Collection<Catalogue> list() {
        return catalogueRepository.all();
    }

    @Override
    public Catalogue update(Catalogue client) throws EntityNotFoundException {
        return catalogueRepository.save(client);
    }

    @Override
    public Catalogue save(Catalogue client) {
        return catalogueRepository.save(client);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Catalogue client = get(id);
        if(client == null){
            throw new EntityNotFoundException("client with id=%d not found".formatted(id));
        }
        
        catalogueRepository.delete(client);
    }

    
}
