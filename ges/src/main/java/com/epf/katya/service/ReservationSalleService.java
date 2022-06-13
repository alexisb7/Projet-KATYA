package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.ReservationSalleDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.model.ReservationSalle;

@Service
public class ReservationSalleService {
    
    private ReservationSalleDao reservationSalleDao;
    
    private ReservationSalleService(ReservationSalleDao reservationSalleDao) {
        this.reservationSalleDao = reservationSalleDao;
    }
   
    public int create(ReservationSalle reservationSalle) {
        try {
            return this.reservationSalleDao.create(reservationSalle);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(ReservationSalle reservationSalle) {
        try {
            return this.reservationSalleDao.delete(reservationSalle);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(ReservationSalle reservationSalle) {
        try {
            return this.reservationSalleDao.update(reservationSalle);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ReservationSalle> findAll() {
        try {
            return this.reservationSalleDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ReservationSalle findById(int id_reservation_salle) {
        try {
            return this.reservationSalleDao.findById(id_reservation_salle);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int count() {
        try {
            return this.reservationSalleDao.count();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
