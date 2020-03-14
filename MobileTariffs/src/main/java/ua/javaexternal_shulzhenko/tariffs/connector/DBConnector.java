package ua.javaexternal_shulzhenko.tariffs.connector;

import ua.javaexternal_shulzhenko.tariffs.dao.DBQueries;
import ua.javaexternal_shulzhenko.tariffs.dao.TariffDAO;

import java.sql.*;

import java.util.ResourceBundle;

public class DBConnector {

    private Connection connection;

    public DBConnector(DataBases dbenum) throws SQLException {
        setUpConnector(dbenum);
    }

    private void setUpConnector(DataBases dbenum) throws SQLException {
        String dbName = dbenum.getName();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("dbresources");
        connection = DriverManager.getConnection(resourceBundle.getString(dbName + "url" ),
                                                 resourceBundle.getString(dbName + "login"),
                                                 resourceBundle.getString(dbName + "pass"));
    };

    public Statement getStatement() throws SQLException {
        if(connection != null){
            Statement statement = connection.createStatement();
            if(statement != null){
                return statement;
            }
        }
        throw  new SQLException("Connection or statement is null.");
    }

    public PreparedStatement getPreparedStatement(DBQueries query) throws SQLException {
        if(connection != null){
            PreparedStatement preparedStatement = connection.prepareStatement(query.getQuery());
            if(preparedStatement != null){
                return preparedStatement;
            }
        }
        throw new SQLException("Connection or prepared statement is null.");
    }

    public CallableStatement getCallableStatement(DBQueries query) throws SQLException {
        if(connection != null){
            CallableStatement callablestatement = connection.prepareCall(query.getQuery());
            if(callablestatement != null){
                return callablestatement;
            }
        }
        throw new SQLException("Connection or prepared statement is null.");
    }

    public void closeStatement(Statement statement) throws SQLException {
        if(statement != null){
            statement.close();
        }
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
