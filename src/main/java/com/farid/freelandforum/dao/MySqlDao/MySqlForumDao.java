package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.ConnectionsPool;
import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.ForumDao;
import com.farid.freelandforum.dao.TopicDao;
import com.farid.freelandforum.model.Forum;
import com.farid.freelandforum.model.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlForumDao implements ForumDao {

    ConnectionsPool connectionPool;
    TopicDao topicDao;

    public MySqlForumDao(ConnectionsPool connectionPool, TopicDao topicDao) {
        this.connectionPool = connectionPool;
        this.topicDao = topicDao;
    }

    @Override
    public String createForum(Forum forum) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        String returnCod;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement("INSERT INTO forums (name,ownerCategory,ownerForum)" +
                    " VALUES (?,?,?)");
            statement.setString(1, forum.getName());
            statement.setInt(2, forum.getOwnerCategoryId());
            statement.setInt(3, forum.getOwnerForumId());
            returnCod = Integer.toString(statement.executeUpdate());
        } catch (SQLException e) {
            throw new DaoExeption(DaoExeption._FAIL_TO_INSERT);
        } finally {
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
        return returnCod;
    }

    @Override
    public Forum getForumById(int id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Forum forum;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM forums WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            forum = new Forum();
            forum.setId(resultSet.getInt("id"));
            forum.setName(resultSet.getString("name"));
            forum.setOwnerCategoryId(resultSet.getInt("ownerCategory"));
            forum.setOwnerCategoryId(resultSet.getInt("ownerForum"));

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
        return forum;
    }

    @Override
    public List<Forum> getAllForums() throws DaoExeption {
        return null;
    }

    @Override
    public String updateForumById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public String dropForumById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public List<Forum> getFouremFromTo(int from, int to) throws DaoExeption {
        return null;
    }

    @Override
    public List<Forum> getAllForumsByOwnerCategoryID(int id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Forum> forumList = new ArrayList<>();
        Forum forum;
        List<Topic> topicList;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement("SELECT forums.id, forums.name, forums.ownerCategory " +
                    "FROM forums WHERE ownerCategory = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                forum = new Forum();
                forum.setId(resultSet.getInt("id"));
                forum.setName(resultSet.getString("name"));
                forum.setOwnerCategoryId(resultSet.getInt("ownerCategory"));
                topicList = topicDao.getAllTopicsByOwnerForumID(forum.getId());
                forum.setTopics(topicList);
                int postCount = 0;
                for (Topic topic : topicList) {
                    postCount = postCount + topic.getComments().size();
                }
                forum.setPostsCount(postCount);
                forumList.add(forum);
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
        return forumList;
    }
}
