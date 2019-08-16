package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.ForumDao;
import com.farid.freelandforum.dao.HikariCp;
import com.farid.freelandforum.model.Forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlForumDao implements ForumDao {

    HikariCp connectionPool;

    public MySqlForumDao(HikariCp connectionPool) {
        this.connectionPool = connectionPool;
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
            statement.setString(1,forum.getName());
            statement.setInt(2,forum.getOwnerCategoryId());
            statement.setInt(3,forum.getOwnerForumId());
            returnCod = Integer.toString(statement.executeUpdate());
        }catch (SQLException e){
            throw new DaoExeption(DaoExeption._FAIL_TO_INSERT);
        }finally {
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
                }catch (SQLException e){
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
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            forum = new Forum();
            forum.setId(resultSet.getInt("id"));
            forum.setName(resultSet.getString("name"));
            forum.setOwnerCategoryId(resultSet.getInt("ownerCategory"));
            forum.setOwnerCategoryId(resultSet.getInt("ownerForum"));

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
}
