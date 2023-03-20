package fr.uga.l3miage.photonum.commande;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;

public record CommandeDTO (
    Long id,

    @NotBlank(message = "date of the order is mandatory")
    Date date,

    @NotBlank(message = "total price of the order is mandatory")
    float prixTotal,

    @NotBlank(message = "validation status of the order is mandatory")
    boolean validee
){}
