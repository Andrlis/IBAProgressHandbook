package edu.iba.sh.dao;

public class DAOException extends Exception {

    private static final long serialVersionUID = -2818899801515373436L;

    public DAOException() {}

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}