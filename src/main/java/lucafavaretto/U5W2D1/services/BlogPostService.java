package lucafavaretto.U5W2D1.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lucafavaretto.U5W2D1.Genre;
import lucafavaretto.U5W2D1.entities.Author;
import lucafavaretto.U5W2D1.entities.BlogPost;
import lucafavaretto.U5W2D1.exceptions.NotFoundException;
import lucafavaretto.U5W2D1.payloads.BlogPostTDO;

import lucafavaretto.U5W2D1.repositories.BlogPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class BlogPostService {

    @Autowired
    BlogPostDao blogPostDao;


    @Autowired
    AuthorService authorService;
    @Autowired
    private Cloudinary cloudinaryUploader;

    public Page<BlogPost> getBlogPost(int pageNumber, int pageSize, String orderBy) {
        if (pageNumber > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return blogPostDao.findAll(pageable);
    }


    public BlogPost findById(UUID id) {
        return blogPostDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost save(BlogPostTDO payload) {

        Author author = authorService.findById(UUID.fromString(payload.authorId()));

        return blogPostDao.save(
                new BlogPost(Genre.valueOf(String.valueOf(payload.genre())), payload.title(),
                        "https://picsum.photos/200/300", payload.details(), payload.timeOfLecture(), author));


    }

    public BlogPost findByIdAndUpdate(UUID id, BlogPostTDO updateBlogPost) {
        BlogPost found = findById(id);
        found.setGenre(updateBlogPost.genre());
        found.setTitle(updateBlogPost.title());
        found.setDetails(updateBlogPost.details());
        found.setTimeOfLecture(updateBlogPost.timeOfLecture());
        return blogPostDao.save(found);
    }

    public void deleteBlogPostById(UUID id) {
        BlogPost found = findById(id);
        blogPostDao.delete(found);
    }

    public String uploadImage(UUID id, MultipartFile image) throws IOException {
        BlogPost found = findById(id);
        String url = (String) cloudinaryUploader.uploader().upload(image.getBytes(),
                ObjectUtils.emptyMap()).get("url");
        found.setCover(url);
        blogPostDao.save(found);
        return url;
    }


}
