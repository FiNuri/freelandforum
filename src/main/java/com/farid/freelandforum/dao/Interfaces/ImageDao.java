package com.farid.freelandforum.dao.Interfaces;

import com.farid.freelandforum.dao.DaoExeption;

import java.awt.Image;
import java.util.List;

public interface ImageDao {

    List<Image> getTopicImages(int topicID) throws DaoExeption;

    List<Image> getCommentImages(int commentID) throws DaoExeption;
}
