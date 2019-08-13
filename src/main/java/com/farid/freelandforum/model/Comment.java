package com.farid.freelandforum.model;


import lombok.Data;
import java.awt.*;
import java.util.List;

@Data
public class Comment {

    private int id;
    private User author;
    private String data;
    private Topic owner;
    private List<Comment> comments;
    private long rating;
    private List<Image> images;

}
