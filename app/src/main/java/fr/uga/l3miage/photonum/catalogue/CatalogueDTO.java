package fr.uga.l3miage.photonum.catalogue;

import fr.uga.l3miage.photonum.data.domain.Format;
import fr.uga.l3miage.photonum.data.domain.Qualite;
import jakarta.validation.constraints.NotNull;

public record CatalogueDTO(
    Long id,

    @NotNull(message = "price in catalogue is mandatory")
    float prix,

    Format format,

    Qualite qualite

    
) {
}
