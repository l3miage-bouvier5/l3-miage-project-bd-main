package fr.uga.l3miage.photonum.photo;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Photo;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoDTO entityToDTO(Photo photo);

    Collection<PhotoDTO> entityToDTO(Iterable<PhotoDTO> photos);

    Photo dtoToEntity(PhotoDTO photoDTO);

    Collection<Photo> dtoToEntity(Iterable<PhotoDTO> photosDTO);
}
