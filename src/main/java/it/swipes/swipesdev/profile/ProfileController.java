package it.swipes.swipesdev.profile;

import it.swipes.swipesdev.publisher.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profile/{id}")
    public Profile getProfile(
            @PathVariable final String id
    ) {
        return profileService.findById(id);
    }

    @GetMapping("/profile/{id}/follows")
    public List<Publisher> getFollows(
            @PathVariable final String id
    ) {
        return null;
    }

    @PostMapping("/profile")
    public String save(
            @RequestBody Profile profile
    ) {
        profileService.save(profile);

        return "ok";
    }

    @GetMapping("/edit/{id}")
    public Profile getProfileForEdit(
            @PathVariable final String id
    ) {
        return profileService.findById(id);
    }

    @PutMapping("/edit/{profileId}")
    public String editProfile(
            @PathVariable final String profileId,
            @RequestBody final Profile profile
    ) {
        profileService.save(profile);

        return "ok";
    }


}
