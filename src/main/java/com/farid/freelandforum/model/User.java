package com.farid.freelandforum.model;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {

    private String firstName, lastName, email, nikName;
    private int age, id;
    private long  rating;
    private Date birthDate, registrationDate;
    private Gender gender;
    private List<Topic> topicsList;
    private List<Comment> commentsList;
    private Rank rank;
    private Image ava;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Topic> getTopicsList() {
        return topicsList;
    }

    public void setTopicsList(List<Topic> topicsList) {
        this.topicsList = topicsList;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Image getAva() {
        return ava;
    }

    public void setAva(Image ava) {
        this.ava = ava;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                getId() == user.getId() &&
                getRating() == user.getRating() &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getNikName(), user.getNikName()) &&
                Objects.equals(getBirthDate(), user.getBirthDate()) &&
                Objects.equals(getRegistrationDate(), user.getRegistrationDate()) &&
                getGender() == user.getGender() &&
                Objects.equals(getTopicsList(), user.getTopicsList()) &&
                Objects.equals(getCommentsList(), user.getCommentsList()) &&
                getRank() == user.getRank() &&
                Objects.equals(getAva(), user.getAva());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getNikName(), getAge(), getId(), getRating(), getBirthDate(), getRegistrationDate(), getGender(), getTopicsList(), getCommentsList(), getRank(), getAva());
    }
}
