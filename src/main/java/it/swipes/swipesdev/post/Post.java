package it.swipes.swipesdev.post;

import com.fasterxml.jackson.annotation.JsonView;
import it.swipes.swipesdev.config.View;
import it.swipes.swipesdev.publisher.Publisher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({View.FullPublisherInfo.class, View.ShortPostInfo.class})
    private Long id;

    @OneToMany
    @JsonView({View.FullPublisherInfo.class, View.ShortPostInfo.class})
    private List<PhotoUrl> image;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonView(View.ShortPostInfo.class)
    private Publisher author;
    @JsonView({View.FullPublisherInfo.class, View.ShortPostInfo.class})
    private Long likes;
    @JsonView({View.FullPublisherInfo.class, View.ShortPostInfo.class})
    private Long commentsCount;

    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

    public Post(Long id, List<PhotoUrl> image, Publisher author, Long likes, Long commentsCount) {
        this.id = id;
        this.image = image;
        this.author = author;
        this.likes = likes;
        this.commentsCount = commentsCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PhotoUrl> getImage() {
        return image;
    }

    public void setImage(List<PhotoUrl> image) {
        this.image = image;
    }

    public Publisher getAuthor() {
        return author;
    }

    public void setAuthor(Publisher authorId) {
        this.author = authorId;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }
}
