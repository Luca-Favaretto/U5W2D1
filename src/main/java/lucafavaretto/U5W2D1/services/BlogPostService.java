package lucafavaretto.U5W2D1.services;

import lucafavaretto.U5W2D1.Genre;
import lucafavaretto.U5W2D1.entities.Author;
import lucafavaretto.U5W2D1.entities.BlogPost;
import lucafavaretto.U5W2D1.payloads.BlogPostPayload;
import lucafavaretto.U5W2D1.repositories.BlogPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;

@Service
public class BlogPostService {

    @Autowired
    BlogPostDao blogPostDao;
    @Autowired
    AuthorService authorService;

    public Page<BlogPost> getBlogPost() {
        Pageable pageable = PageRequest.of(0, 10);
        return blogPostDao.findAll(pageable);
    }

    //
//    public BlogPost findBlogPostById(long id) {
//        return blogPosts.stream()
//                .filter(el -> el.getId() == id)
//                .findFirst()
//                .orElseThrow(() -> new NotFoundExceptions(id));
//    }
//
    public BlogPost save(BlogPostPayload payload) {
        Author author = authorService.findById(payload.getAuthorId());
        return blogPostDao.save(
                new BlogPost(Genre.COMPUTER, payload.getTitle(), "https://picsum.photos/200/300", payload.getDetail(), payload.getTimeOfLecture(), author));
    }
//
//    public BlogPost findBlogPostByIdAndUpdate(long id, BlogPost updatePost) {
//        return blogPosts.stream()
//                .filter(el -> el.getId() == id)
//                .findFirst()
//                .map(currentPost -> {
//                    currentPost.setGenre(updatePost.getGenre());
//                    currentPost.setTitle(updatePost.getTitle());
//                    currentPost.setCover(updatePost.getCover());
//                    currentPost.setDetails(updatePost.getDetails());
//                    currentPost.setTimeOfLecture(updatePost.getTimeOfLecture());
//                    return currentPost;
//                })
//                .orElseThrow(() -> new NotFoundExceptions(id));
//    }
//
//    public void deleteBlogPostById(long id) {
//        blogPosts.removeIf(current -> current.getId() == id);
//    }


}
