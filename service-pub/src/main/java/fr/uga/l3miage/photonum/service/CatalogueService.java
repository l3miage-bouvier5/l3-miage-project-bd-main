package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Catalogue;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface CatalogueService extends BaseService<Catalogue, Long> {

    
    Catalogue save(Catalogue catalogue);

    void delete(Long id) throws EntityNotFoundException;

}

}