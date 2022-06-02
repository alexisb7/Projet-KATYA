package com.epf.katya.dao;

public class ReservationEquipementDao {
    
    private static ReservationEquipementDao instance = null;
    private ReservationEquipementDao() {}

    public static ReservationEquipementDao getInstance() {
        if(instance == null){
            instance = new ReservationEquipementDao();
        }
        return instance;
    }
}
