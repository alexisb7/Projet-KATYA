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
import com.epf.katya.model.ReservationEquipement;
import com.epf.katya.persistence.ConnectionManager;

@Repository
public class ReservationEquipementDao {
    
    //private static ReservationEquipementDao instance = null;
    
    public ReservationEquipementDao() {}

    /* public static ReservationEquipementDao getInstance() {
        if(instance == null){
            instance = new ReservationEquipementDao();
        }
        return instance;
    } */

    private final static String CREATE_RESERVATION_EQUIPEMENT_QUERY = "INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date_debut, date_fin, etat_validation) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final static String FIND_RESERVATIONS_EQUIPEMENT_QUERY = "SELECT * FROM Reservation_equipement;";

    public int create(ReservationEquipement reservationEquipement) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(CREATE_RESERVATION_EQUIPEMENT_QUERY);
            pstat.setInt(1, reservationEquipement.getId_reservation_equipement());
            pstat.setInt(2, reservationEquipement.getId_utilisateur());
            pstat.setInt(3, reservationEquipement.getId_utilisateur_validation());
            pstat.setInt(4, reservationEquipement.getId_equipement());
            pstat.setDate(5, Date.valueOf(reservationEquipement.getDate_debut()));
            pstat.setDate(6, Date.valueOf(reservationEquipement.getDate_fin()));
            pstat.setInt(7, reservationEquipement.getEtat_validation());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public List<ReservationEquipement> findAll() throws DaoException {
        List<ReservationEquipement> liste_reservation_equipement = new ArrayList<ReservationEquipement>();
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_RESERVATIONS_EQUIPEMENT_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            do {
                int id_reservation_equipement = rs.getInt("id_reservation_equipement");
                int id_utilisateur = rs.getInt("id_utilisateur");
                int id_utilisateur_validation = rs.getInt("id_utilisateur_validation");
                int id_equipement = rs.getInt("id_equipement");
                LocalDate date_debut = rs.getDate("date_debut").toLocalDate();
                LocalDate date_fin = rs.getDate("date_fin").toLocalDate();
                int etat_validation = rs.getInt("etat_validation");
                ReservationEquipement reservationEquipement = new ReservationEquipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date_debut, date_fin, etat_validation);
                liste_reservation_equipement.add(reservationEquipement);
            }
            while(rs.next());
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        return liste_reservation_equipement;
    }

}
