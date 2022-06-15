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


    public int create(Document document) throws ServiceException {
      try {
        this.documentDao.create(document);
      } catch (DaoException e) {
        e.printStackTrace();
      }
      return 0;
    }

    public int delete(Document document) throws ServiceException{
      try {
        this.documentDao.delete(document);
      } catch (DaoException e) {
        e.printStackTrace();
      }
      return 0;
    }

    public List<Document> findAll() throws ServiceException {
      try {
        return this.documentDao.findAll();
      } catch (DaoException e) {
        e.printStackTrace();
      }
      return null;
    }

    public int update(Document document) throws ServiceException{
      try {
        this.documentDao.update(document);
      } catch (DaoException e) {
        e.printStackTrace();
      }
      return 0;
    }

    public Document findById(int id_document) throws ServiceException{
      try {
        return this.documentDao.findById(id_document);
      } catch (DaoException e) {
        e.printStackTrace();
      }
      return null;
    }

    public int count() throws ServiceException {
      try {
        return this.documentDao.count();
      } catch (DaoException e) {
        e.printStackTrace();
      }
      return 0;
    }
}
