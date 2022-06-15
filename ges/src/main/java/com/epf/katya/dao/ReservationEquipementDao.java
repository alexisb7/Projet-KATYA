package com.epf.katya.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epf.katya.exception.DaoException;
import com.epf.katya.model.ReservationEquipement;
import com.epf.katya.persistence.ConnectionManager;

@Repository
public class ReservationEquipementDao {
    
    public ReservationEquipementDao() {}


    private final static String CREATE_RESERVATION_EQUIPEMENT_QUERY = "INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String FIND_RESERVATIONS_EQUIPEMENT_QUERY = "SELECT * FROM Reservation_equipement;";
    private static final String DELETE_RESERVATION_EQUIPEMENT_QUERY = "DELETE FROM Reservation_equipement WHERE id_reservation_equipement=?;";
    private static final String FIND_RESERVATION_EQUIPEMENT_BY_ID_QUERY = "SELECT * FROM Reservation_equipement WHERE id_reservation_equipement=?;";
    private static final String COUNT_RESERVATION_EQUIPEMENTS_QUERY = "SELECT COUNT(id_reservation_equipement) FROM Reservation_equipement;";
    private static final String UPDATE_RESERVATION_EQUIPEMENT_QUERY = "UPDATE Reservation_equipement SET id_utilisateur=?, id_utilisateur_validation=?, id_equipement=?, date=?, heure_debut=?, heure_fin=?, etat_validation=? WHERE id_reservation_equipement=?;";

    public int create(ReservationEquipement reservationEquipement) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(CREATE_RESERVATION_EQUIPEMENT_QUERY);
            pstat.setInt(1, reservationEquipement.getId_reservation_equipement());
            pstat.setString(2, reservationEquipement.getId_utilisateur());
            pstat.setString(3, reservationEquipement.getId_utilisateur_validation());
            pstat.setInt(4, reservationEquipement.getId_equipement());
            pstat.setDate(5, Date.valueOf(reservationEquipement.getDate()));
            pstat.setTime(6, Time.valueOf(reservationEquipement.getHeure_debut()));
            pstat.setTime(7, Time.valueOf(reservationEquipement.getHeure_fin()));
            pstat.setInt(8, reservationEquipement.getEtat_validation());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(ReservationEquipement reservationEquipement) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(UPDATE_RESERVATION_EQUIPEMENT_QUERY);
            pstat.setString(1, reservationEquipement.getId_utilisateur());
            pstat.setString(2, reservationEquipement.getId_utilisateur_validation());
            pstat.setInt(3, reservationEquipement.getId_equipement());
            pstat.setDate(4, Date.valueOf(reservationEquipement.getDate()));
            pstat.setTime(5, Time.valueOf(reservationEquipement.getHeure_debut()));
            pstat.setTime(6, Time.valueOf(reservationEquipement.getHeure_fin()));
            pstat.setInt(7, reservationEquipement.getEtat_validation());
            pstat.setInt(8, reservationEquipement.getId_reservation_equipement());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(ReservationEquipement reservationEquipement) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(DELETE_RESERVATION_EQUIPEMENT_QUERY);
            pstat.setInt(1, reservationEquipement.getId_reservation_equipement());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
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
                String id_utilisateur = rs.getString("id_utilisateur");
                String id_utilisateur_validation = rs.getString("id_utilisateur_validation");
                int id_equipement = rs.getInt("id_equipement");
                LocalDate date = rs.getDate("date").toLocalDate();
                LocalTime heure_debut = rs.getTime("heure_debut").toLocalTime();
                LocalTime heure_fin = rs.getTime("heure_fin").toLocalTime();
                int etat_validation = rs.getInt("etat_validation");
                ReservationEquipement reservationEquipement = new ReservationEquipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation);
                liste_reservation_equipement.add(reservationEquipement);
            }
            while(rs.next());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste_reservation_equipement;
    }

    public ReservationEquipement findById(int id_reservation_equipement) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_RESERVATION_EQUIPEMENT_BY_ID_QUERY);
            pstat.setInt(1, id_reservation_equipement);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            String id_utilisateur = rs.getString("id_utilisateur");
            String id_utilisateur_validation = rs.getString("id_utilisateur_validation");
            int id_equipement = rs.getInt("id_equipement");
            LocalDate date = rs.getDate("date").toLocalDate();
            LocalTime heure_debut = rs.getTime("heure_debut").toLocalTime();
            LocalTime heure_fin = rs.getTime("heure_fin").toLocalTime();
            int etat_validation = rs.getInt("etat_validation");
            ReservationEquipement reservationEquipement = new ReservationEquipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation);
            con.close();
            return reservationEquipement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int count() throws DaoException {
        int nb_reservation_equipement = 0;
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(COUNT_RESERVATION_EQUIPEMENTS_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            nb_reservation_equipement = rs.getInt(1);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nb_reservation_equipement;
    }
}
