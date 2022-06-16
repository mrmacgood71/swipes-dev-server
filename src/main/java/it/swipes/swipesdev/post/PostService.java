package it.swipes.swipesdev.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {

        return postRepository.findAll();

    }

    public void save(Post post) {

        postRepository.save(post);

    }
}
