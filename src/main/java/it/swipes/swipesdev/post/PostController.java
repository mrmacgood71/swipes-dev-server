package it.swipes.swipesdev.post;

import com.fasterxml.jackson.annotation.JsonView;
import it.swipes.swipesdev.config.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/post")
public class PostController {


    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @JsonView(View.ShortPostInfo.class)
    public List<Post> findAll() {
        return postService.findAll();
    }

    @PostMapping
    @JsonView(View.ShortPostInfo.class)
    public void save(
            @RequestBody final Post post
    ) {
        postService.save(post);
    }

}
