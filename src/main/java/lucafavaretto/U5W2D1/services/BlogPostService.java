package lucafavaretto.U5W2D1.services;

import lucafavaretto.U5W2D1.entities.BlogPost;
import lucafavaretto.U5W2D1.exeptions.NotFoundElement;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogPostService {
    Set<BlogPost> blogPosts = new HashSet<>();

    public Set<BlogPost> getBlogPost() {
        return blogPosts;
    }

    public BlogPost findBlogPostById(long id) {
        return blogPosts.stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundElement(id));
    }

    public BlogPost addBlogPost(BlogPost newBlogPost) {
        Random rndm = new Random();
        newBlogPost.setId(rndm.nextInt(1, 10000));
        newBlogPost.setTimeOfLecture(rndm.nextInt(10, 30));

        blogPosts.add(newBlogPost);
        return newBlogPost;
    }

    public BlogPost findBlogPostByIdAndUpdate(long id, BlogPost updatePost) {
        return blogPosts.stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .map(currentPost -> {
                    currentPost.setGenre(updatePost.getGenre());
                    currentPost.setTitle(updatePost.getTitle());
                    currentPost.setCover(updatePost.getCover());
                    currentPost.setDetails(updatePost.getDetails());
                    currentPost.setTimeOfLecture(updatePost.getTimeOfLecture());
                    return currentPost;
                })
                .orElseThrow(() -> new NotFoundElement(id));
    }

    public void deleteBlogPostById(long id) {
//        Iterator<BlogPost> iterator = blogPosts.iterator();
//        while (iterator.hasNext()) {
//            BlogPost current = iterator.next();
//            if (current.getId() == id) {
//                iterator.remove();
//            }
//        }
        blogPosts.removeIf(current -> current.getId() == id);
    }


}
