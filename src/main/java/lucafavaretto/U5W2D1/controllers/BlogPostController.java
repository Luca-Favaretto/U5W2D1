package lucafavaretto.U5W2D1.controllers;

import lucafavaretto.U5W2D1.entities.BlogPost;
import lucafavaretto.U5W2D1.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
//    @Autowired
//    BlogPostService blogPostService;
//
//
//    @GetMapping
//    public Set<BlogPost> getBlogPost() {
//        return blogPostService.getBlogPost();
//    }
//
//
//    @GetMapping("/{id}")
//    public BlogPost findBlogPostById(@PathVariable long id) {
//        return blogPostService.findBlogPostById(id);
//    }
//
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public BlogPost saveBlogPost(@RequestBody BlogPost newBlogPost) {
//        return blogPostService.addBlogPost(newBlogPost);
//    }
//
//
//    @PutMapping("/{id}")
//    public BlogPost findBlogPostByIdAndUpdate(@PathVariable long id, @RequestBody BlogPost newBlogPost) {
//        return blogPostService.findBlogPostByIdAndUpdate(id, newBlogPost);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteBlogPostById(@PathVariable long id) {
//        blogPostService.deleteBlogPostById(id);
//    }

}
