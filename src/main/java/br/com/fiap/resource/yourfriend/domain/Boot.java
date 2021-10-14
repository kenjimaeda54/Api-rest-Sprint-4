package br.com.fiap.resource.yourfriend.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Boot {
    private int id;
    private String relations = null;
    private String socialMedia = null;
    private String profession = null;
    private List<User> user;
    private  Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
