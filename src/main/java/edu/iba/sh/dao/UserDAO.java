package edu.iba.sh.dao;

import edu.iba.sh.bean.User;

import java.util.List;

public interface UserDAO {
    User getUserById(String id) throws DAOException;
    List<User> getAllUsers() throws DAOException;
    void saveUser(User user) throws DAOException;
    void udateUser(String name, User user) throws DAOException;
    void removeUser(String name) throws DAOException;
}