package lucafavaretto.U5W2D1.controllers;

import lucafavaretto.U5W2D1.entities.Author;
import lucafavaretto.U5W2D1.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @GetMapping
    public Set<Author> getAuthor() {
        return authorService.getAuthors();
    }


    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable long id) {
        return authorService.findBlogPostById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author newAuthor) {
        return authorService.addAuthor(newAuthor);
    }


    @PutMapping("/{id}")
    public Author findAuthorByIdAndUpdate(@PathVariable long id, @RequestBody Author newAuthor) {
        return authorService.findAuthorByIdAndUpdate(id, newAuthor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable long id) {
        authorService.deleteAuthorById(id);
    }
}
