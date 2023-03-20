// package fr.uga.l3miage.photonum.adresse;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// // import fr.uga.l3miage.photonum.data.domain.Adresse;
// // // import fr.uga.l3miage.library.books.BookDTO;
// // // import fr.uga.l3miage.library.books.BooksMapper;
// // // import fr.uga.l3miage.photonum.service.AdresseService;
// // // import fr.uga.l3miage.library.service.DeleteAdresseException;
// // // import fr.uga.l3miage.library.service.EntityNotFoundException;
// // import jakarta.validation.Valid;
// // import jakarta.validation.constraints.NotNull;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.RequestParam;

// // import org.springframework.http.HttpStatus;
// // import org.springframework.http.MediaType;
// // import org.springframework.web.bind.annotation.*;
// // import org.springframework.web.server.ResponseStatusException;

// // import java.util.Collection;

// @RestController
// @RequestMapping(value = "/api/v1", produces = "application/json")
// public class AlbumController {

// //     private final AdresseService adresseService;
// //     private final AdresseMapper adresseMapper;

// //     @Autowired
// //     public AdresseController(AdresseService Service, AdresseMapper adresseMapper, BooksMapper booksMapper) {
// //         this.adresseService = adresseService;
// //         this.adresseMapper = adresseMapper;
// //         this.booksMapper = booksMapper;
// //     }

// //     @GetMapping("/adresses")
// //     public Collection<AdresseDTO> adresses(@RequestParam(value = "q", required = false) String query) {
// //         Collection<Adresse> adresses;
// //         if (query == null) {
// //             adresses = adresseService.list();
// //         } else {
// //             adresses = adresseService.searchByName(query);
// //         }
// //         return adresses.stream()
// //                 .map(adresseMapper::entityToDTO)
// //                 .toList();
// //     }

// //     @GetMapping("/adresses/{id}")
// //     public AdresseDTO adresse(@PathVariable("id") @NotNull Long id) {
// //         try {
// //             return adresseMapper.entityToDTO(adresseService.get(id));
// //         } catch (EntityNotFoundException e) {
// //             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
// //         }
// //     }

// //     @PostMapping(value = "/adresses", consumes = MediaType.APPLICATION_JSON_VALUE)
// //     @ResponseStatus(HttpStatus.CREATED)
// //     public AdresseDTO newAdresse(@RequestBody @Valid AdresseDTO adresse) {
// //         var saved = adresseService.save(adresseMapper.dtoToEntity(adresse));
// //         return adresseMapper.entityToDTO(saved);
// //     }

// //     @PutMapping(value = "/adresses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
// //     public AdresseDTO updateAdresse(@RequestBody @Valid AdresseDTO adresse, @NotNull @PathVariable("id") Long id) {
// //         try {
// //             if (adresse.id().equals(id)) {
// //                 adresseService.get(id);
// //                 var updated = adresseService.update(adresseMapper.dtoToEntity(adresse));
// //                 return adresseMapper.entityToDTO(updated);
// //             }
// //             throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
// //         } catch (EntityNotFoundException e) {
// //             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "adresse is not found", e);
// //         }
// //     }

// //     @DeleteMapping("/adresses/{id}")
// //     @ResponseStatus(HttpStatus.NO_CONTENT)
// //     public void deleteAdresse(@PathVariable("id") @NotNull Long id) {
// //         try {
// //             adresseService.delete(id);
// //         } catch (EntityNotFoundException e) {
// //             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
// //         } catch (DeleteAdresseException e) {
// //             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
// //         }
// //     }

// //     @GetMapping("/adresses/{id}/books")
// //     public Collection<BookDTO> books(@PathVariable("id") @NotNull Long adresseId) {
// //         try {
// //             var adresse = adresseService.get(adresseId);
// //             return booksMapper.entityToDTO(adresse.getBooks());
// //         } catch (EntityNotFoundException e) {
// //             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
// //         }
// //     }

// }
