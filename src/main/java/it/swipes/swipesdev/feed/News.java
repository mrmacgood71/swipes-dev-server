package it.swipes.swipesdev.feed;

import it.swipes.swipesdev.post.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Post> posts;



    public News() {
    }

    public News(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
