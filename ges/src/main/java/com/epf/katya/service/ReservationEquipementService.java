package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.ReservationEquipementDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.model.ReservationEquipement;

@Service
public class ReservationEquipementService {
    
    private ReservationEquipementDao reservationEquipementDao;
    
    public ReservationEquipementService(ReservationEquipementDao reservationEquipementDao) {
        this.reservationEquipementDao = reservationEquipementDao;
    } 
   

    public int create(ReservationEquipement reservationEquipement) {
        try {
            this.reservationEquipementDao.create(reservationEquipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(ReservationEquipement reservationEquipement) {
        try {
            this.reservationEquipementDao.update(reservationEquipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(ReservationEquipement reservationEquipement) {
        try {
            this.reservationEquipementDao.delete(reservationEquipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ReservationEquipement> findAll() {
        try {
            return this.reservationEquipementDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ReservationEquipement findById(int id_reservation_equipement) {
        try {
            return this.reservationEquipementDao.findById(id_reservation_equipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int count() {
        try {
            return this.reservationEquipementDao.count();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int max() {
        try {
            return this.reservationEquipementDao.max();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ReservationEquipement findByUser(String id_utilisateur) {
        try {
            return this.reservationEquipementDao.findByUser(id_utilisateur);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ReservationEquipement findByEquipement(int id_equipement) {
        try {
            return this.reservationEquipementDao.findByEquipement(id_equipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
