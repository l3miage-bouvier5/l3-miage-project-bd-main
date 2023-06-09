package fr.uga.l3miage.photonum.commande;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Commande;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    CommandeDTO entityToDTO(Commande commande);

    Collection<CommandeDTO> entityToDTO(Iterable<Commande> commandes);

    Commande dtoToEntity(CommandeDTO commandeDTO);

    Collection<Commande> dtoToEntity(Iterable<CommandeDTO> commandesDTO);
}
