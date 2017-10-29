package edu.iba.sh.dao.mySqlDAO;

import edu.iba.sh.dao.DAOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class AbstractSqlDAO {
    protected Connection getConnection() throws DAOException{
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibastudentshelper", "root", "root");

        } catch (ClassNotFoundException e) {
            throw new DAOException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return connection;
    }

    protected void closeDB(Connection connection,
                            Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void closeDB(Connection connection,
                           Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}