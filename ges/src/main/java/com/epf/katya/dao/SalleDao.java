package com.epf.katya.dao;

public class SalleDao {

    private static SalleDao instance = null;
    private SalleDao() {}

    public static SalleDao getInstance() {
        if(instance == null){
            instance = new SalleDao();
        }
        return instance;
    }
}