package edu.iba.sh.dao;

import edu.iba.sh.bean.Mark;

import java.util.List;

public interface MarkDAO {
    Mark getMarkById(int id) throws DAOException;
    List<Mark> getAllMarks() throws DAOException;
    List<Mark> getMarksByStudentId(int id) throws DAOException;
    List<Mark> getMarksByProfessorId(int id) throws DAOException;
    List<Mark> getMarksByStudyId(int id) throws DAOException;
    void saveMark(Mark mark) throws DAOException;
    void updateMark(int id, Mark mark) throws DAOException;
    void removeMark(int id) throws DAOException;
}