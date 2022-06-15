package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.EquipementDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.model.Equipement;

@Service
public class EquipementService {
    
    private EquipementDao equipementDao;
    
    public EquipementService(EquipementDao equipementDao) {
        this.equipementDao = equipementDao;
    } 

    public int create(Equipement equipement) {
        try {
            this.equipementDao.create(equipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Equipement equipement) {
        try {
            this.equipementDao.update(equipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Equipement equipement) {
        try {
            this.equipementDao.delete(equipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<Equipement> findAll()  {
        try {
            return this.equipementDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Equipement findById(int id_equipement) {
        try {
            return this.equipementDao.findById(id_equipement);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int max()  {
        try {
            return this.equipementDao.max();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0; 
    }

    public int count() {
        try {
            return this.equipementDao.count();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0; 
    }
}

