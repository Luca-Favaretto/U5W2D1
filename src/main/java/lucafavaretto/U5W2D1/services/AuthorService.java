package lucafavaretto.U5W2D1.services;

import lucafavaretto.U5W2D1.entities.Author;

import lucafavaretto.U5W2D1.exeptions.NotFoundElement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service

public class AuthorService {
    Set<Author> authors = new HashSet<>();

    public Set<Author> getAuthors() {
        return authors;
    }

    public Author findBlogPostById(long id) {
        return authors.stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundElement(id));
    }

    public Author addAuthor(Author newAuthor) {
        Random rndm = new Random();
        newAuthor.setId(rndm.nextInt(1, 10000));
        authors.add(newAuthor);

        return newAuthor;
    }

    public Author findAuthorByIdAndUpdate(long id, Author updatePost) {
        return authors.stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .map(currentAuthor -> {
                    currentAuthor.setName(updatePost.getName());
                    currentAuthor.setSurname(updatePost.getSurname());
                    currentAuthor.setMail(updatePost.getMail());
                    currentAuthor.setBirthdayDate(updatePost.getBirthdayDate());
                    currentAuthor.setAvatar(updatePost.getAvatar());
                    return currentAuthor;
                })
                .orElseThrow(() -> new NotFoundElement(id));
    }

    public void deleteAuthorById(long id) {
//        Iterator<Author> iterator = authors.iterator();
//        while (iterator.hasNext()) {
//            Author current = iterator.next();
//            if (current.getId() == id) {
//                iterator.remove();
//            }
//        }
        authors.removeIf(current -> current.getId() == id);
    }

}
