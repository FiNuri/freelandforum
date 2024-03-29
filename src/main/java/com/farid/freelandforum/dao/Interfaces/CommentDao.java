package com.farid.freelandforum.dao.Interfaces;

import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.model.Comment;

import java.util.List;

public interface CommentDao {

    String createComment(Comment comment) throws DaoExeption;

    Comment getCommentById(int id) throws DaoExeption;

    List<Comment> getAllComments() throws DaoExeption;

    String updateCommentById(int id) throws DaoExeption;

    String dropCommentById(int id) throws DaoExeption;

    List<Comment> getCommentFromTo(int from, int to) throws DaoExeption;

    List<Comment> getAllCommentsByOwnerTopicId(int id) throws DaoExeption;

    Comment getLastCommenInTopic(int topicID) throws DaoExeption;

    List<Comment> getCommentsByTopicIdFromTo(int topicID, int from) throws DaoExeption;

    long getCommentsCountByTopicID(int topicID) throws DaoExeption;


}
