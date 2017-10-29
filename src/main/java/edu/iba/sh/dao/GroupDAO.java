package edu.iba.sh.dao;

import edu.iba.sh.bean.Group;

import java.util.List;

public interface GroupDAO {
    Group getGroupByNumber(int number) throws DAOException;
    List<Group> getAllGroups() throws DAOException;
    void saveGroup(Group group) throws DAOException;
    void updateGroup(int groupNumber, Group group) throws DAOException;
    void removeGroup(String id) throws DAOException;
}