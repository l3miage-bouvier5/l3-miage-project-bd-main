package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Client;
import fr.uga.l3miage.photonum.service.base.BaseService;

import java.util.Collection;

public interface ClientService extends BaseService<Client, Long> {

    Client save(Client impression);

    void delete(Long id) throws EntityNotFoundException;

}