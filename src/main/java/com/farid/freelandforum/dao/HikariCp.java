package com.farid.freelandforum.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Setter
@Component
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
