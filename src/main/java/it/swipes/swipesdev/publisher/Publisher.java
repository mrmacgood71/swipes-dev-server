package it.swipes.swipesdev.publisher;

import com.fasterxml.jackson.annotation.JsonView;
import it.swipes.swipesdev.config.View;
import it.swipes.swipesdev.post.Post;
import it.swipes.swipesdev.profile.Profile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.ShortPublisherInfo.class)
    private Long id;

    @JsonView(View.ShortPublisherInfo.class)
    private String name;

    @JsonView(View.ShortPublisherInfo.class)
    private String description;

    //profile picture
    @JsonView(View.ShortPublisherInfo.class)
    private String profilePic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonView(View.FullPublisherInfo.class)
    private Profile author;

    @OneToMany
    @JsonView(View.FullPublisherInfo.class)
    private List<Post> posts;

    @OneToMany
    @JsonView(View.FullPublisherInfo.class)
    private List<Profile> followers;

    public Publisher() {
    }

    public Publisher(Long id,
                     Profile author,
                     String name,
                     String description,
                     String profilePic,
                     List<Post> posts,
                     List<Profile> followers
    ) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.description = description;
        this.profilePic = profilePic;
        this.posts = posts;
        this.followers = followers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getAuthor() {
        return author;
    }

    public void setAuthor(Profile author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Profile> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Profile> followers) {
        this.followers = followers;
    }
}
