package edu.iba.sh.dao.db2DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.iba.sh.bean.Professor;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.ProfessorDAO;

public class DB2ProfessorDAOImpl extends AbstractDB2DAO implements ProfessorDAO {

    private final static String GET_ALL_QUERY =
            "SELECT ID, FIRST_NAME, SECOND_NAME,"
                    + " FATHER_NAME, BIRTH_DATE, AVG_MARK"
                    + " FROM LAPUSHA.PROFESSORS";
    private final static String GET_BY_ID_QUERY =
            "SELECT ID, FIRST_NAME, SECOND_NAME,"
                    + " FATHER_NAME, BIRTH_DATE, AVG_MARK"
                    + " FROM LAPUSHA.PROFESSORS"
                    + " WHERE ID = ?";
    private final static String SAVE_QUERY =
            "INSERT INTO LAPUSHA.PROFESSORS"
                    + " (ID, FIRST_NAME, SECOND_NAME, FATHER_NAME, BIRTH_DATE, AVG_MARK)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
    private final static String UPDATE_QUERY =
            "UPDATE LAPUSHA.PROFESSORS"
                    + " SET FIRST_NAME = ?, SECOND_NAME = ?, FATHER_NAME = ?,"
                    + " BIRTH_DATE = ?, AVG_MARK = ?"
                    + " WHERE ID = ?";
    private final static String REMOVE_QUERY =
            "DELETE FROM LAPUSHA.PROFESSORS WHERE ID = ?";

    @Override
    public Professor getProfessorById(int id) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        Professor professor = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_BY_ID_QUERY);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                professor.setId(resultSet.getInt("ID"));
                professor.setFirstName(resultSet.getString("FIRST_NAME"));
                professor.setFatherName(resultSet.getString("FATHER_NAME"));
                professor.setSecondName(resultSet.getString("SECOND_NAME"));
                professor.setBirthDate(resultSet.getString("BIRTH_DATE"));
                professor.setAvgMark(resultSet.getDouble("AVG_MARK"));
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
        }

        return professor;
    }

    @Override
    public List<Professor> getAllProfessors() throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Professor> professors = new ArrayList<Professor>();

        try {
            connection = getConnection();
            statement = connection.prepareStatement(GET_ALL_QUERY);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Professor professor = new Professor();
                professor.setId(resultSet.getInt("ID"));
                professor.setFirstName(resultSet.getString("FIRST_NAME"));
                professor.setFatherName(resultSet.getString("FATHER_NAME"));
                professor.setSecondName(resultSet.getString("SECOND_NAME"));
                professor.setBirthDate(resultSet.getString("BIRTH_DATE"));
                professor.setAvgMark(resultSet.getDouble("AVG_MARK"));

                professors.add(professor);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
        }

        return professors;
    }

    @Override
    public void saveProfessor(Professor professor) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(SAVE_QUERY);
            statement.setInt(1, professor.getId());
            statement.setString(2, professor.getFirstName());
            statement.setString(3, professor.getSecondName());
            statement.setString(4, professor.getFatherName());
            statement.setString(5, professor.getBirthDate());
            statement.setDouble(6, professor.getAvgMark());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
        }
    }

    @Override
    public void updateProfessor(int id, Professor professor) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();

            statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, professor.getFirstName());
            statement.setString(2, professor.getSecondName());
            statement.setString(3, professor.getFatherName());
            statement.setString(4,   professor.getBirthDate());
            statement.setDouble(5, professor.getAvgMark());
            statement.setInt(6, professor.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
        }
    }

    @Override
    public void removeProfessor(int id) throws DAOException {
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
            closeDBStatement(statement);
            closeDBConnection(connection);
        }
    }
}