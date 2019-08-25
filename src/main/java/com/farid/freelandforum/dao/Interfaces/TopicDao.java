package com.farid.freelandforum.dao.Interfaces;

import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.model.Topic;

import java.util.List;

public interface TopicDao {

    String createTopic(Topic topic) throws DaoExeption;

    Topic getTopicById(int id, int from) throws DaoExeption;

    List<Topic> getAllTopics() throws DaoExeption;

    String updateTopicById(int id) throws DaoExeption;

    String dropTopicById(int id) throws DaoExeption;

    List<Topic> getTopicsByForumIdFromTo(int forumID, int from) throws DaoExeption;

    List<Topic> getAllTopicsByOwnerForumID(int id) throws DaoExeption;

    long getTopicsCountByForumID(int forumID) throws  DaoExeption;

}
