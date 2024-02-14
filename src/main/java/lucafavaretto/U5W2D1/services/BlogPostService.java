package lucafavaretto.U5W2D1.services;

import lucafavaretto.U5W2D1.Genre;
import lucafavaretto.U5W2D1.entities.Author;
import lucafavaretto.U5W2D1.entities.BlogPost;
import lucafavaretto.U5W2D1.exceptions.NotFoundException;
import lucafavaretto.U5W2D1.payloads.BlogPostPayload;
import lucafavaretto.U5W2D1.repositories.AuthorsDao;
import lucafavaretto.U5W2D1.repositories.BlogPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlogPostService {

    @Autowired
    BlogPostDao blogPostDao;
    @Autowired
    AuthorsDao authorsDao;

    @Autowired
    AuthorService authorService;

    public Page<BlogPost> getBlogPost(int pageNumber, int pageSize, String orderBy) {
        if (pageNumber > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(orderBy));
        return blogPostDao.findAll(pageable);
    }


    public BlogPost findById(UUID id) {
        return blogPostDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost save(BlogPostPayload payload) {
        Author author = authorService.findById(payload.getAuthorId());
        return blogPostDao.save(
                new BlogPost(Genre.valueOf(String.valueOf(payload.getGenre())), payload.getTitle(),
                        "https://picsum.photos/200/300", payload.getDetails(), payload.getTimeOfLecture(), author));
    }

    public BlogPost findByIdAndUpdate(UUID id, BlogPost updateBlogPost) {
        BlogPost found = findById(id);
        found.setGenre(updateBlogPost.getGenre());
        found.setTitle(updateBlogPost.getTitle());
        found.setCover(updateBlogPost.getCover());
        found.setDetails(updateBlogPost.getDetails());
        found.setTimeOfLecture(updateBlogPost.getTimeOfLecture());
        return blogPostDao.save(found);
    }

    public void deleteBlogPostById(UUID id) {
        BlogPost found = findById(id);
        blogPostDao.delete(found);
    }


}
