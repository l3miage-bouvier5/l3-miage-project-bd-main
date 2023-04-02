package fr.uga.l3miage.photonum.catalogue;

import jakarta.validation.constraints.NotBlank;

public record CatalogueDTO(
    Long id,

    @NotBlank(message = "name of the catalogue is mandatory")
    String nom
    
) {
}
