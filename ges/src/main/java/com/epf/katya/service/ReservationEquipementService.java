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
   

    public int create(ReservationEquipement reservationEquipement) throws ServiceException {
        try {
            this.reservationEquipementDao.create(reservationEquipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(ReservationEquipement reservationEquipement) throws ServiceException {
        try {
            this.reservationEquipementDao.update(reservationEquipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(ReservationEquipement reservationEquipement) throws ServiceException {
        try {
            this.reservationEquipementDao.delete(reservationEquipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ReservationEquipement> findAll() throws ServiceException {
        try {
            return this.reservationEquipementDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ReservationEquipement findById(int id_reservation_equipement) throws ServiceException {
        try {
            return this.reservationEquipementDao.findById(id_reservation_equipement);
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public int count() throws ServiceException {
        try {
            return this.reservationEquipementDao.count();
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
}
