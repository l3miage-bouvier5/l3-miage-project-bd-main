package fr.uga.l3miage.photonum.impression;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public record ImpressionDTO(
    Long id,
    @NotBlank(message = "Date of the impression is mandatory")
    Date date
) {
}
