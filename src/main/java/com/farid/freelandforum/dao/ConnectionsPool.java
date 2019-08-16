package com.farid.freelandforum.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionsPool {

    Connection getConnection() throws SQLException;

}
