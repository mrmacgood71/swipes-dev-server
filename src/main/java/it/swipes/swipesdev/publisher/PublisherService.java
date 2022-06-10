package it.swipes.swipesdev.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public Publisher findById(Long id) {

        return publisherRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Something went wrong"));
    }

    public void save(Publisher publisher) {
        publisherRepository.save(publisher);

    }
}
