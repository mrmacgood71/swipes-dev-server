package it.swipes.swipesdev.publisher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/publishers")
public class PublisherController {
    @GetMapping
    public List<Publisher> getPublishers() {
        return null;
    }

    @GetMapping("{id}")
    public Publisher getPublisher(
            @PathVariable final String id
    ) {
        return null;
    }
}
