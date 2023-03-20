package fr.uga.l3miage.photonum.image;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Image;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageDTO entityToDTO(Image impression);

    Collection<ImageDTO> entityToDTO(Iterable<Image> authors);

    Image dtoToEntity(ImageDTO impressionDTO);

    Collection<Image> dtoToEntity(Iterable<ImageDTO> authors);
}
