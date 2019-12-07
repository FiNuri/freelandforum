package com.farid.freelandforum.model;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Topic {

    private int id, ownerForum;
    private String name, data;
    private User author;
    private Date postDate, lastChangeDate;
    private List<Comment> comments;
    private long views, rating, postsCount;
    private Comment lastComment;
    private List<Image> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerForum() {
        return ownerForum;
    }

    public void setOwnerForum(int ownerForum) {
        this.ownerForum = ownerForum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(long postsCount) {
        this.postsCount = postsCount;
    }

    public Comment getLastComment() {
        return lastComment;
    }

    public void setLastComment(Comment lastComment) {
        this.lastComment = lastComment;
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
        Topic topic = (Topic) o;
        return getId() == topic.getId() &&
                getOwnerForum() == topic.getOwnerForum() &&
                getViews() == topic.getViews() &&
                getRating() == topic.getRating() &&
                getPostsCount() == topic.getPostsCount() &&
                Objects.equals(getName(), topic.getName()) &&
                Objects.equals(getData(), topic.getData()) &&
                Objects.equals(getAuthor(), topic.getAuthor()) &&
                Objects.equals(getPostDate(), topic.getPostDate()) &&
                Objects.equals(getLastChangeDate(), topic.getLastChangeDate()) &&
                Objects.equals(getComments(), topic.getComments()) &&
                Objects.equals(getLastComment(), topic.getLastComment()) &&
                Objects.equals(getImages(), topic.getImages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOwnerForum(), getName(), getData(), getAuthor(), getPostDate(), getLastChangeDate(), getComments(), getViews(), getRating(), getPostsCount(), getLastComment(), getImages());
    }
}
