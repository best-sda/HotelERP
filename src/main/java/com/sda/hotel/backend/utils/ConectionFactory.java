/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:32
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 20:15
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 19:55
 */

/*
 * Created by Dmitry Scherbakov on 09.02.2020, 17:48
 */

package com.sda.hotel.backend.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Collection;

public class ConectionFactory {
    private String driverClassName = "";
    private String connectionURL = "jdbc:postgresql://localhost:5432/hotel";
    private String dbUser = "postgres";
    private String dbPass = "postgres";
    private static ConectionFactory conectionFactory;
    Logger logger = LogManager.getLogger(ConectionFactory.class);

    public Connection getConnection() {

        Connection connection = null;
        try {
           // Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL, dbUser, dbPass);
            return connection;
        } catch (SQLException e) {
            logger.error("Connection to db failed " + e);
            return null;
        }
    }

    public static ConectionFactory getInstance() {
        if (conectionFactory == null) {
            conectionFactory = new ConectionFactory();
        }
        return conectionFactory;
    }


}
