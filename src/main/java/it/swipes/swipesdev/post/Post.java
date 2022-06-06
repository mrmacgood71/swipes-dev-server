package it.swipes.swipesdev.post;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Post {

    @Id
    private Long id;
    private String image;
    private Long authorId;
    private Long likes;
    private Long commentsCount;


    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

    public Post(Long id, String image, Long authorId, Long likes, Long commentsCount) {
        this.id = id;
        this.image = image;
        this.authorId = authorId;
        this.likes = likes;
        this.commentsCount = commentsCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
