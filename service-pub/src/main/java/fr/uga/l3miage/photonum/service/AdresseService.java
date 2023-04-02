package fr.uga.l3miage.photonum.service;

import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Adresse;
import fr.uga.l3miage.photonum.service.base.BaseService;

public interface AdresseService extends BaseService<Adresse, Long> {

    Adresse save(Long id,Adresse adresse) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;

    List<Adresse> listByClient(Long idClient) throws EntityNotFoundException;
}