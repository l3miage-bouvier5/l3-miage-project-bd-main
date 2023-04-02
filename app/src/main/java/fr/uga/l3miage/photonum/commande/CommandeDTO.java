package fr.uga.l3miage.photonum.commande;

import java.util.Date;
import java.util.List;

import fr.uga.l3miage.photonum.data.domain.Article;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CommandeDTO (
    Long id,

    @NotNull(message = "date of the order is mandatory")
    Date date,

    @NotNull(message = "validation status of the order is mandatory")
    boolean validee,

    @NotNull(message = "List of articles of the order is mandatory")
    List<Article> articles
){}
