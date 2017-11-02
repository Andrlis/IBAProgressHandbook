package edu.iba.sh.dao.mySqlDAO;

import edu.iba.sh.bean.Study;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.StudyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLStudyDAOImpl extends AbstractSqlDAO implements StudyDAO {

    private final static String GET_ALL_QUERY =
            "SELECT ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK FROM ibastudentshelper.studies";
    private final static String GET_BY_ID_QUERY =
            "SELECT ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK FROM ibastudentshelper.studies"
                    + " WHERE ID = ?";
    private final static String GET_BY_PROFESSOR_ID =
            "SELECT ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK FROM ibastudentshelper.studies"
                    + " WHERE ID = ?";
    private final static String SAVE_QUERY =
            "INSERT INTO ibastudentshelper.studies (ID, NAME, HOURS, PROFESSOR_ID, AVG_MARK)"
                    + " VALUES (?, ?, ?, ?, ?)";
    private final static String UPDATE_QUERY =
            "UPDATE ibastudentshelper.studies SET NAME = ?, HOURS = ?, PROFESSOR_ID = ?, AVG_MARK = ?"
                    + " WHERE ID = ?";
    private final static String REMOVE_QUERY =
            "DELETE FROM ibastudentshelper.studies WHERE ID = ?";

    @Override
    public Study getStudyById(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Study study = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID_QUERY);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                study = new Study();
                study.setId(resultSet.getInt("ID"));
                study.setName(resultSet.getString("NAME"));
                study.setHours(resultSet.getInt("HOURS"));
                study.setProfessorId(resultSet.getInt("PROFESSOR_ID"));
                study.setAvgMark(resultSet.getDouble("AVG_MARK"));
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB(connection, statement, resultSet);
        }

        return study;
    }

    @Override
    public List<Study> getAllStudies() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Study> studies = new ArrayList<Study>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_QUERY);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Study study = new Study();
                study.setId(resultSet.getInt("ID"));
                study.setName(resultSet.getString("NAME"));
                study.setHours(resultSet.getInt("HOURS"));
                study.setProfessorId(resultSet.getInt("PROFESSOR_ID"));
                study.setAvgMark(resultSet.getDouble("AVG_MARK"));
                studies.add(study);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB(connection, statement, resultSet);
        }

        return studies;
    }

    @Override
    public List<Study> getStudiesByProfessorId(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Study> studies = new ArrayList<Study>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_PROFESSOR_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Study study = new Study();
                study.setId(resultSet.getInt("ID"));
                study.setName(resultSet.getString("NAME"));
                study.setHours(resultSet.getInt("HOURS"));
                study.setProfessorId(resultSet.getInt("PROFESSOR_ID"));
                study.setAvgMark(resultSet.getDouble("AVG_MARK"));

                studies.add(study);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB(connection, statement, resultSet);
        }

        return studies;
    }

    @Override
    public void saveStudy(Study study) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(SAVE_QUERY);
            statement.setInt(1, study.getId());
            statement.setString(2, study.getName());
            statement.setInt(3, study.getHours());
            statement.setInt(4, study.getProfessorId());
            statement.setDouble(5, study.getAvgMark());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB(connection, statement);
        }
    }

    @Override
    public void removeStudy(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(REMOVE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB(connection, statement);
        }
    }

    @Override
    public void updateStudy(int id, Study study) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, study.getName());
            statement.setInt(2, study.getHours());
            statement.setInt(3, study.getProfessorId());
            statement.setDouble(4, study.getAvgMark());
            statement.setInt(5, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB(connection, statement);
        }
    }
}