package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Calendrier;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface CalendrierService  extends BaseService<Calendrier, Long>{
    Calendrier save(Calendrier calendrier, Long idClient) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;
}
