package com.epf.katya.dao;

public class EquipementDao {

    private static EquipementDao instance = null;
    private EquipementDao() {}

    public static EquipementDao getInstance() {
        if(instance == null){
            instance = new EquipementDao();
        }
        return instance;
    }
}