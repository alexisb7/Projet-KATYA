package com.epf.katya.dao;

public class UtilisateurDao {

    private static UtilisateurDao instance = null;
    private UtilisateurDao() {}
    
    public static UtilisateurDao getInstance() {
        if(instance == null) {
            instance = new UtilisateurDao();
        }
        return instance;
    }
}