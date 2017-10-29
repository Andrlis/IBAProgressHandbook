package edu.iba.sh.dao;

import edu.iba.sh.dao.db2DAO.DB2UserDAOImpl;
import edu.iba.sh.dao.db2DAO.DB2StudentDAOImpl;

public class DAOFactory {

	private enum DbType {DB2, MySQL};
	
	private static DbType type = DbType.DB2;
	
	public static StudentDAO getStudentDao(){
		switch (type){
		case DB2:
			return new DB2StudentDAOImpl();
		default:
			return null;
		}
	}
	
	public static UserDAO getUserDao(){
		switch (type){
		case DB2:
			return new DB2UserDAOImpl();
		default:
			return null;
		}
	}
}
