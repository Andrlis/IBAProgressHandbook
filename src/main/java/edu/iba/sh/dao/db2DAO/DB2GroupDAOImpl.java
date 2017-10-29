package edu.iba.sh.dao.db2DAO;

import edu.iba.sh.dao.GroupDAO;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.bean.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB2GroupDAOImpl extends AbstractDB2DAO implements GroupDAO {

    private final static String GET_ALL_QUERY =
            "SELECT GROUP_NUMBER, AVG_MARK FROM LAPUSHA.GROUPS";
    private final static String GET_BY_NUMBER_QUERY =
            "SELECT GROUP_NUMBER, AVG_MARK FROM LAPUSHA.GROUPS"
                    + " WHERE GROUP_NUMBER = ?";
    private final static String SAVE_QUERY =
            "INSERT INTO LAPUSHA.GROUPS (GROUP_NUMBER, AVG_MARK)"
                    + " VALUES (?, ?)";
    private final static String UPDATE_QUERY =
            "UPDATE LAPUSHA.GROUPS SET AVG_MARK = ?"
                    + " WHERE LAPUSHA.GROUP_NUMBER = ?";
    private final static String REMOVE_QUERY =
            "DELETE FROM LAPUSHA.GROUPS WHERE LAPUSHA.GROUP_NUMBER = ?";

    @Override
    public Group getGroupByNumber(int number) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Group group = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_NUMBER_QUERY);
            statement.setInt(1, number);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                group = new Group();
                group.setGroupNumber(resultSet.getString("GROUP_NUMBER"));
                group.setAvgMark(Double.parseDouble(resultSet.getString("AVG_MARK")));

            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
        }

        return group;
    }

    @Override
    public List<Group> getAllGroups() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Group> groups = new ArrayList<Group>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_QUERY);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Group group = new Group();
                group.setGroupNumber(resultSet.getString("GROUP_NUMBER"));
                group.setAvgMark(Double.parseDouble(resultSet.getString("AVG_MARK")));

                groups.add(group);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
        }

        return groups;
    }

    @Override
    public void saveGroup(Group group) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(SAVE_QUERY);
            statement.setString(1, group.getGroupNumber());
            statement.setDouble(2, group.getAvgMark());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
        }
    }

    @Override
    public void updateGroup(int groupNumber, Group group) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setDouble(1, group.getAvgMark());
            statement.setInt(2, groupNumber);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
        }
    }

    @Override
    public void removeGroup(String groupNumber) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_QUERY);
            statement.setString(1, groupNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
        }
    }
}