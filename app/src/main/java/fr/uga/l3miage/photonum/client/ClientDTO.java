package fr.uga.l3miage.photonum.client;

import jakarta.validation.constraints.NotBlank;

public record ClientDTO(
    Long id,
    @NotBlank(message = "l'adresse mail du client doit être complète et valide")
    String adresseMail,
    @NotBlank(message = "le nom doit exister")
    String nom,
    @NotBlank(message = "L'utilisateur doit avoir un mdp")
    String motDePasse
) {
    
}
