package com.epf.katya.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epf.katya.exception.DaoException;
import com.epf.katya.model.Equipement;
import com.epf.katya.persistence.ConnectionManager;

@Repository
public class EquipementDao {

    //private static EquipementDao instance = null;
    
    public EquipementDao() {}

    /* public static EquipementDao getInstance() {
        if(instance == null){
            instance = new EquipementDao();
        }
        return instance;
    } */

    private static final String CREATE_EQUIPEMENT_QUERY = "INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, id_document) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String FIND_EQUIPEMENTS_QUERY = "SELECT * FROM Equipement;";

    public int create(Equipement equipement) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(CREATE_EQUIPEMENT_QUERY);
            pstat.setInt(1, equipement.getId_equipement());
            pstat.setString(2, equipement.getNom_equipement());
            pstat.setString(3, equipement.getZone_stockage());
            pstat.setString(4, equipement.getEtat());
            pstat.setInt(5, equipement.getDisponibilite_equipement());
            pstat.setDate(6, Date.valueOf(equipement.getDate_acquisition()));
            pstat.setString(7, equipement.getDescription());
            pstat.setInt(8, equipement.getId_document());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public List<Equipement> findAll() throws DaoException {
        List<Equipement> liste_equipement = new ArrayList<Equipement>();
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_EQUIPEMENTS_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            do {
                int id_equipement = rs.getInt("id_equipement");
                String nom_equipement = rs.getString("nom_equipement");
                String zone_stockage = rs.getString("zone_stockage");
                String etat = rs.getString("etat");
                int disponibilite_equipement = rs.getInt("disponibilite_equipement");
                LocalDate date_acquisition = rs.getDate("date_acquisition").toLocalDate();
                String description = rs.getString("description");
                int id_document = rs.getInt("id_document");
                Equipement equipement = new Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, id_document);
                liste_equipement.add(equipement);
            }
            while(rs.next());
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return liste_equipement;
    }
}