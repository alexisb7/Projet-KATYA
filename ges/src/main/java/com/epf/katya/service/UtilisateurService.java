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

    public int controlConnection(String id_utilisateur, String mdp_utilisateur){
        try {
            return this.utilisateurDao.controlConnection(id_utilisateur, mdp_utilisateur);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }
   
    public int create(Utilisateur utilisateur) {
        try {
           return this.utilisateurDao.create(utilisateur);
        } catch (DaoException e) {
            e.printStackTrace();
        } 
        return 0;
    }

    public int delete(String id_utilisateur) {
        try {
            return this.utilisateurDao.delete(id_utilisateur);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Utilisateur utilisateur, String id) {
        try {
            return this.utilisateurDao.update(utilisateur, id);
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

    public Utilisateur findById(String id_utilisateur) {
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
