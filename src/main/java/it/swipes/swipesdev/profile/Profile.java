package it.swipes.swipesdev.profile;

import com.fasterxml.jackson.annotation.JsonView;
import it.swipes.swipesdev.config.View;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Profile {

    @Id
    @JsonView({View.ShortPostInfo.class, View.ShortPublisherInfo.class})
    private String id;
    private String description;
    @JsonView({View.ShortPostInfo.class, View.ShortPublisherInfo.class})
    private String name;
    @JsonView({View.ShortPostInfo.class, View.ShortPublisherInfo.class})
    private String picture;
    private String email;
    private String locale;
    private String gender;
    private LocalDateTime lastVisit;

    public Profile() {
    }

    public Profile(String id) {
        this.id = id;
    }

    public Profile(String id,
                   String name,
                   String picture,
                   String email,
                   String locale,
                   String gender,
                   LocalDateTime lastVisit
    ) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.email = email;
        this.locale = locale;
        this.gender = gender;
        this.lastVisit = lastVisit;
    }

    public Profile(String id,
                   String description,
                   String name,
                   String picture,
                   String email,
                   String locale,
                   String gender,
                   LocalDateTime lastVisit
    ) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.picture = picture;
        this.email = email;
        this.locale = locale;
        this.gender = gender;
        this.lastVisit = lastVisit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String userpic) {
        this.picture = userpic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
