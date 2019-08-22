package com.farid.freelandforum.dao;

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

}
