package lucafavaretto.U5W2D1.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lucafavaretto.U5W2D1.entities.Author;

import lucafavaretto.U5W2D1.entities.BlogPost;
import lucafavaretto.U5W2D1.exceptions.BadRequestException;
import lucafavaretto.U5W2D1.exceptions.NotFoundException;
import lucafavaretto.U5W2D1.payloads.AuthorTDO;
import lucafavaretto.U5W2D1.repositories.AuthorsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class AuthorService {

    @Autowired
    AuthorsDao authorsDao;

    @Autowired
    Cloudinary cloudinaryUploader;

    public Page<Author> getAuthors(int pageNumber, int pageSize, String orderBy) {
        if (pageNumber > 20) pageSize = 20;


        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));


        return authorsDao.findAll(pageable);
    }

    public Author findById(UUID id) {
        return authorsDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author save(AuthorTDO authorTDO) {
        if (authorsDao.existsByEmail(authorTDO.email())) throw new BadRequestException("email already exist");
        Author author = new Author(authorTDO.name(), authorTDO.surname(), authorTDO.email(), authorTDO.birthdayDate(), generateAvatarUrl(authorTDO));
        return authorsDao.save(author);
    }

    public Author findByIdAndUpdate(UUID id, AuthorTDO updatePost) {
        Author found = findById(id);
        found.setName(updatePost.name());
        found.setSurname(updatePost.surname());
        found.setEmail(updatePost.email());
        found.setBirthdayDate(updatePost.birthdayDate());
        return authorsDao.save(found);
    }


    public void deleteAuthorById(UUID id) {
        Author found = findById(id);
        authorsDao.delete(found);
    }

    private String generateAvatarUrl(AuthorTDO author) {
        return "https://ui-avatars.com/api/?name=" + author.name() + "+" + author.surname();
    }

    public String uploadImage(UUID id, MultipartFile image) throws IOException {
        Author found = findById(id);
        String url = (String) cloudinaryUploader.uploader().upload(image.getBytes(),
                ObjectUtils.emptyMap()).get("url");
        found.setAvatar(url);
        authorsDao.save(found);
        return url;
    }

}
