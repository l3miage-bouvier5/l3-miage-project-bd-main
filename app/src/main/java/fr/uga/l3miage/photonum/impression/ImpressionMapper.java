package fr.uga.l3miage.photonum.impression;

import fr.uga.l3miage.photonum.data.domain.Impression;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ImpressionMapper {
    ImpressionDTO entityToDTO(Impression impression);

    Collection<ImpressionDTO> entityToDTO(Iterable<Impression> authors);

    Impression dtoToEntity(ImpressionDTO impressionDTO);

    Collection<Impression> dtoToEntity(Iterable<ImpressionDTO> authors);
}