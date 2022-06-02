package com.epf.katya.dao;

public class ReservationSalleDao {
    
    private static ReservationSalleDao instance = null;
    private ReservationSalleDao() {}

    public static ReservationSalleDao getInstance() {
        if(instance == null){
            instance = new ReservationSalleDao();
        }
        return instance;
    }

}
