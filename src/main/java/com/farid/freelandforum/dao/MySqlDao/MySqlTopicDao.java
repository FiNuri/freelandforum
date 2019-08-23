package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.Interfaces.CommentDao;
import com.farid.freelandforum.dao.Interfaces.ConnectionsPool;
import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.Interfaces.TopicDao;
import com.farid.freelandforum.model.Comment;
import com.farid.freelandforum.model.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTopicDao implements TopicDao {

    ConnectionsPool connectionsPool;
    CommentDao commentDao;

    public MySqlTopicDao(ConnectionsPool connectionsPool, CommentDao commentDao) {
        this.connectionsPool = connectionsPool;
        this.commentDao = commentDao;
    }

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
    public List<Topic> getTopicsByForumIdFromTo(int forumID, int from) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Topic topic;
        Comment lastComment;
        List<Topic> topicList = new ArrayList<>();
        List<Comment> commentList;
        int to = from + 20;
        try {
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT topics.id, topics.name, topics.views FROM topics " +
                    "WHERE topics.ownerForum = ?  ORDER BY topics.id LIMIT ?, ?");
            statement.setInt(1, forumID);
            statement.setInt(2, from);
            statement.setInt(3, to);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                topic = new Topic();
                topic.setId(resultSet.getInt("id"));
                topic.setName(resultSet.getString("name"));
                topic.setViews(resultSet.getInt("views"));
                commentList = commentDao.getAllCommentsByOwnerTopicId(topic.getId());
                topic.setComments(commentList);
                lastComment = commentDao.getLastCommenInTopic(topic.getId());
                topic.setLastComment(lastComment);
                topicList.add(topic);
            }
        } catch (SQLException e) {
            throw new DaoExeption(DaoExeption._SQL_ERROR);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_RESAULTSET);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_STATEMANT);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_CONNECTION);
                }
            }
        }
        return topicList;
    }


    @Override
    public List<Topic> getAllTopicsByOwnerForumID(int id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Topic> topicList = new ArrayList<>();
        List<Comment> commentList;
        Topic topic;

        try {
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT topics.id, topics.name FROM topics" +
                    " WHERE topics.ownerForum = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                topic = new Topic();
                topic.setId(resultSet.getInt("id"));
                topic.setName(resultSet.getString("name"));
                topic.setOwnerForum(id);
                commentList = commentDao.getAllCommentsByOwnerTopicId(topic.getId());
                topic.setComments(commentList);
                topic.setPostsCount(topic.getComments().size());
                topicList.add(topic);
            }

        } catch (SQLException e) {
            throw new DaoExeption(DaoExeption._SQL_ERROR);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_RESAULTSET);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_STATEMANT);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_CONNECTION);
                }
            }
        }
        return topicList;
    }
}
