package com.epf.katya.service;

//import com.epf.katya.dao.ReservationSalleDao;

public class ReservationSalleService {
    /*
    private ReservationSalleDao reservationSalleDao;
    
    private ReservationSalleService(ReservationSalleDao ReservationSalleDao) {
        this.reservationSalleDao = reservationSalleDao;
    }
    */

    public static ReservationSalleService instance;

    public static ReservationSalleService getInstance() {
        if (instance == null) {
            instance = new ReservationSalleService();
        }
        return instance;
    }
}
