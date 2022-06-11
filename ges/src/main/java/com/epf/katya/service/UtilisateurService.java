package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.UtilisateurDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.model.Utilisateur;

@Service
public class UtilisateurService {
    
    private UtilisateurDao utilisateurDao;
    
    public UtilisateurService(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
   
    public int create(Utilisateur utilisateur) {
        return this.utilisateurDao.create(utilisateur); 
    }

    public int delete(int id_utilisateur) {
        try {
            return this.utilisateurDao.delete(id_utilisateur);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Utilisateur utilisateur) {
        try {
            return this.utilisateurDao.update(utilisateur);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Utilisateur> findAll() {
        try {
            return this.utilisateurDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Utilisateur findById(int id_utilisateur) {
        try {
            return this.utilisateurDao.findById(id_utilisateur);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int count(){
        return this.utilisateurDao.count();
    }
}
