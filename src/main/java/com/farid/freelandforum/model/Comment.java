package com.farid.freelandforum.model;


import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Comment {

    private int id;
    private User author;
    private String data;
    private Date postDate;
    private Topic owner;
    private List<Comment> comments;
    private long rating;
    private List<Image> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Topic getOwner() {
        return owner;
    }

    public void setOwner(Topic owner) {
        this.owner = owner;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() &&
                getRating() == comment.getRating() &&
                Objects.equals(getAuthor(), comment.getAuthor()) &&
                Objects.equals(getData(), comment.getData()) &&
                Objects.equals(getPostDate(), comment.getPostDate()) &&
                Objects.equals(getOwner(), comment.getOwner()) &&
                Objects.equals(getComments(), comment.getComments()) &&
                Objects.equals(getImages(), comment.getImages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAuthor(), getData(), getPostDate(), getOwner(), getComments(), getRating(), getImages());
    }
}
