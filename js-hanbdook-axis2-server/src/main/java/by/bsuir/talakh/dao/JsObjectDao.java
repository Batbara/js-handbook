package by.bsuir.talakh.dao;

import by.bsuir.talakh.entity.JsObject;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JsObjectDao {

    private final Logger LOGGER = Logger.getLogger(JsObjectDao.class);

    private final static String ADD_OBJECT_QUERY = "INSERT INTO object ( object_name, " +
            "                                           object_descr) " +
            "                               VALUES (?, ?);";
    private final static String TAKE_ALL_OBJECTS_QUERY = "SELECT object_id, " +
            "                                           object_name, " +
            "                                           object_descr " +
            "                               FROM object";
    private final static String TAKE_OBJECT_BY_ID_QUERY = "SELECT object_name, " +
            "                                           object_descr " +
            "                               FROM object WHERE object_id = ?";

    private final static String TAKE_OBJECT_BY_NAME_QUERY = "SELECT object_id, " +
            "                                           object_descr " +
            "                               FROM object WHERE object_name = ?";

    private final static String UPDATE_OBJECT_QUERY = "UPDATE  object " +
            "                    SET object_descr = ? " +
            "                  WHERE object_name = ?";

    private final static String DELETE_OBJECT_QUERY = "DELETE FROM object WHERE object_id= ?";

    public void addObject(JsObject jsObject)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            String objectName = jsObject.getName();
            String methodDescription = jsObject.getDescription();

            preparedStatement = connection.prepareStatement(ADD_OBJECT_QUERY);

            preparedStatement.setString(1, objectName);
            preparedStatement.setString(2, methodDescription);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to add js-object to data base", e);
            throw new DaoException("Failed to add js-object to data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public List<JsObject> takeAll()  {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(TAKE_ALL_OBJECTS_QUERY);

            List<JsObject> jsObjectList = new ArrayList<JsObject>();

            while (resultSet.next()) {
                JsObject jsObject = new JsObject();

                jsObject.setId(resultSet.getInt(1));
                jsObject.setName(resultSet.getString(2));
                jsObject.setDescription(resultSet.getString(3));

                jsObjectList.add(jsObject);
            }
            return jsObjectList;

        } catch (SQLException e) {
            LOGGER.error("Failed to take list of js objects from data base", e);
            throw new DaoException("Failed to take list of js objects from data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }

    public void updateObject(JsObject jsObject)  {
        LOGGER.info("Updating " + jsObject);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            int objectId = jsObject.getId();
            String objectName = jsObject.getName();
            String objectDescription = jsObject.getDescription();

            preparedStatement = connection.prepareStatement(UPDATE_OBJECT_QUERY);

            preparedStatement.setString(2, objectName);
            preparedStatement.setString(1, objectDescription);

            int rowsAffected = preparedStatement.executeUpdate();
            LOGGER.info("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            LOGGER.error("Failed to update js-object in data base", e);
            throw new DaoException("Failed to update js-object in data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public void deleteObject(JsObject jsObject)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            int objectId = jsObject.getId();

            preparedStatement = connection.prepareStatement(DELETE_OBJECT_QUERY);

            preparedStatement.setInt(1, objectId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to delete js-object from data base", e);
            throw new DaoException("Failed to delete js-object from data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public JsObject findById(int id)  {

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(TAKE_OBJECT_BY_ID_QUERY);

            JsObject jsObject = new JsObject();

            if (resultSet.next()) {

                jsObject.setId(id);
                jsObject.setName(resultSet.getString(1));
                jsObject.setDescription(resultSet.getString(2));

                return jsObject;
            } else {
                throw new DaoException("Could not find js-object with id" + id);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to take js-object from data base with id" + id, e);
            throw new DaoException("Failed to take js-object from data base with id" + id, e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }

    public JsObject findByName(String name)  {
        LOGGER.info("Finding object with name " + name);
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.prepareStatement(TAKE_OBJECT_BY_NAME_QUERY);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            JsObject jsObject = new JsObject();

            if (resultSet.next()) {

                jsObject.setId(resultSet.getInt(1));
                jsObject.setName(name);
                jsObject.setDescription(resultSet.getString(2));

                return jsObject;
            } else {
                throw new DaoException("Could not find js-object with name" + name);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to take js-object from data base with name " + name, e);
            throw new DaoException("Failed to take js-object from data base with name " + name, e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }
}
