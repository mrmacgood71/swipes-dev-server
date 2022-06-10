package it.swipes.swipesdev.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile findById(String id) {
        return profileRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Profile does not exists"));
    }

    public void save(Profile profile) {
        profileRepository.save(profile);
    }
}
