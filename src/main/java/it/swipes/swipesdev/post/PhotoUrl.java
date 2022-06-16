package it.swipes.swipesdev.post;

import com.fasterxml.jackson.annotation.JsonView;
import it.swipes.swipesdev.config.View;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PhotoUrl {

    @Id
    @JsonView({View.ShortPostInfo.class, View.ShortPublisherInfo.class})
    private Long id;
    @JsonView({View.ShortPostInfo.class, View.ShortPublisherInfo.class})
    private String url;

    public PhotoUrl() {
    }

    public PhotoUrl(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
