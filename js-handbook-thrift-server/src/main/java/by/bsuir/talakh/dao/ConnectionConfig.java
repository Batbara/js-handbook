package by.bsuir.talakh.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ConnectionConfig {

    private final static Logger LOGGER = Logger.getLogger(ConnectionConfig.class);

    public static Connection getConnection() throws SQLException {
        ResourceBundle dbBundle =
                ResourceBundle.getBundle(DBParameter.BASE_NAME);

        String driverName = dbBundle.getString(DBParameter.DB_DRIVER);
        String url = dbBundle.getString(DBParameter.DB_URL);
        String user = dbBundle.getString(DBParameter.DB_USER);
        String password = dbBundle.getString(DBParameter.DB_PASSWORD);
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Couldn't find driver class", e);
        }
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeResources(Connection connection, Statement st, ResultSet rs) {
        closeConnection(connection);
        closeResultSet(rs);
        closeStatement(st);
    }

    public static void closeResources(Connection connection, Statement st) {
        closeConnection(connection);
        closeStatement(st);
    }

    public static void closeResources(Statement st) {
        closeStatement(st);
    }

    private static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Closing connection error", e);
            throw new ClosingResourcesException("Closing connection error", e);
        }
    }

    private static void closeStatement(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Closing statement error", e);
            throw new ClosingResourcesException("Closing statement error", e);
        }
    }

    private static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            LOGGER.error("Closing result set error", e);
            throw new ClosingResourcesException("Closing result set error", e);
        }
    }
}
