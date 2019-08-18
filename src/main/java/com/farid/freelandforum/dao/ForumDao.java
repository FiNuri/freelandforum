package com.farid.freelandforum.dao;

import com.farid.freelandforum.model.Forum;

import java.util.List;

public interface ForumDao {

    String createForum(Forum forum) throws DaoExeption;

    Forum getForumById(int id) throws DaoExeption;

    List<Forum> getAllForums() throws DaoExeption;

    String updateForumById(int id) throws DaoExeption;

    String dropForumById(int id) throws DaoExeption;

    List<Forum> getFouremFromTo(int from, int to) throws DaoExeption;

    List<Forum> getAllForumsByOwnerCategoryID(int id) throws  DaoExeption;

}
