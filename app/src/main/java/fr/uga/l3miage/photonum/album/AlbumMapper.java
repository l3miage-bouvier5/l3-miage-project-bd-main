package fr.uga.l3miage.photonum.album;

import fr.uga.l3miage.photonum.data.domain.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    AlbumDTO entityToDTO(Album album);

    Collection<AlbumDTO> entityToDTO(Iterable<Album> albums);

    @Mapping(target = "id", ignore = true)
    Album dtoToEntity(AlbumDTO albumDTO);

    Collection<Album> dtoToEntity(Iterable<AlbumDTO> albums);
}