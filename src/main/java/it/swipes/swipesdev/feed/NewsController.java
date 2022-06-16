package it.swipes.swipesdev.feed;

import it.swipes.swipesdev.comment.Comment;
import it.swipes.swipesdev.profile.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/news")
public class NewsController {

    @GetMapping
    public List<News> getNews() {
        return List.of(
                new News(1L),
                new News(2L)
        );
    }

    @GetMapping("{id}")
    public News getPost(@PathVariable final String id) {
        return new News(Long.parseLong(id));
    }

    private int likes;
    @PutMapping("{id}/like")
    public String like(
            @PathVariable final String id
    ) {

        return Integer.toString(likes++);
    }

    @PutMapping("{id}/unlike")
    public String unlike(
            @PathVariable final String id
    ) {
        return Integer.toString(--likes);
    }

    @GetMapping("{id}/comments")
    public List<Comment> getComments(
            @PathVariable final String id
    ) {
        return List.of(
                new Comment("text 1", new Profile("" + 1)),
                new Comment("text 1", new Profile("" + 2))
        );
    }

    @PostMapping("{id}/comments/add")
    public String addComment(
            @PathVariable final String id
    ) {
        return "add";
    }
}
