package fr.uga.l3miage.photonum.album;

import jakarta.validation.constraints.NotBlank;

public record AlbumDTO(
    @NotBlank(message = "album title is mandatory")
    String titreCouverture
    
) {
}
