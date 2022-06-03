package com.epf.katya.service;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.ReservationEquipementDao;

@Service
public class ReservationEquipementService {
    
    /* private ReservationEquipementDao reservationEquipementDao;
    
    private ReservationEquipementService(ReservationEquipementDao reservationEquipementDao) {
        this.reservationEquipementDao = reservationEquipementDao;
    } */
   

    public static ReservationEquipementService instance;

    public static ReservationEquipementService getInstance() {
        if (instance == null) {
            instance = new ReservationEquipementService();
        }
        return instance;
    }
}
