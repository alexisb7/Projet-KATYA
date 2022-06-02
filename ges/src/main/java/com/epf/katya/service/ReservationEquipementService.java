package com.epf.katya.service;

//import com.epf.katya.dao.ReservationEquipementDao;

public class ReservationEquipementService {
    /*
    private ReservationEquipementDao reservationEquipementDao;
    
    private ReservationEquipementService(ReservationEquipementDao ReservationEquipementDao) {
        this.reservationEquipementDao = reservationEquipementDao;
    }
    */

    public static ReservationEquipementService instance;

    public static ReservationEquipementService getInstance() {
        if (instance == null) {
            instance = new ReservationEquipementService();
        }
        return instance;
    }
}
