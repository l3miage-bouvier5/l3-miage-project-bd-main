package fr.uga.l3miage.photonum.impression;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public record ImpressionDTO(
    Long id,
    @NotNull(message = "Date of the impression is mandatory")
    Date date
) {
}