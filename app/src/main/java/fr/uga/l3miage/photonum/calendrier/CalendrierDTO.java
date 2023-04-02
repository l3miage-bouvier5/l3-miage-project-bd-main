package fr.uga.l3miage.photonum.calendrier;

import jakarta.validation.constraints.NotNull;

public record CalendrierDTO (

    Long id,

    @NotNull(message = "year of the calendar is mandatory")
    Long annee
) {}
