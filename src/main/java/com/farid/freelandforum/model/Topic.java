package com.farid.freelandforum.model;

import lombok.Data;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Data
public class Topic {

    private int id, ownerForum, postsCount;
    private String name, data;
    private User author;
    private Date postDate, lastChangeDate;
    private List<Comment> comments;
    private long views, rating;
    private Comment lastComment;
    private List<Image> images;

}
