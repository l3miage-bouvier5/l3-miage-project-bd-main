package fr.uga.l3miage.photonum.adresse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdresseDTO(
    Long id,
    
    int numDePorte,

    @NotBlank(message = "street no of the adress is mandatory")
    String nomRue,

    String ville,

    @NotNull(message = "postal code of the adress is mandatory")
    int codePostal
    
) {
}
