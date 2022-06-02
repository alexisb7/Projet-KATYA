package com.epf.katya.dao;

public class DocumentDao {
    private static DocumentDao instance = null;
    private DocumentDao() {}

    public static DocumentDao getInstance() {
        if(instance == null) {
            instance = new DocumentDao();
        }
        return instance;
    }
}