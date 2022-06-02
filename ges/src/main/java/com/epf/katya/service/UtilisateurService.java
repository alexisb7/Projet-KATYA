package com.epf.katya.service;

//import com.epf.katya.dao.UtilisateurDao;

public class UtilisateurService {
    /*
    private UtilisateurDao utilisateurDao;
    
    private UtilisateurService(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
    */

    public static UtilisateurService instance;

    public static UtilisateurService getInstance() {
        if (instance == null) {
            instance = new UtilisateurService();
        }
        return instance;
    }
}
