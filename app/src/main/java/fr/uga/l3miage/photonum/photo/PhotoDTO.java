package fr.uga.l3miage.photonum.photo;

import jakarta.validation.constraints.NotBlank;

public record PhotoDTO(
        Long id,
       
        String texteDescriptif,

        @NotBlank(message = "Il doit y avoir le paramètre retouche de l'image")
        String paramRetoucheImg

){  
}
