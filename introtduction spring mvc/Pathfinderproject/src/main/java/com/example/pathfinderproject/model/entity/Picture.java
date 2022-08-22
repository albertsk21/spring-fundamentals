package com.example.pathfinderproject.model.entity;



import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {


    private String title;
    private String url;
    private User author;
    private Route route;


    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    @Column(columnDefinition = "TEXT")
    public String getUrl() {
        return url;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }


    @ManyToOne
    public Route getRoute() {
        return route;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
