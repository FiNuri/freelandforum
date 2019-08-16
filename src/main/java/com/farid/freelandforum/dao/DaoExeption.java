package com.farid.freelandforum.dao;

public class DaoExeption extends Exception {

    public final static int _FAIL_TO_INSERT = 1;
    public final static int _UPDATE_FAILED = 2;
    public final static int _SQL_ERROR = 3;
    public final static int _FAIL_TO_CREATE = 4;
    public final static int _CANT_CLOSE_STATEMANT = 5;
    public final static int _CANT_CLOSE_RESAULTSET = 6;
    public final static int _CANT_CLOSE_CONNECTION = 7;
    private int errorCode;

    public DaoExeption(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
