package edu.iba.sh.dao.db2DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.iba.sh.bean.Mark;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.MarkDAO;

public class DB2MarkDAOImpl extends AbstractDB2DAO implements MarkDAO {

	private final static String GET_ALL_QUERY = "SELECT ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS" 
			+ "FROM LAPUSHA.MARKS";
	private final static String GET_BY_ID_QUERY = "SELECT ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS" 
		+ "FROM LAPUSHA.MARKS"
		+" WHERE ID = ?";
	private final static String GET_BY_STUDENT_ID_QUERY = "SELECT ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS" 
		+ "FROM LAPUSHA.MARKS"
		+" WHERE STUDENT_ID = ?";
	private final static String GET_BY_STUDY_ID_QUERY = "SELECT ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS" 
		+ "FROM LAPUSHA.MARKS"
		+" WHERE STUDY_ID = ?";
	private final static String GET_BY_PROFESSOR_ID_QUERY = "SELECT ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS" 
		+ "FROM LAPUSHA.MARKS"
		+" WHERE PROFESSOR_ID = ?";
	private final static String SAVE_QUERY = "INSERT INTO LAPUSHA.MARKS"
		+"(ID, STUDY_ID, STUDENT_ID, DATE, PROFESSOR_ID, MARK, COMMENTS)" 
		+" VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final static String UPDATE_QUERY = "UPDATE LAPUSHA.MARKS SET"
		+" STUDY_ID = ?, STUDENT_ID = ?, DATE = ?, PROFESSOR_ID = ?"
		+" MARK = ?, COMMENTS = ?"
		+" WHERE ID = ?";
	private final static String DELETE_QUERY = "DELETE FROM LAPUSHA.MARKS WHERE ID =?";
	
	@Override
	public Mark getMarkById(int id) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Mark mark = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_BY_ID_QUERY);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				mark = new Mark();
				
				mark.setId(resultSet.getInt("ID"));
				mark.setStudentId(resultSet.getInt("STUDENT_ID"));
				mark.setProfessorId(resultSet.getInt("PROFESSOR_ID"));
				mark.setStudyId(resultSet.getInt("STUDY_ID"));
				mark.setDate(resultSet.getString("DATE"));
				mark.setMark(resultSet.getInt("MARK"));
				mark.setComments(resultSet.getString("COMMENTS"));
							
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
		return mark;
	}
	
	@Override
    public List<Mark> getAllMarks() throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Mark> marks = new ArrayList<Mark>();
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_ALL_QUERY);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Mark mark = new Mark();
				
				
				mark.setId(resultSet.getInt("ID"));
				mark.setStudentId(resultSet.getInt("STUDENT_ID"));
				mark.setProfessorId(resultSet.getInt("PROFESSOR_ID"));
				mark.setStudyId(resultSet.getInt("STUDY_ID"));
				mark.setDate(resultSet.getString("DATE"));
				mark.setMark(resultSet.getInt("MARK"));
				mark.setComments(resultSet.getString("COMMENTS"));
				
				marks.add(mark);
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
		
		return marks;
    }
    
	@Override
    public List<Mark> getMarksByStudentId(int id) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Mark> marks = new ArrayList<Mark>();
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_BY_STUDENT_ID_QUERY);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Mark mark = new Mark();
				
				
				mark.setId(resultSet.getInt("ID"));
				mark.setStudentId(resultSet.getInt("STUDENT_ID"));
				mark.setProfessorId(resultSet.getInt("PROFESSOR_ID"));
				mark.setStudyId(resultSet.getInt("STUDY_ID"));
				mark.setDate(resultSet.getString("DATE"));
				mark.setMark(resultSet.getInt("MARK"));
				mark.setComments(resultSet.getString("COMMENTS"));
				
				marks.add(mark);
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
		
		return marks;
    }
    
	@Override
	public List<Mark> getMarksByProfessorId(int id) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Mark> marks = new ArrayList<Mark>();
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_BY_PROFESSOR_ID_QUERY);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Mark mark = new Mark();
				
				
				mark.setId(resultSet.getInt("ID"));
				mark.setStudentId(resultSet.getInt("STUDENT_ID"));
				mark.setProfessorId(resultSet.getInt("PROFESSOR_ID"));
				mark.setStudyId(resultSet.getInt("STUDY_ID"));
				mark.setDate(resultSet.getString("DATE"));
				mark.setMark(resultSet.getInt("MARK"));
				mark.setComments(resultSet.getString("COMMENTS"));
				
				marks.add(mark);
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
		
		return marks;
    }
    
	@Override
	public List<Mark> getMarksByStudyId(int id) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Mark> marks = new ArrayList<Mark>();
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_BY_STUDY_ID_QUERY);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Mark mark = new Mark();
				
				
				mark.setId(resultSet.getInt("ID"));
				mark.setStudentId(resultSet.getInt("STUDENT_ID"));
				mark.setProfessorId(resultSet.getInt("PROFESSOR_ID"));
				mark.setStudyId(resultSet.getInt("STUDY_ID"));
				mark.setDate(resultSet.getString("DATE"));
				mark.setMark(resultSet.getInt("MARK"));
				mark.setComments(resultSet.getString("COMMENTS"));
				
				marks.add(mark);
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
		
		return marks;
    }
    
	@Override
	public void saveMark(Mark mark) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = getConnection();
			
			statement = connection.prepareStatement("SAVE_QUERY");
			
			statement.setInt(1, mark.getId());
			statement.setInt(2, mark.getStudyId());
			statement.setInt(3, mark.getStudentId());
			statement.setString(4, mark.getDate());
			statement.setInt(5, mark.getProfessorId());
			statement.setInt(6, mark.getMark());
			statement.setString(7, mark.getComments());
			
			statement.executeUpdate();
		}catch (SQLException e) {
			throw new DAOException();
		} finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
    }
	
	@Override
	public void updateMark(int id, Mark mark) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = getConnection();
			
			statement = connection.prepareStatement("UPDATE_QUERY");
			
			statement.setInt(1, mark.getId());
			statement.setInt(2, mark.getStudyId());
			statement.setInt(3, mark.getStudentId());
			statement.setString(4, mark.getDate());
			statement.setInt(5, mark.getProfessorId());
			statement.setInt(6, mark.getMark());
			statement.setString(7, mark.getComments());
			
			statement.executeUpdate();
		}catch (SQLException e) {
			throw new DAOException();
		} finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
    }
    
	@Override
	public void removeMark(int id) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;

		try{
			connection = getConnection();
			statement = connection.prepareStatement("DELETE_QUERY");
			
			statement.setInt(1, id);
						
			statement.executeUpdate();
		}catch (SQLException e) {
			throw new DAOException();
		} finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
    }
}
