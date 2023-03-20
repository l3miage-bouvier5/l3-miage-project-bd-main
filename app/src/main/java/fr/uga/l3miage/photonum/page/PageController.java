package fr.uga.l3miage.photonum.page;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import fr.uga.l3miage.photonum.data.domain.Page;
// // import fr.uga.l3miage.library.books.BookDTO;
// // import fr.uga.l3miage.library.books.BooksMapper;
// // import fr.uga.l3miage.photonum.service.PageService;
// // import fr.uga.l3miage.library.service.DeletePageException;
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
public class PageController {

//     private final PageService pageService;
//     private final PageMapper pageMapper;

//     @Autowired
//     public PageController(PageService Service, PageMapper pageMapper, BooksMapper booksMapper) {
//         this.pageService = pageService;
//         this.pageMapper = pageMapper;
//         this.booksMapper = booksMapper;
//     }

//     @GetMapping("/pages")
//     public Collection<PageDTO> pages(@RequestParam(value = "q", required = false) String query) {
//         Collection<Page> pages;
//         if (query == null) {
//             pages = pageService.list();
//         } else {
//             pages = pageService.searchByName(query);
//         }
//         return pages.stream()
//                 .map(pageMapper::entityToDTO)
//                 .toList();
//     }

//     @GetMapping("/pages/{id}")
//     public PageDTO page(@PathVariable("id") @NotNull Long id) {
//         try {
//             return pageMapper.entityToDTO(pageService.get(id));
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         }
//     }

//     @PostMapping(value = "/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
//     @ResponseStatus(HttpStatus.CREATED)
//     public PageDTO newPage(@RequestBody @Valid PageDTO page) {
//         var saved = pageService.save(pageMapper.dtoToEntity(page));
//         return pageMapper.entityToDTO(saved);
//     }

//     @PutMapping(value = "/pages/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//     public PageDTO updatePage(@RequestBody @Valid PageDTO page, @NotNull @PathVariable("id") Long id) {
//         try {
//             if (page.id().equals(id)) {
//                 pageService.get(id);
//                 var updated = pageService.update(pageMapper.dtoToEntity(page));
//                 return pageMapper.entityToDTO(updated);
//             }
//             throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "page is not found", e);
//         }
//     }

//     @DeleteMapping("/pages/{id}")
//     @ResponseStatus(HttpStatus.NO_CONTENT)
//     public void deletePage(@PathVariable("id") @NotNull Long id) {
//         try {
//             pageService.delete(id);
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         } catch (DeletePageException e) {
//             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, e);
//         }
//     }

//     @GetMapping("/pages/{id}/books")
//     public Collection<BookDTO> books(@PathVariable("id") @NotNull Long pageId) {
//         try {
//             var page = pageService.get(pageId);
//             return booksMapper.entityToDTO(page.getBooks());
//         } catch (EntityNotFoundException e) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, e);
//         }
//     }

}
