package fr.uga.l3miage.photonum.catalogue;

import fr.uga.l3miage.photonum.data.domain.Catalogue;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CatalogueMapper {
    CatalogueDTO entityToDTO(Catalogue catalogue);

    Collection<CatalogueDTO> entityToDTO(Iterable<Catalogue> catalogues);

    Catalogue dtoToEntity(CatalogueDTO catalogueDTO);

    Collection<Catalogue> dtoToEntity(Iterable<CatalogueDTO> catalogues);
}