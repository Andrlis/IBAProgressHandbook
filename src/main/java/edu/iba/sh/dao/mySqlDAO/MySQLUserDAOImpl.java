package edu.iba.sh.dao.mySqlDAO;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.UserDAO;
import edu.iba.sh.bean.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAOImpl extends AbstractSqlDAO implements UserDAO {

    private static final Logger logger = Logger.getLogger(MySQLUserDAOImpl.class);

    private final static String GET_ALL_QUERY =
            "SELECT USER, PASSWORD, ROLE FROM ibastudentshelper.users";
    private final static String GET_BY_ID_QUERY =
            "SELECT USER, PASSWORD, ROLE FROM ibastudentshelper.users"
                    + " WHERE USER = ?";
    private final static String GET_BY_ID_PASSWORD_QUERY =
            "SELECT USER, PASSWORD, ROLE FROM ibastudentshelper.users"
                    + " WHERE USER = ? AND PASSWORD = ?";
    private final static String SAVE_QUERY =
            "INSERT INTO ibastudentshelper.users (USER, PASSWORD, ROLE)"
                    + " VALUES (?, ?, ?)";
    private final static String UPDATE_QUERY =
            "UPDATE ibastudentshelper.users SET PASSWORD = ?, ROLE = ?"
                    + " WHERE USER = ?";
    private final static String REMOVE_QUERY =
            "DELETE FROM ibastudentshelper.users WHERE USER = ?";

    @Override
    public User getUserById(String id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        User user = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID_QUERY);
            statement.setString(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUser(resultSet.getString("USER"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setRole(resultSet.getString("ROLE"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DAOException();
        } finally {
            closeDB(connection, statement, resultSet);
        }

        return user;
    }

    @Override
    public User getUserByIDandPassword(String userId, String password) throws DAOException{
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        User user = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID_PASSWORD_QUERY);
            statement.setString(1, userId);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUser(resultSet.getString("USER"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setRole(resultSet.getString("ROLE"));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DAOException();
        } finally {
            closeDB(connection, statement, resultSet);
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<User> users = new ArrayList<User>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_QUERY);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                User user = new User();
                user.setUser(resultSet.getString("USER"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setRole(resultSet.getString("ROLE"));

                users.add(user);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DAOException();
        } finally {
            closeDB(connection, statement);
        }

        return users;
    }

    @Override
    public void saveUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(SAVE_QUERY);
            statement.setString(1, user.getUser());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DAOException();
        } finally {
            closeDB(connection, statement);
        }
    }

    @Override
    public void updateUser(String name, User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getRole());
            statement.setString(3, name);

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DAOException();
        } finally {
            closeDB(connection, statement);
        }
    }

    @Override
    public void removeUser(String name) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_QUERY);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DAOException();
        } finally {
            closeDB(connection, statement);
        }
    }

}
