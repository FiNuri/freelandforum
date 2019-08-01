package com.farid.freelandforum.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionsPool {

    public Connection getConnection() throws SQLException;

}
