package lucafavaretto.U5W2D1.services;

import lucafavaretto.U5W2D1.entities.Author;

import lucafavaretto.U5W2D1.exceptions.BadRequestException;
import lucafavaretto.U5W2D1.exceptions.NotFoundException;
import lucafavaretto.U5W2D1.repositories.AuthorsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {

    @Autowired
    AuthorsDao authorsDao;

    public Page<Author> getAuthors(int pageNumber, int pageSize, String orderBy) {
        if (pageNumber > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return authorsDao.findAll(pageable);
    }

    public Author findById(UUID id) {
        return authorsDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author save(Author newAuthor) {
        if (authorsDao.existsByEmail(newAuthor.getEmail())) throw new BadRequestException("email already exist");
        newAuthor.setAvatar(generateAvatarUrl(newAuthor));
        return authorsDao.save(newAuthor);
    }

    public Author findByIdAndUpdate(UUID id, Author updatePost) {
        Author found = findById(id);
        found.setName(updatePost.getName());
        found.setSurname(updatePost.getSurname());
        found.setEmail(updatePost.getEmail());
        found.setBirthdayDate(updatePost.getBirthdayDate());
        found.setAvatar(generateAvatarUrl(updatePost));
        return authorsDao.save(found);
    }


    public void deleteAuthorById(UUID id) {
        Author found = findById(id);
        authorsDao.delete(found);
    }

    private String generateAvatarUrl(Author author) {
        return "https://ui-avatars.com/api/?name=" + author.getName() + "+" + author.getSurname();
    }

}
