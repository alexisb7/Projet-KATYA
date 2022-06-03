package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.EquipementDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Equipement;

@Service
public class EquipementService {
    
    private EquipementDao equipementDao;
    
    public EquipementService(EquipementDao equipementDao) {
        this.equipementDao = equipementDao;
    } 
   

    /* public static EquipementService instance;

    public static EquipementService getInstance() {
        if (instance == null) {
            instance = new EquipementService();
        }
        return instance;
    } */

    public int create(Equipement equipement) throws ServiceException {
        try {
            this.equipementDao.create(equipement);
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public List<Equipement> findAll() throws ServiceException {
        try {
            return this.equipementDao.findAll();
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

