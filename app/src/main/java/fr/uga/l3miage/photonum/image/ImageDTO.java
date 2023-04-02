package fr.uga.l3miage.photonum.image;

import jakarta.validation.constraints.NotBlank;

public record ImageDTO(
    Long id,
    String infoPriseDeVue,
    @NotBlank(message = "le chemin d'accès d'une image est obligatoire")
    String cheminAcces,
    @NotBlank(message = "la resolution d'une image est obligatoire")
    Integer resolution,
    @NotBlank(message = "le partage d'une image doit être précisé")
    boolean partage
) {
    
}
