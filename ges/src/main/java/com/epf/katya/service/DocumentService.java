package com.epf.katya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.katya.dao.DocumentDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Document;

@Service
public class DocumentService {
    
    private DocumentDao documentDao;
    
    
    public DocumentService(DocumentDao documentDao) {
        this.documentDao = documentDao;
    } 
   
    public static DocumentService instance;

    /* public static DocumentService getInstance() {
		if (instance == null) {
			instance = new DocumentService();
		}
		return instance;
    } */

    public int create(Document document) throws ServiceException {
      try {
        this.documentDao.create(document);
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return 0;
    }

    public List<Document> findAll() throws ServiceException {
      try {
        return this.documentDao.findAll();
      } catch (DaoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return null;
    }
}
