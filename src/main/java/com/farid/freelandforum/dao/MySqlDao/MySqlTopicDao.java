package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.TopicDao;
import com.farid.freelandforum.model.Topic;

import java.util.List;

public class MySqlTopicDao implements TopicDao {
    @Override
    public String createTopic(Topic topic) throws DaoExeption {
        return null;
    }

    @Override
    public Topic getTopicById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public List<Topic> getAllTopics() throws DaoExeption {
        return null;
    }

    @Override
    public String updateTopicById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public String dropTopicById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public List<Topic> getTopicsFromTo(int from, int to) throws DaoExeption {
        return null;
    }
}
