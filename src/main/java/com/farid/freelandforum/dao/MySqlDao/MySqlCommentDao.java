package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.Interfaces.CommentDao;
import com.farid.freelandforum.dao.Interfaces.ConnectionsPool;
import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.Interfaces.ImageDao;
import com.farid.freelandforum.dao.Interfaces.UserDao;
import com.farid.freelandforum.model.Comment;
import com.farid.freelandforum.model.User;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCommentDao implements CommentDao {

    private ConnectionsPool connectionsPool;
    private UserDao userDao;
    private ImageDao imageDao;

    public MySqlCommentDao(ConnectionsPool connectionsPool, UserDao userDao, ImageDao imageDao) {
        this.connectionsPool = connectionsPool;
        this.userDao = userDao;
        this.imageDao = imageDao;
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

    @Override
    public List<Comment> getCommentsByTopicIdFromTo(int topicID, int from) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Comment> commentList = new ArrayList<>();
        List<Image>  imageList;
        Comment comment;
        User author;
        int to = from + 20;

        try{
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM comments WHERE  ownerTopic = ? ORDER BY comments.id LIMIT ?, ?");
            statement.setInt(1, from);
            statement.setInt(2, to);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                comment = new Comment();
                comment.setId(resultSet.getInt("id"));
                comment.setAuthor(author = userDao.getUserById(resultSet.getInt("authorID")));
                comment.setPostDate(resultSet.getDate("postDate"));
                comment.setData(resultSet.getString("data"));
                comment.setRating(resultSet.getInt("rating"));
                comment.setImages(imageList = imageDao.getCommentImages(comment.getId()));
            }
        }catch (SQLException e){
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
        return commentList;
    }

    @Override
    public long getCommentsCountByTopicID(int topicID) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int intCount;
        long longCount;
        try {
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT COUNT(comments.id) FROM comments WHERE ownerTopic = ?");
            statement.setInt(1, topicID);
            resultSet = statement.executeQuery();
            intCount = resultSet.getInt("id");
            longCount = (long) intCount;
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
        return longCount;
    }
}
