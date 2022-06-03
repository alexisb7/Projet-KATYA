package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.ReservationEquipementDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.ReservationEquipement;

@Service
public class ReservationEquipementService {
    
    private ReservationEquipementDao reservationEquipementDao;
    
    public ReservationEquipementService(ReservationEquipementDao reservationEquipementDao) {
        this.reservationEquipementDao = reservationEquipementDao;
    } 
   

    /* public static ReservationEquipementService instance;

    public static ReservationEquipementService getInstance() {
        if (instance == null) {
            instance = new ReservationEquipementService();
        }
        return instance;
    } */

    public int create(ReservationEquipement reservationEquipement) throws SecurityException {
        try {
            this.reservationEquipementDao.create(reservationEquipement);
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public List<ReservationEquipement> findAll() throws ServiceException {
        try {
            return this.reservationEquipementDao.findAll();
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
