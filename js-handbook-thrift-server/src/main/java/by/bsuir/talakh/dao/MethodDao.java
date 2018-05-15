package by.bsuir.talakh.dao;

import by.bsuir.talakh.method.Method;
import by.bsuir.talakh.method.MethodService;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MethodDao implements MethodService.Iface {

    private final Logger LOGGER = Logger.getLogger(MethodDao.class);

    private final static String ADD_METHOD_QUERY = "INSERT INTO method ( method_name, " +
            "                                           method_description, " +
            "                                           method_object_id) " +
            "                               VALUES (?, ?, ?);";
    private final static String FIND_OBJECT_ID = "SELECT object_id FROM object WHERE object_name = ?";
    private final static String TAKE_ALL_METHODS_QUERY = "SELECT method_id, " +
            "                                           method_name, " +
            "                                           method_description " +
            "                               FROM method WHERE method_object_id = ?";
    private final static String TAKE_METHOD_BY_ID_QUERY = "SELECT method_name, " +
            "                                           method_description, " +
            "                                           method_object_id " +
            "                               FROM method WHERE method_id = ?";
    private final static String TAKE_METHOD_BY_NAME_QUERY = "SELECT method_id, " +
            "                                           method_description, " +
            "                                           method_object_id " +
            "                               FROM method WHERE method_name = ?";
    private final static String UPDATE_METHOD_QUERY = "UPDATE  method " +
            "                    SET method_description = ? " +
            "                  WHERE method_name = ?";
    private final static String DELETE_METHOD_QUERY = "DELETE FROM method WHERE method_id= ?";

    public void addMethod(Method method) throws TException {
        LOGGER.info("Trying to add  " + method);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionConfig.getConnection();
            String methodName = method.getName();
            String methodDescription = method.getDescription();
            String objectName = method.getObjectName();
            preparedStatement = connection.prepareStatement(FIND_OBJECT_ID);
            preparedStatement.setString(1, objectName);
            resultSet = preparedStatement.executeQuery();

            int objectId;
            if (resultSet.next()) {
                objectId = resultSet.getInt(1);
                preparedStatement = connection.prepareStatement(ADD_METHOD_QUERY);

                preparedStatement.setString(1, methodName);
                preparedStatement.setString(2, methodDescription);
                preparedStatement.setInt(3, objectId);

                preparedStatement.executeUpdate();
            }


        } catch (SQLException e) {
            LOGGER.error("Failed to add method to data base", e);
            throw new DaoException("Failed to add method to data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public List<Method> takeAll(int objectId) throws TException {
        LOGGER.info("Trying to take all method for object with id " + objectId);
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.prepareStatement(TAKE_ALL_METHODS_QUERY);
            statement.setInt(1, objectId);
            resultSet = statement.executeQuery();

            List<Method> methodList = new ArrayList<Method>();

            while (resultSet.next()) {
                Method method = new Method();

                method.setId(resultSet.getInt(1));
                method.setName(resultSet.getString(2));
                method.setDescription(resultSet.getString(3));
                method.setObjectId(objectId);

                methodList.add(method);
            }
            return methodList;

        } catch (SQLException e) {
            LOGGER.error("Failed to take list of methods from data base", e);
            throw new DaoException("Failed to take list of methods from data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }

    public void updateMethod(Method method) throws TException {
        LOGGER.info("Trying to update " + method);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            String methodName = method.getName();
            String methodDescription = method.getDescription();

            preparedStatement = connection.prepareStatement(UPDATE_METHOD_QUERY);

            preparedStatement.setString(2, methodName);
            preparedStatement.setString(1, methodDescription);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to update method in data base", e);
            throw new DaoException("Failed to update method in data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public void deleteMethod(Method method) throws TException {
        LOGGER.info("Trying to delete " + method);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            int methodId = method.getId();

            preparedStatement = connection.prepareStatement(DELETE_METHOD_QUERY);

            preparedStatement.setInt(1, methodId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to delete method from data base", e);
            throw new DaoException("Failed to delete method from data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public Method findById(int id) throws TException {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(TAKE_METHOD_BY_ID_QUERY);

            Method method = new Method();

            if (resultSet.next()) {


                method.setId(id);
                method.setName(resultSet.getString(1));
                method.setDescription(resultSet.getString(2));
                method.setObjectId(resultSet.getInt(3));

                return method;
            } else {
                throw new DaoException("Could not find method with id" + id);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to take method from data base with id" + id, e);
            throw new DaoException("Failed to take method from data base with id" + id, e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }

    public Method findByName(String name) throws TException {
        LOGGER.info("Searching for method '" + name + "'");
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.prepareStatement(TAKE_METHOD_BY_NAME_QUERY);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            Method method = new Method();

            if (resultSet.next()) {


                method.setId(resultSet.getInt(1));
                method.setName(name);
                method.setDescription(resultSet.getString(2));
                method.setObjectId(resultSet.getInt(3));

                return method;
            } else {
                throw new DaoException("Could not find method with name " + name);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to take method from data base with name " + name, e);
            throw new DaoException("Failed to take method from data base with name " + name, e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }
}
