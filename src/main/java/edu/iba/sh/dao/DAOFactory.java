package edu.iba.sh.dao;

import edu.iba.sh.dao.db2DAO.*;
import edu.iba.sh.dao.mySqlDAO.*;

public class DAOFactory {

	private enum DbType {DB2, MySQL}
	
	private static DbType type = DbType.MySQL;
	
	public static StudentDAO getStudentDao(){
		switch (type){
		case DB2:
			return new DB2StudentDAOImpl();
		case MySQL:
            return new MySQLStudentDAOImpl();
		default:
			return null;
		}
	}
	
	public static UserDAO getUserDao(){
		switch (type){
		case DB2:
			return new DB2UserDAOImpl();
		case MySQL:
            return new MySQLUserDAOImpl();
		default:
			return null;
		}
	}

    public static GroupDAO getGroupDao(){
        switch (type){
            case DB2:
                return new DB2GroupDAOImpl();
            case MySQL:
                return new MySQLGroupDAOImpl();
            default:
                return null;
        }
    }

    public static MarkDAO getMarkDao(){
        switch (type){
            case DB2:
                return new DB2MarkDAOImpl();
            case MySQL:
                return new MySQLMarkDAOImpl();
            default:
                return null;
        }
    }

    public static ProfessorDAO getProfessorDao(){
        switch (type){
            case DB2:
                return new DB2ProfessorDAOImpl();
            case MySQL:
                return new MySQLProfessorDAOImpl();
            default:
                return null;
        }
    }

    public static StudyDAO getStudyDao(){
        switch (type){
            case DB2:
                return new DB2StudyDAOImpl();
            case MySQL:
                return new MySQLStudyDAOImpl();
            default:
                return null;
        }
    }
}
