package fr.uga.l3miage.photonum.cadre;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public record CadreDTO(
    Long id,
    @NotBlank(message = "date doit être donné pour un Cadre")
    Date date,

    @NotBlank(message = "La mise en page est obligatoire pour un cadre")
    String miseEnPage
) {
    
}
