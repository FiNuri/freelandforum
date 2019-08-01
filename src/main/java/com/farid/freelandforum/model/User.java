package com.farid.freelandforum.model;

import lombok.Data;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Data
public class User {

    private String firstName, lastName, email;
    private int age, id;
    private long  rating;
    private Date birthDate, registrationDate;
    private Sex sex;
    private List<Topic> topicsList;
    private List<Comment> commentsList;
    private Rank rank;
    private Image ava;

}
