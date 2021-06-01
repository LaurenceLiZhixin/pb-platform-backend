package github.Laurence.pbmanagement.server.Package;

import java.io.Serializable;


public class User{
    private String name;
    private String id;
    private Integer age;
    private SubUser subUser;

    public SubUser getSubUser() {
        return subUser;
    }

    public void setSubUser(SubUser subUser) {
        this.subUser = subUser;
    }

    public User(String name, String id, Integer age, SubUser subUser) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.subUser = subUser;
    }

    public User(String name, String id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}