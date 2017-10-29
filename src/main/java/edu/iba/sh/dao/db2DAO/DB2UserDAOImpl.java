package edu.iba.sh.dao.db2DAO;

import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.UserDAO;
import edu.iba.sh.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB2UserDAOImpl extends AbstractDB2DAO implements UserDAO{


    private final static String GET_ALL_QUERY =
            "SELECT \"USER\", PASSWORD, ROLE FROM LAPUSHA.USERS";
    private final static String GET_BY_ID_QUERY =
            "SELECT \"USER\", PASSWORD, ROLE FROM LAPUSHA.USERS"
                    + " WHERE LAPUSHA.USER = ?";
    private final static String SAVE_QUERY =
            "INSERT INTO LAPUSHA.USERS (\"USER\", PASSWORD, ROLE)"
                    + " VALUES (?, ?, ?)";
    private final static String UPDATE_QUERY =
            "UPDATE LAPUSHA.USERS SET PASSWORD = ?, ROLE = ?"
                    + " WHERE \"USER\" = ?";
    private final static String REMOVE_QUERY =
            "DELETE FROM LAPUSHA.USERS WHERE \"USER\" = ?";

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
                user.setUser(resultSet.getString("USER"));
                user.setPassword(resultSet.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
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

                users.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
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
            statement.setString(3, user.getRole().toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
        }
    }

    @Override
    public void udateUser(String name, User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getRole().toString());
            statement.setString(3, name);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
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
            throw new DAOException();
        } finally {
           closeDBConnection(connection);
           closeDBStatement(statement);
        }
    }

}