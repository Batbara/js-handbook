package by.bsuir.talakh.dao;

import by.bsuir.talakh.entity.Operator;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperatorDao {
    private final Logger LOGGER = Logger.getLogger(OperatorDao.class);

    private final static String ADD_OPERATOR_QUERY = "INSERT INTO operator ( operator_name, " +
            "                                           operator_symbol, " +
            "                                           operator_description) " +
            "                               VALUES (?, ?, ?);";
    private final static String TAKE_ALL_OPERATORS_QUERY = "SELECT operator_id, " +
            "                                           operator_name, " +
            "                                           operator_symbol, " +
            "                                           operator_description " +
            "                               FROM operator";
    private final static String TAKE_OPERATOR_BY_ID_QUERY = "SELECT operator_name, " +
            "                                           operator_symbol, " +
            "                                           operator_description " +
            "                               FROM operator WHERE operator_id = ?";
    private final static String TAKE_OPERATOR_BY_NAME_QUERY = "SELECT operator_id, " +
            "                                           operator_symbol, " +
            "                                           operator_description " +
            "                               FROM operator WHERE operator_name = ?";

    private final static String UPDATE_OPERATOR_QUERY = "UPDATE  operator " +
            "                    SET operator_description = ? " +
            "                  WHERE operator_name = ?";


    private final static String DELETE_OPERATOR_QUERY = "DELETE FROM operator WHERE operator_id= ?";

    public void addOperator(Operator operator) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            String operatorName = operator.getName();
            String operatorSymbol = operator.getOperatorSymbol();
            String operatorDescription = operator.getDescription();

            preparedStatement = connection.prepareStatement(ADD_OPERATOR_QUERY);

            preparedStatement.setString(1, operatorName);
            preparedStatement.setString(2, operatorSymbol);
            preparedStatement.setString(3, operatorDescription);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to add operator to data base", e);
            throw new DaoException("Failed to add operator to data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public List<Operator> takeAll() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(TAKE_ALL_OPERATORS_QUERY);

            List<Operator> operatorList = new ArrayList<Operator>();

            while (resultSet.next()) {
                Operator method = new Operator();

                method.setId(resultSet.getInt(1));
                method.setName(resultSet.getString(2));
                method.setOperatorSymbol(resultSet.getString(3));
                method.setDescription(resultSet.getString(4));

                operatorList.add(method);
            }
            return operatorList;

        } catch (SQLException e) {
            LOGGER.error("Failed to take list of operators from data base", e);
            throw new DaoException("Failed to take list of operators from data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }

    public void updateOperator(Operator operator) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            String operatorName = operator.getName();
            String operatorDescription = operator.getDescription();

            preparedStatement = connection.prepareStatement(UPDATE_OPERATOR_QUERY);

            preparedStatement.setString(2, operatorName);
            preparedStatement.setString(1, operatorDescription);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to update operator in data base", e);
            throw new DaoException("Failed to update operator in data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public void deleteOperator(Operator operator) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfig.getConnection();
            int operatorId = operator.getId();

            preparedStatement = connection.prepareStatement(DELETE_OPERATOR_QUERY);

            preparedStatement.setInt(1, operatorId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to delete operator from data base", e);
            throw new DaoException("Failed to delete operator from data base", e);
        } finally {
            ConnectionConfig.closeResources(connection, preparedStatement);
        }
    }

    public Operator findById(int id) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(TAKE_OPERATOR_BY_ID_QUERY);

            Operator operator = new Operator();

            if (resultSet.next()) {


                operator.setId(id);
                operator.setName(resultSet.getString(1));
                operator.setOperatorSymbol(resultSet.getString(2));
                operator.setDescription(resultSet.getString(3));

                return operator;
            } else {
                throw new DaoException("Could not find operator with id" + id);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to take method from data base with id" + id, e);
            throw new DaoException("Failed to take method from data base with id" + id, e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }

    public Operator findByName(String name) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionConfig.getConnection();
            statement = connection.prepareStatement(TAKE_OPERATOR_BY_NAME_QUERY);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            Operator operator = new Operator();

            if (resultSet.next()) {

                operator.setId(resultSet.getInt(1));
                operator.setName(name);
                operator.setOperatorSymbol(resultSet.getString(2));
                operator.setDescription(resultSet.getString(3));

                return operator;
            } else {
                throw new DaoException("Could not find operator with name" + name);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to take method from data base with name " + name, e);
            throw new DaoException("Failed to take method from data base with name " + name, e);
        } finally {
            ConnectionConfig.closeResources(connection, statement, resultSet);
        }
    }
}
