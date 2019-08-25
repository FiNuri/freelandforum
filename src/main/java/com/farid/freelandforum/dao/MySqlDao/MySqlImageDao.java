package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.Interfaces.ConnectionsPool;
import com.farid.freelandforum.dao.Interfaces.ImageDao;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlImageDao implements ImageDao {

    ConnectionsPool connectionsPool;

    public MySqlImageDao(ConnectionsPool connectionsPool){
        this.connectionsPool = connectionsPool;
    }
    @Override
    public List<Image> getTopicImages(int topicID) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Image> imageList = new ArrayList<>();
        BufferedImage image;

        try {
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM images WHERE ownerTopic = ?");
            statement.setInt(1, topicID);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Blob img = resultSet.getBlob("image");
                InputStream in = img.getBinaryStream();
                image = ImageIO.read(in);
                imageList.add(image);
            }

        }catch (SQLException e){
            throw new DaoExeption(DaoExeption._SQL_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_CONNECTION);
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_STATEMANT);
                }
            }
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_RESAULTSET);
                }
            }
        }
        return imageList;
    }

    @Override
    public List<Image> getCommentImages(int commentID) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Image> imageList = new ArrayList<>();
        BufferedImage img;
        Blob image;
        InputStream inputStream;

        try {
            connection = connectionsPool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM images WHERE ownerComment = ?");
            statement.setInt(1, commentID);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                image = resultSet.getBlob("image");
                inputStream = image.getBinaryStream();
                img = ImageIO.read(inputStream);
                imageList.add(img);
            }

        }catch (SQLException e){
            throw new DaoExeption(DaoExeption._SQL_ERROR);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_CONNECTION);
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_STATEMANT);
                }
            }
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DaoExeption(DaoExeption._CANT_CLOSE_RESAULTSET);
                }
            }
        }
        return imageList;
    }
}
