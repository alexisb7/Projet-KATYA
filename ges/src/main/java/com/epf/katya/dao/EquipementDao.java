package com.epf.katya.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EquipementDao {

    private static EquipementDao instance = null;
    
    //private EquipementDao() {}

    public static EquipementDao getInstance() {
        if(instance == null){
            instance = new EquipementDao();
        }
        return instance;
    }
}