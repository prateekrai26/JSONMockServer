package com.example.json.Entity;


public class Post {

    private Integer id;


    private String title;


    private String author;


    private Integer views;


    private Integer reviews;

   public Post(){

   }

    public Post(Integer id, String title, String author, Integer views, Integer reviews) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.views = views;
        this.reviews = reviews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }
}
