package fr.uga.l3miage.photonum.page;

import fr.uga.l3miage.photonum.data.domain.Page;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PageMapper {
    PageDTO entityToDTO(Page page);

    Collection<PageDTO> entityToDTO(Iterable<Page> pages);

    Page dtoToEntity(PageDTO pageDTO);

    Collection<Page> dtoToEntity(Iterable<PageDTO> pages);
}