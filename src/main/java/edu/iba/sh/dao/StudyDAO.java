package edu.iba.sh.dao;

import edu.iba.sh.bean.Study;

import java.util.List;

public interface StudyDAO {
    Study getStudyById(int id) throws DAOException;
    List<Study> getAllStudies() throws DAOException;
    List<Study> getStudiesByProfessorId(int id) throws DAOException;
    void saveStudy(Study study) throws DAOException;
    void updateStudy(int id, Study study) throws DAOException;
    void removeStudy(int id) throws DAOException;
}