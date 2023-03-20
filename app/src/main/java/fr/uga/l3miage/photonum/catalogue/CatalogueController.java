package fr.uga.l3miage.photonum.catalogue;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import fr.uga.l3miage.photonum.data.domain.Catalogue;
// // import fr.uga.l3miage.library.books.BookDTO;
// // import fr.uga.l3miage.library.books.BooksMapper;
// // import fr.uga.l3miage.photonum.service.CatalogueService;
// // import fr.uga.l3miage.library.service.DeleteCatalogueException;
// // import fr.uga.l3miage.library.service.EntityNotFoundException;
// import jakarta.validation.Valid;
// import jakarta.validation.constraints.NotNull;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.server.ResponseStatusException;

// import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class CatalogueController {

//     private final CatalogueService catalogueService;
//     private final CatalogueMapper catalogueMapper;

//     @Autowired
//     public CatalogueController(CatalogueService Service, CatalogueMapper catalogueMapper, BooksMapper booksMapper) {
//         this.catalogueService = catalogueService;
//         this.catalogueMapper = catalogueMapper;
//         this.booksMapper = booksMapper;
//     }

//     @GetMapping("/catalogues")
//     public Collection<CatalogueDTO> catalogues(@RequestParam(value = "q", required = false) String query) {
//         Collection<Catalogue> catalogues;
//         if (query == null) {
//             catalogues = catalogueService.list();
//         } else {
//             catalogues = catalogueService.searchByName(query);
//         }
//         return catalogues.stream()
//                 .map(catalogueMapper::entityToDTO)
//                 .toList();
//     }

//     @GetMapping("/catalogues/{id}")
//     public CatalogueDTO catalogue(@PathVariable("id") @NotNull Long id) {
//         try {
//             return catalogueMapper.entityToDTO(catalogueService.get(id));
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         }
//     }

//     @PostMapping(value = "/catalogues", consumes = MediaType.APPLICATION_JSON_VALUE)
//     @ResponseStatus(HttpStatus.CREATED)
//     public CatalogueDTO newCatalogue(@RequestBody @Valid CatalogueDTO catalogue) {
//         var saved = catalogueService.save(catalogueMapper.dtoToEntity(catalogue));
//         return catalogueMapper.entityToDTO(saved);
//     }

//     @PutMapping(value = "/catalogues/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//     public CatalogueDTO updateCatalogue(@RequestBody @Valid CatalogueDTO catalogue, @NotNull @PathVariable("id") Long id) {
//         try {
//             if (catalogue.id().equals(id)) {
//                 catalogueService.get(id);
//                 var updated = catalogueService.update(catalogueMapper.dtoToEntity(catalogue));
//                 return catalogueMapper.entityToDTO(updated);
//             }
//             throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "catalogue is not found", e);
//         }
//     }

//     @DeleteMapping("/catalogues/{id}")
//     @ResponseStatus(HttpStatus.NO_CONTENT)
//     public void deleteCatalogue(@PathVariable("id") @NotNull Long id) {
//         try {
//             catalogueService.delete(id);
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         } catch (DeleteCatalogueException e) {
//             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
//         }
//     }

//     @GetMapping("/catalogues/{id}/books")
//     public Collection<BookDTO> books(@PathVariable("id") @NotNull Long catalogueId) {
//         try {
//             var catalogue = catalogueService.get(catalogueId);
//             return booksMapper.entityToDTO(catalogue.getBooks());
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         }
//     }

}
