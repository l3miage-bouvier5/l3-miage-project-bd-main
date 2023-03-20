package fr.uga.l3miage.photonum.calendrier;

import java.util.Collection;

import org.mapstruct.Mapper;

import fr.uga.l3miage.photonum.data.domain.Calendrier;

@Mapper(componentModel = "spring")
public interface CalendrierMapper {
    CalendrierDTO entityToDTO(Calendrier calendrier);

    Collection<CalendrierDTO> entityToDTO(Iterable<Calendrier> calendriers);

    Calendrier dtoToEntity(CalendrierDTO calendrierDTO);

    Collection<Calendrier> dtoToEntity(Iterable<CalendrierDTO> calendriersDTO);
}
