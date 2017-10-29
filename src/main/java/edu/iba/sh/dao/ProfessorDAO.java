package edu.iba.sh.dao;

import edu.iba.sh.bean.Professor;

import java.util.List;

public interface ProfessorDAO {
    Professor getProfessorById(int id) throws DAOException;
    List<Professor> getAllProfessors() throws DAOException;
    void saveProfessor(Professor professor) throws DAOException;
    void updateProfessor(int id, Professor professor) throws DAOException;
    void removeProfessor(int id) throws DAOException;
}