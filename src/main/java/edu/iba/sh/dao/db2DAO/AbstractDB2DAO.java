package edu.iba.sh.dao.db2DAO;

import edu.iba.sh.dao.DAOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDB2DAO {
    protected Connection getConnection() throws DAOException {
        try{
            InitialContext context = new InitialContext();
            DataSource source = (DataSource)context.lookup("jdbc/StudentHelperDB");
            return source.getConnection();
        }catch (NamingException e) {
            throw new DAOException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    protected void closeDBConnection(Connection connection,
                            Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void closeDBStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void closeDBConnection(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void closeDB2Res(ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}