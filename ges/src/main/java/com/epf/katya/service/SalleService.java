package com.epf.katya.service;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.SalleDao;

@Service
public class SalleService {
    
    private SalleDao salleDao;
    
    private SalleService(SalleDao salleDao) {
        this.salleDao = salleDao;
    }
   

    /* public static SalleService instance;

    public static SalleService getInstance() {
        if (instance == null) {
            instance = new SalleService();
        }
        return instance;
    } */
}

