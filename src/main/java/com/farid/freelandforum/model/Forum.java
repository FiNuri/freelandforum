package com.farid.freelandforum.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Forum {

    private int id, ownerCategoryId, ownerForumId, postsCount;
    private String name;
    private Comment lastPost;
    private List<Forum> forums;
    private List<Topic> topics;
}
