package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Catalogue;
import fr.uga.l3miage.photonum.data.repo.CatalogueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class CatalogueServiceImpl implements CatalogueService {

    private final CatalogueRepository catalogueRepository;

    @Autowired
    public CatalogueServiceImpl(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }


    @Override
    public Catalogue save(Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
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
    public Catalogue update(Catalogue object) throws EntityNotFoundException {
        return catalogueRepository.save(object);
    }


    @Override
    public void delete(Long id) throws EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
