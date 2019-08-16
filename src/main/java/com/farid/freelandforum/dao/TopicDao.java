package com.farid.freelandforum.dao;

import com.farid.freelandforum.model.Topic;

import java.util.List;

public interface TopicDao {

    String createTopic(Topic topic) throws DaoExeption;

    Topic getTopicById(int id) throws DaoExeption;

    List<Topic> getAllTopics() throws DaoExeption;

    String updateTopicById(int id) throws DaoExeption;

    String dropTopicById(int id) throws DaoExeption;

    List<Topic> getTopicsFromTo(int from, int to) throws DaoExeption;
}
