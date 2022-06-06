package it.swipes.swipesdev.user;

import it.swipes.swipesdev.publisher.Publisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProfileController {

    @GetMapping("/profile/{id}")
    public Profile getProfile(
            @PathVariable final String id
    ) {
        return new Profile(Long.parseLong(id));
    }

    @GetMapping("/profile/{id}/follows")
    public List<Publisher> getFollows(
            @PathVariable final String id
    ) {
        return null;
    }

    @PutMapping("/edit/{profileId}")
    public Profile editProfile(
            @PathVariable final String profileId
    ) {
        return new Profile(Long.parseLong(profileId));
    }
}
