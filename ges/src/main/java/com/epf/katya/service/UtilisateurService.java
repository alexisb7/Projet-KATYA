package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.UtilisateurDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Utilisateur;

@Service
public class UtilisateurService {
    
    private UtilisateurDao utilisateurDao;
    
    public UtilisateurService(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
   
    public int create(Utilisateur utilisateur) throws ServiceException {
        return this.utilisateurDao.create(utilisateur); 
    }

    public int delete(int id_utilisateur) throws DaoException {
        return this.utilisateurDao.delete(id_utilisateur);
    }

    public int update(Utilisateur utilisateur) throws DaoException {
        return this.utilisateurDao.update(utilisateur);
    }

    public List<Utilisateur> findAll() throws ServiceException, DaoException {
        return this.utilisateurDao.findAll();
    }

    public Utilisateur findById(int id_utilisateur) throws DaoException {
        return this.utilisateurDao.findById(id_utilisateur);
    }

    public int count(){
        return this.utilisateurDao.count();
    }
}
