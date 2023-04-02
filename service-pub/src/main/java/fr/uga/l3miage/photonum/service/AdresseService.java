package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.service.base.BaseService;

import java.util.Collection;

public interface AdresseService extends BaseService<Adresse, Long> {

    Adresse save(Long id,Adresse adresse) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;


}