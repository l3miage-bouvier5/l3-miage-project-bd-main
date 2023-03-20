package fr.uga.l3miage.photonum.client;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO entityToDTO(Client client);

    Collection<ClientDTO> entityToDTO(Iterable<Client> clients);

    Client dtoToEntity(ClientDTO clientDTO);

    Collection<Client> dtoToEntity(Iterable<ClientDTO> clientsDTO);
}
