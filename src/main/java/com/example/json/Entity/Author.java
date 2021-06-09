package com.example.json.Entity;


public class Author {


    private Integer id;

    private String authorId;

    private String firstName;

    private String lastName;

    private Integer posts;

    public Author(){};

    public Author(Integer id, String authorId, String firstName, String lastName, Integer posts) {
        this.id = id;
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPosts() {
        return posts;
    }

    public void setPosts(Integer posts) {
        this.posts = posts;
    }
}
