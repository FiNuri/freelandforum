package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.Interfaces.CommentDao;
import com.farid.freelandforum.dao.Interfaces.ConnectionsPool;
import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.Interfaces.UserDao;
import com.farid.freelandforum.model.Comment;
import com.farid.freelandforum.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCommentDao implements CommentDao {

    ConnectionsPool connectionsPool;
    UserDao userDao;

    public MySqlCommentDao(ConnectionsPool connectionsPool, UserDao userDao) {
        this.connectionsPool = connectionsPool;
        this.userDao = userDao;
    }

    @Override
    public String createComment(Comment comment) throws DaoExeption {
        return null;
    }

    @Override
    public Comment getCommentById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public List<Comment> getAllComments() throws DaoExeption {
        return null;
    }

    @Override
    public String updateCommentById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public String dropCommentById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public List<Comment> getCommentFromTo(int from, int to) throws DaoExeption {
        return null;
    }

    @Override
    public List<Comment> getAllCommentsByOwnerTopicId(int id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Comment comment;
        List<Comment> commentList = new ArrayList<>();
        try {
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT comments.id FROM comments WHERE ownerTopic = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                comment = new Comment();
                comment.setId(resultSet.getInt("id"));
            }
        }catch (SQLException e){
            throw new DaoExeption(DaoExeption._SQL_ERROR);
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_RESAULTSET);
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_STATEMANT);
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_CONNECTION);
                }
            }
        }
        return commentList;
    }

    @Override
    public Comment getLastCommenInTopic(int topicID) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Comment lastComment;
        User user;
        try {
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT comments.id, comments.authorID, comments.postDate FROM comments" +
                    " WHERE ownerTopic = ? ORDER BY comments.postDate LIMIT 1");
            statement.setInt(1, topicID);
            resultSet = statement.executeQuery();
            lastComment = new Comment();
            lastComment.setId(resultSet.getInt("id"));
            lastComment.setPostDate(resultSet.getDate("postDate"));
            user = userDao.getUserById(resultSet.getInt("authorID"));
            lastComment.setAuthor(user);
        } catch (SQLException e) {
            throw new DaoExeption(DaoExeption._SQL_ERROR);
        }finally {
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
        return lastComment;
    }
}
