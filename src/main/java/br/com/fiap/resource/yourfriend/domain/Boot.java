package br.com.fiap.resource.yourfriend.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Boot {
    private int id;
    private Object relations = null;
    private Object socialMedia = null; //tentar alterar os campos por array
    private Object  profession = null;
    private List<User> user;
    private Integer userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getRelations() {
        return relations;
    }

    public void setRelations(Object relations) {
        this.relations = relations;
    }

    public Object getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(Object socialMedia) {
        this.socialMedia = socialMedia;
    }

    public Object getProfession() {
        return profession;
    }

    public void setProfession(Object profession) {
        this.profession = profession;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
