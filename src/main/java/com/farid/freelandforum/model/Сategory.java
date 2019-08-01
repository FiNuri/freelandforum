package com.farid.freelandforum.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Сategory {

    private int id;
    private String name;
    private List<Forum> forums;
}
