package com.farid.freelandforum.model;

import java.util.List;
import java.util.Objects;

public class Forum {

    private int id, ownerCategoryId, ownerForumId, postsCount;
    private long topicsCount;
    private String name;
    private Comment lastPost;
    private List<Forum> forums;
    private List<Topic> topics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerCategoryId() {
        return ownerCategoryId;
    }

    public void setOwnerCategoryId(int ownerCategoryId) {
        this.ownerCategoryId = ownerCategoryId;
    }

    public int getOwnerForumId() {
        return ownerForumId;
    }

    public void setOwnerForumId(int ownerForumId) {
        this.ownerForumId = ownerForumId;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public long getTopicsCount() {
        return topicsCount;
    }

    public void setTopicsCount(long topicsCount) {
        this.topicsCount = topicsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Comment getLastPost() {
        return lastPost;
    }

    public void setLastPost(Comment lastPost) {
        this.lastPost = lastPost;
    }

    public List<Forum> getForums() {
        return forums;
    }

    public void setForums(List<Forum> forums) {
        this.forums = forums;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forum forum = (Forum) o;
        return getId() == forum.getId() &&
                getOwnerCategoryId() == forum.getOwnerCategoryId() &&
                getOwnerForumId() == forum.getOwnerForumId() &&
                getPostsCount() == forum.getPostsCount() &&
                getTopicsCount() == forum.getTopicsCount() &&
                Objects.equals(getName(), forum.getName()) &&
                Objects.equals(getLastPost(), forum.getLastPost()) &&
                Objects.equals(getForums(), forum.getForums()) &&
                Objects.equals(getTopics(), forum.getTopics());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOwnerCategoryId(), getOwnerForumId(), getPostsCount(), getTopicsCount(), getName(), getLastPost(), getForums(), getTopics());
    }
}
