package edu.iba.sh.dao;

import edu.iba.sh.bean.Student;

import java.util.List;

public interface StudentDAO {
    Student getStudentById(int id) throws DAOException;
    List<Student> getAllStudents() throws DAOException;
    List<Student> getStudentsByGroupNumber(int groupNumber) throws DAOException;
    void saveStudent(Student student) throws DAOException;
    void updateStudent(int id, Student student) throws DAOException;
    void removeStudent(int id) throws DAOException;
}