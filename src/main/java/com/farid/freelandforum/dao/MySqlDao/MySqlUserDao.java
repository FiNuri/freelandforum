package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.ConnectionsPool;
import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.UserDao;
import com.farid.freelandforum.model.Rank;
import com.farid.freelandforum.model.Sex;
import com.farid.freelandforum.model.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

public class MySqlUserDao implements UserDao {

    ConnectionsPool connectionsPool;

    public MySqlUserDao(ConnectionsPool connectionsPool) {
        this.connectionsPool = connectionsPool;
    }

    @Override
    public String createUser(User user) throws DaoExeption {
        return null;
    }

    @Override
    public User getUserById(int id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM users WHERE users.id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));
            user.setRating(resultSet.getLong("rating"));
            user.setBirthDate(resultSet.getDate("birthDate"));
            user.setRegistrationDate(resultSet.getDate("registrationDate"));
            user.setSex(Sex.valueOf(resultSet.getString("sex")));
            user.setRank(Rank.valueOf(resultSet.getString("rankk")));
            Blob img = resultSet.getBlob("ava");
            InputStream in = img.getBinaryStream();
            BufferedImage image = ImageIO.read(in);
            user.setAva(image);
            user.setNikName(resultSet.getString("nikName"));
        } catch (SQLException e) {
            throw new DaoExeption(DaoExeption._SQL_ERROR);
        } catch (IOException k) {
            k.printStackTrace();
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
        return user;
    }

    @Override
    public List<User> getAllUsers() throws DaoExeption {
        return null;
    }

    @Override
    public String updateById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public String dropUserById(int id) throws DaoExeption {
        return null;
    }
}
