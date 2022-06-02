package com.epf.katya.service;

//import com.epf.katya.dao.DocumentDao;

public class DocumentService {
    /*
    private DocumentDao documentDao;
    
    private DocumentService(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }
    */
    public static DocumentService instance;

    public static DocumentService getInstance() {
		if (instance == null) {
			instance = new DocumentService();
		}
		return instance;
    }
}
