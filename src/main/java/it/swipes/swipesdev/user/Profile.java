package it.swipes.swipesdev.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Profile {

    @Id
    private Long id;
    private String login;
    private String password;
    private String nickname;
    private String token;
    //profile picture
    private String profilePic;
//    private List<Long> publishers;


    public Profile() {
    }

    public Profile(Long id) {
        this.id = id;
    }

    public Profile(Long id, String login, String password, String nickname, String token, String profilePic) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.token = token;
        this.profilePic = profilePic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
