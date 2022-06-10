package it.swipes.swipesdev.publisher;

import com.fasterxml.jackson.annotation.JsonView;
import it.swipes.swipesdev.config.View;
import it.swipes.swipesdev.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    @JsonView(View.ShortPublisherInfo.class)
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @GetMapping("{id}")
    @JsonView(View.FullPublisherInfo.class)
    public Publisher getPublisher(
            @PathVariable final String id
    ) {

        Profile author = publisherService.findById(Long.parseLong(id)).getAuthor();
        System.out.println(author);
        return publisherService.findById(Long.parseLong(id));
    }

    @PostMapping
    public String save(
            @RequestBody Publisher publisher
    ) {
        if (publisher == null) {
            throw new IllegalStateException("Publisher is null");
        }

        publisherService.save(publisher);

        return "ok";
    }
}
