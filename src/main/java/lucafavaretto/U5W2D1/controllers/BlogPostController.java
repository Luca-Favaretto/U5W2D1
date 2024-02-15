package lucafavaretto.U5W2D1.controllers;

import lucafavaretto.U5W2D1.entities.BlogPost;
import lucafavaretto.U5W2D1.exceptions.BadRequestException;
import lucafavaretto.U5W2D1.payloads.BlogPostDTO;
import lucafavaretto.U5W2D1.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    BlogPostService blogPostService;

    @GetMapping
    public Page<BlogPost> getBlogPost(@RequestParam(defaultValue = "0") int pageNumber,
                                      @RequestParam(defaultValue = "10") int pageSize,
                                      @RequestParam(defaultValue = "title") String orderBy) {
        return blogPostService.getBlogPost(pageNumber, pageSize, orderBy);
    }


    @GetMapping("/{id}")
    public BlogPost findBlogPostById(@PathVariable UUID id) {
        return blogPostService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody @Validated BlogPostDTO newBlogPost, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }

        return blogPostService.save(newBlogPost);
    }

    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable UUID id, @RequestBody @Validated BlogPostDTO newBlogPost) {
        return blogPostService.findByIdAndUpdate(id, newBlogPost);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlogPostById(@PathVariable UUID id) {
        blogPostService.deleteBlogPostById(id);
    }

}
