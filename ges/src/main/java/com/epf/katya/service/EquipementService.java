package com.epf.katya.service;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.EquipementDao;

@Service
public class EquipementService {
    
    private EquipementDao equipementDao;
    
    private EquipementService(EquipementDao equipementDao) {
        this.equipementDao = equipementDao;
    }
   

    /* public static EquipementService instance;

    public static EquipementService getInstance() {
        if (instance == null) {
            instance = new EquipementService();
        }
        return instance;
    } */
}

