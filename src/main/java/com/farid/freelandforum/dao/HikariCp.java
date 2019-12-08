package com.farid.freelandforum.dao;

import com.farid.freelandforum.dao.Interfaces.ConnectionsPool;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCp implements ConnectionsPool {

    private HikariDataSource dataSource;

    public HikariCp(HikariConfig config){
        this.dataSource = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
