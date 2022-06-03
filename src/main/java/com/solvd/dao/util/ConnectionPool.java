package com.solvd.dao.util;

import com.solvd.exceptions.ConnectionLimitException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private final String URL = DBProperties.getString(Constants.URL);
    private final String USER = DBProperties.getString(Constants.USERNAME);
    private final String PASS = DBProperties.getString(Constants.PASSWORD);
    private static ConnectionPool datasource;
    private BasicDataSource basicDataSource = null;

    private final static int MAX_CONNECTIONS = DBProperties.getInt(Constants.MAX_CONNECTIONS);
    private int createdConnectionsAmount = 0;

    private List<Connection> connectionList = new ArrayList<>(MAX_CONNECTIONS);

    private ConnectionPool(){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        basicDataSource.setInitialSize(2);
        basicDataSource.setMinIdle(3);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(40);
        basicDataSource.setMaxWaitMillis(10000);
    }

    public static ConnectionPool getInstance(){
        if (datasource == null){
            datasource = new ConnectionPool();
        }
        return datasource;
    }

    public synchronized Connection getConnection(){
        if (!connectionList.isEmpty()){
            return connectionList.remove(0);
        }else if (createdConnectionsAmount<MAX_CONNECTIONS){
            return createConnection();
        }else {
            throw new ConnectionLimitException();
        }
    }

    private Connection createConnection() {
        Connection conn = null;
        try {
            conn = this.basicDataSource.getConnection();
            createdConnectionsAmount++;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public void returnConnection(Connection connection){
        connectionList.add(connection);
    }
}
