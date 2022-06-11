package com.epf.katya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epf.katya.exception.DaoException;
import com.epf.katya.model.Document;
import com.epf.katya.persistence.ConnectionManager;

@Repository
public class DocumentDao {
    
    //private static DocumentDao instance = null;
    
    public DocumentDao() {}

    /* public static DocumentDao getInstance() {
        if(instance == null) {
            instance = new DocumentDao();
        }
        return instance;
    }
 */
    private static final String CREATE_DOCUMENT_QUERY = "INSERT INTO Document(id_document, lien) VALUES (?, ?);";
    private static final String FIND_DOCUMENTS_QUERY = "SELECT * FROM Document;";
    private static final String DELETE_DOCUMENTS_QUERY = "DELETE FROM Document WHERE id_document=?;";
    private static final String FIND_DOCUMENT_BY_ID_QUERY = "SELECT * FROM Document WHERE id_document=?;";
    private static final String COUNT_DOCUMENTS_QUERY = "SELECT COUNT(id_document) FROM Document;";
    private static final String UPDATE_DOCUMENT_QUERY = "UPDATE Document SET lien=? WHERE id_document=?;";

    public int create(Document document) throws DaoException{
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(CREATE_DOCUMENT_QUERY);
            pstat.setInt(1, document.getId_document());
            pstat.setString(2, document.getLien());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Document document) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(UPDATE_DOCUMENT_QUERY);
            pstat.setString(1, document.getLien());
            pstat.setInt(2, document.getId_document());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return 0;
    }

    public int delete(Document document) throws DaoException{
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(DELETE_DOCUMENTS_QUERY);
            pstat.setInt(1, document.getId_document());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public List<Document> findAll() throws DaoException {
        List<Document> liste_document = new ArrayList<Document>();
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_DOCUMENTS_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            do {
                int id_document = rs.getInt("id_document");
                String lien = rs.getString("lien");
                Document document = new Document(id_document, lien);
                liste_document.add(document);
            }
            while(rs.next());
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return liste_document;
    }

    public Document findById(int id_document) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_DOCUMENT_BY_ID_QUERY);
            pstat.setInt(1, id_document);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            String lien = rs.getString("lien");
            Document document = new Document(id_document, lien);
            con.close();
            return document;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }

    public int count() throws DaoException {
        int nb_document = 0;
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(COUNT_DOCUMENTS_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            nb_document = rs.getInt(1);
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return nb_document;
    }
}