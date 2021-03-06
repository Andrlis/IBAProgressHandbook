package edu.iba.sh.dao;

import edu.iba.sh.bean.User;

import java.util.List;

public interface UserDAO {
    User getUserById(String id) throws DAOException;
    User getUserByIDandPassword(String userId, String password) throws DAOException;
    List<User> getAllUsers() throws DAOException;
    void saveUser(User user) throws DAOException;
    void updateUser(String name, User user) throws DAOException;
    void removeUser(String name) throws DAOException;
}