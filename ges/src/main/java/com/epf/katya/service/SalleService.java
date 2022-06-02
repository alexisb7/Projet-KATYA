package com.epf.katya.service;

//import com.epf.katya.dao.SalleDao;

public class SalleService {
    /*
    private SalleDao salleDao;
    
    private SalleService(SalleDao salleDao) {
        this.salleDao = salleDao;
    }
    */

    public static SalleService instance;

    public static SalleService getInstance() {
        if (instance == null) {
            instance = new SalleService();
        }
        return instance;
    }
}

