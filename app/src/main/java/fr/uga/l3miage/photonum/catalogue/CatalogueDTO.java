package fr.uga.l3miage.photonum.catalogue;

import fr.uga.l3miage.photonum.data.domain.Format;
import fr.uga.l3miage.photonum.data.domain.Qualite;
import fr.uga.l3miage.photonum.data.domain.TypeImpression;
import jakarta.validation.constraints.NotBlank;

public record CatalogueDTO(
    Long id,

    @NotBlank(message = "price in catalogue is mandatory")
    float prix,

    @NotBlank(message = "printed item type is mandatory")
    TypeImpression typeImpression,

    Format format,

    Qualite qualite

    
) {
}
