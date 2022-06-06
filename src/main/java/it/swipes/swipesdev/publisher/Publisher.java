package it.swipes.swipesdev.publisher;

import it.swipes.swipesdev.post.Post;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Publisher {
    @Id
    private Long id;
    private Long userId;
    private String name;
    private String description;
    //profile picture
    private String profilePic;

//    private List<Post> posts;

}
