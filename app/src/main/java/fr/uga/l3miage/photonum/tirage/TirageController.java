package fr.uga.l3miage.photonum.tirage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import fr.uga.l3miage.photonum.data.domain.Tirage;
// // import fr.uga.l3miage.library.books.BookDTO;
// // import fr.uga.l3miage.library.books.BooksMapper;
// // import fr.uga.l3miage.photonum.service.TirageService;
// // import fr.uga.l3miage.library.service.DeleteTirageException;
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
public class TirageController {

//     private final TirageService tirageService;
//     private final TirageMapper tirageMapper;

//     @Autowired
//     public TirageController(TirageService Service, TirageMapper tirageMapper, BooksMapper booksMapper) {
//         this.tirageService = tirageService;
//         this.tirageMapper = tirageMapper;
//         this.booksMapper = booksMapper;
//     }

//     @GetMapping("/tirages")
//     public Collection<TirageDTO> tirages(@RequestParam(value = "q", required = false) String query) {
//         Collection<Tirage> tirages;
//         if (query == null) {
//             tirages = tirageService.list();
//         } else {
//             tirages = tirageService.searchByName(query);
//         }
//         return tirages.stream()
//                 .map(tirageMapper::entityToDTO)
//                 .toList();
//     }

//     @GetMapping("/tirages/{id}")
//     public TirageDTO tirage(@PathVariable("id") @NotNull Long id) {
//         try {
//             return tirageMapper.entityToDTO(tirageService.get(id));
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         }
//     }

//     @PostMapping(value = "/tirages", consumes = MediaType.APPLICATION_JSON_VALUE)
//     @ResponseStatus(HttpStatus.CREATED)
//     public TirageDTO newTirage(@RequestBody @Valid TirageDTO tirage) {
//         var saved = tirageService.save(tirageMapper.dtoToEntity(tirage));
//         return tirageMapper.entityToDTO(saved);
//     }

//     @PutMapping(value = "/tirages/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//     public TirageDTO updateTirage(@RequestBody @Valid TirageDTO tirage, @NotNull @PathVariable("id") Long id) {
//         try {
//             if (tirage.id().equals(id)) {
//                 tirageService.get(id);
//                 var updated = tirageService.update(tirageMapper.dtoToEntity(tirage));
//                 return tirageMapper.entityToDTO(updated);
//             }
//             throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tirage is not found", e);
//         }
//     }

//     @DeleteMapping("/tirages/{id}")
//     @ResponseStatus(HttpStatus.NO_CONTENT)
//     public void deleteTirage(@PathVariable("id") @NotNull Long id) {
//         try {
//             tirageService.delete(id);
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         } catch (DeleteTirageException e) {
//             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
//         }
//     }

//     @GetMapping("/tirages/{id}/books")
//     public Collection<BookDTO> books(@PathVariable("id") @NotNull Long tirageId) {
//         try {
//             var tirage = tirageService.get(tirageId);
//             return booksMapper.entityToDTO(tirage.getBooks());
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         }
//     }

}
