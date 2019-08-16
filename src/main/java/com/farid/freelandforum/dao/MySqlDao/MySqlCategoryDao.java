package com.farid.freelandforum.dao.MySqlDao;

import com.farid.freelandforum.dao.CategoryDao;
import com.farid.freelandforum.dao.DaoExeption;
import com.farid.freelandforum.dao.HikariCp;
import com.farid.freelandforum.model.FСategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlCategoryDao implements CategoryDao {

    private HikariCp connectionPool;

    public MySqlCategoryDao(HikariCp connectionPool) {
        this.connectionPool = connectionPool;
    }


    @Override
    public String createCategory(FСategory category) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        int cod;
        String returnCod;

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement("INSERT INTO category VALUE ?");
            statement.setString(1, category.getName());
            cod = statement.executeUpdate();
            returnCod = Integer.toString(cod);
        } catch (SQLException e) {
            throw new DaoExeption(DaoExeption._SQL_ERROR);
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
    public FСategory getCategoryById(int id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        FСategory category = new FСategory();

        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            category.setId(resultSet.getInt("id"));
            category.setName(resultSet.getString("name"));

        } catch (SQLException e) {
            throw new DaoExeption(DaoExeption._SQL_ERROR);
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
        return category;
    }

}

    @Override
    public List<FСategory> getAllCategorys() throws DaoExeption {
        return null;
    }

    @Override
    public String updateCategoryById(int id) throws DaoExeption {
        return null;
    }

    @Override
    public String dropCategoryById(int id) throws DaoExeption {
        return null;
    }
}
