package lucafavaretto.U5W2D1.controllers;

import lucafavaretto.U5W2D1.entities.Author;
import lucafavaretto.U5W2D1.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @GetMapping
    public Page<Author> getAuthor(@RequestParam(defaultValue = "0") int pageNumber,
                                  @RequestParam(defaultValue = "10") int pageSize,
                                  @RequestParam(defaultValue = "name") String orderBy) {
        return authorService.getAuthors(pageNumber, pageSize, orderBy);
    }


    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable UUID id) {

        return authorService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author newAuthor) {

        return authorService.save(newAuthor);
    }


    @PutMapping("/{id}")
    public Author findAuthorByIdAndUpdate(@PathVariable UUID id, @RequestBody Author newAuthor) {
        return authorService.findByIdAndUpdate(id, newAuthor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable UUID id) {
        authorService.deleteAuthorById(id);
    }
}
