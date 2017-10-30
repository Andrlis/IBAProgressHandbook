package edu.iba.sh.dao.db2DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.iba.sh.bean.Student;
import edu.iba.sh.dao.DAOException;
import edu.iba.sh.dao.StudentDAO;

public class DB2StudentDAOImpl extends AbstractDB2DAO implements StudentDAO{

	private final static String GET_ALL_QUERY = "SELECT ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP-NUMBER" 
		+" FROM LAPUSHA.STUDENTS";
	private final static String GET_BY_ID_QUERY = "SELECT ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP-NUMBER" 
		+" FROM LAPUSHA.STUDENTS"
		+" WHERE ID = ?";
	private final static String GET_BY_GROUP_NUMBER_QUERY = "SELECT ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP-NUMBER" 
		+" FROM LAPUSHA.STUDENTS"
		+" WHERE STUDENT_ID = ?";
	private final static String SAVE_QUERY = "INSERT INTO LAPUSHA.STUDENTS"
		+"(ID, FIRST_NAME, SECOND_NAME, AVG_MARK, GROUP-NUMBER)" 
		+" VALUES (?, ?, ?, ?, ?,)";
	private final static String UPDATE_QUERY = "UPDATE LAPUSHA.STUDENTS SET"
		+" FIRST_NAME = ?, SECOND_NAME = ?, AVG_MARK = ?, GROUP-NUMBER = ?"
		+" WHERE ID = ?";
	private final static String DELETE_QUERY = "DELETE FROM LAPUSHA.STUDENTS WHERE ID =?";

	@Override
	public Student getStudentById(int id) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Student student = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_BY_ID_QUERY);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				student = new Student();
				
				student.setId(resultSet.getInt("ID"));
				student.setFirstName(resultSet.getString("FIRST_NAME"));
				student.setSecondName(resultSet.getString("SECOND_NAME"));
				student.setAvgMark(resultSet.getDouble("AVG_MARK"));
				student.setGroupNumber(resultSet.getString("GROUP_NUMBER"));
											
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
		return student;
	}
	
	@Override
    public List<Student> getAllStudents() throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_ALL_QUERY);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Student student = new Student();
				
				student.setId(resultSet.getInt("ID"));
				student.setFirstName(resultSet.getString("FIRST_NAME"));
				student.setSecondName(resultSet.getString("SECOND_NAME"));
				student.setAvgMark(resultSet.getDouble("AVG_MARK"));
				student.setGroupNumber(resultSet.getString("GROUP_NUMBER"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
		
		return students;
    }
	
	@Override
    public List<Student> getStudentsByGroupNumber(int groupNumber) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(GET_BY_GROUP_NUMBER_QUERY);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Student student = new Student();
				
				student.setId(resultSet.getInt("ID"));
				student.setFirstName(resultSet.getString("FIRST_NAME"));
				student.setSecondName(resultSet.getString("SECOND_NAME"));
				student.setAvgMark(resultSet.getDouble("AVG_MARK"));
				student.setGroupNumber(resultSet.getString("GROUP_NUMBER"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			throw new DAOException();
		} finally {
			closeDB2Res(resultSet);
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
		
		return students;
    }
	
	@Override
	public void saveStudent(Student student) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = getConnection();
			
			statement = connection.prepareStatement("SAVE_QUERY");
			
			statement.setInt(1, student.getId());
			statement.setString(2, student.getFirstName());
			statement.setString(3, student.getSecondName());
			statement.setDouble(4, student.getAvgMark());
			statement.setString(5, student.getGroupNumber());
			
			statement.executeUpdate();
		}catch (SQLException e) {
			throw new DAOException();
		} finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
    }
	
	@Override
	public void updateStudent(int id, Student student) throws DAOException{
		Connection connection = null;
		PreparedStatement statement = null;
		
		try{
			connection = getConnection();
			
			statement = connection.prepareStatement("UPDATE_QUERY");
		
			statement.setInt(1, student.getId());
			statement.setString(2, student.getFirstName());
			statement.setString(3, student.getSecondName());
			statement.setDouble(4, student.getAvgMark());
			statement.setString(5, student.getGroupNumber());
			
			statement.executeUpdate();
		}catch (SQLException e) {
			throw new DAOException();
		} finally {
            closeDBStatement(statement);
            closeDBConnection(connection);
		}
    }
    
	@Override
	public void removeStudent(int id) throws DAOException{
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
