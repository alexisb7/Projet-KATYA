package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.SalleDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.model.Salle;

@Service
public class SalleService {
    
    private SalleDao salleDao;
    
    public SalleService(SalleDao salleDao) {
        this.salleDao = salleDao;
    }
   
    public int create(Salle salle) {
        return this.salleDao.create(salle);
    }

    public int delete(Salle salle) {
        try {
            return this.salleDao.delete(salle);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Salle salle) {
        try {
            return this.salleDao.update(salle);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Salle> findAll() {
        try {
            return this.salleDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Salle findByNumero(String numero) {
        try {
            return this.salleDao.findByNumero(numero);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int count() {
        return this.salleDao.count();
    }
}

