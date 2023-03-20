package fr.uga.l3miage.photonum.cadre;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Cadre;

@Mapper(componentModel = "spring")
public interface CadreMapper {
    CadreDTO entityToDTO(Cadre cadre);

    Collection<CadreDTO> entityToDTO(Iterable<Cadre> cadres);

    Cadre dtoToEntity(CadreDTO cadreDTO);

    Collection<Cadre> dtoToEntity(Iterable<CadreDTO> cadresDTO);
}

