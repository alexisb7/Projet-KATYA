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
import com.epf.katya.model.ReservationSalle;
import com.epf.katya.persistence.ConnectionManager;

@Repository
public class ReservationSalleDao {

    public ReservationSalleDao() {}

    private final static String CREATE_RESERVATION_SALLE_QUERY = "INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final static String DELETE_RESERVATION_SALLE_QUERY = "DELETE FROM Reservation_salle WHERE id_reservation_salle=?;";
    private final static String UPDATE_RESERVATION_SALLE_QUERY = "UPDATE Reservation_salle SET numero_salle=?, id_utilisateur=?, etat_validation=?, date=?, heure_debut=?, heure_fin=?, id_utilisateur_validation=? WHERE id_reservation_salle=?;";
    private final static String FIND_RESERVATION_SALLE_QUERY = "SELECT * FROM Reservation_salle;";
    private final static String FIND_RESERVATION_SALLE_BY_ID_QUERY = "SELECT * FROM Reservation_salle WHERE id_reservation_salle=?;";
    private final static String MAX_RESERVATION_SALLE_QUERY = "SELECT MAX(id_reservation_salle) FROM Reservation_salle;";
    private final static String COUNT_RESERVATION_SALLE_QUERY = "SELECT COUNT(id_reservation_salle) FROM Reservation_salle;";
    private static final String FIND_RESERVATION_SALLE_BY_USER_QUERY ="SELECT * FROM Reservation_salle WHERE id_utilisateur=? OR id_utilisateur_validation=?;";
    private static final String FIND_RESERVATION_SALLE_BY_SALLE_QUERY ="SELECT * FROM Reservation_salle WHERE numero_salle=?;";


    public int create(ReservationSalle reservationSalle) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(CREATE_RESERVATION_SALLE_QUERY);
            pstat.setInt(1, reservationSalle.getId_reservation_salle());
            pstat.setString(2, reservationSalle.getNumero_salle());
            pstat.setString(3, reservationSalle.getId_utilisateur());
            pstat.setInt(4, reservationSalle.getEtat_validation());
            pstat.setDate(5, Date.valueOf(reservationSalle.getDate()));
            pstat.setTime(6, Time.valueOf(reservationSalle.getHeure_debut()));
            pstat.setTime(7, Time.valueOf(reservationSalle.getHeure_fin()));
            pstat.setString(8, reservationSalle.getId_utilisateur_validation());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(ReservationSalle reservationSalle) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(UPDATE_RESERVATION_SALLE_QUERY);
            pstat.setInt(8, reservationSalle.getId_reservation_salle());
            pstat.setString(1, reservationSalle.getNumero_salle());
            pstat.setString(2, reservationSalle.getId_utilisateur());
            pstat.setInt(3, reservationSalle.getEtat_validation());
            pstat.setDate(4, Date.valueOf(reservationSalle.getDate()));
            pstat.setTime(5, Time.valueOf(reservationSalle.getHeure_debut()));
            pstat.setTime(6, Time.valueOf(reservationSalle.getHeure_fin()));
            pstat.setString(7, reservationSalle.getId_utilisateur_validation());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(ReservationSalle reservationSalle) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(DELETE_RESERVATION_SALLE_QUERY);
            pstat.setInt(1, reservationSalle.getId_reservation_salle());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ReservationSalle> findAll() throws DaoException {
        List<ReservationSalle> liste_reservation_salle = new ArrayList<ReservationSalle>();
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_RESERVATION_SALLE_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            do {
                int id_reservation_salle = rs.getInt("id_reservation_salle");
                String numero_salle = rs.getString("numero_salle");
                String id_utilisateur = rs.getString("id_utilisateur");
                int etat_validation = rs.getInt("etat_validation");
                LocalDate date = rs.getDate("date").toLocalDate();
                LocalTime heure_debut = rs.getTime("heure_debut").toLocalTime();
                LocalTime heure_fin = rs.getTime("heure_fin").toLocalTime();
                String id_utilisateur_validation = rs.getString("id_utilisateur_validation");
                ReservationSalle reservationSalle = new ReservationSalle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation);
                liste_reservation_salle.add(reservationSalle);
            }while(rs.next());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste_reservation_salle;
    }

    public ReservationSalle findById(int id_reservation_salle) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_RESERVATION_SALLE_BY_ID_QUERY);
            pstat.setInt(1, id_reservation_salle);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            String numero_salle = rs.getString("numero_salle");
            String id_utilisateur = rs.getString("id_utilisateur");
            int etat_validation = rs.getInt("etat_validation");
            LocalDate date = rs.getDate("date").toLocalDate();
            LocalTime heure_debut = rs.getTime("heure_debut").toLocalTime();
            LocalTime heure_fin = rs.getTime("heure_fin").toLocalTime();
            String id_utilisateur_validation = rs.getString("id_utilisateur_validation");
            ReservationSalle reservationSalle = new ReservationSalle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation);
            con.close();
            return reservationSalle;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int count() throws DaoException {
        int nb_reservation_salle = 0;
        try {
            Connection con = ConnectionManager.getConnection();         
            PreparedStatement pstat = con.prepareStatement(COUNT_RESERVATION_SALLE_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            nb_reservation_salle = rs.getInt(1);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nb_reservation_salle;
    }

    public int max() throws DaoException {
        int max = 0;
        try {
            Connection con = ConnectionManager.getConnection();         
            PreparedStatement pstat = con.prepareStatement(MAX_RESERVATION_SALLE_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            max = rs.getInt(1);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return max;
    }

    public ReservationSalle findByUser(String id_utilisateur) throws DaoException {
        ReservationSalle reservationSalle = null;
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_RESERVATION_SALLE_BY_USER_QUERY);
            pstat.setString(1, id_utilisateur);
            pstat.setString(2, id_utilisateur);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            int id_reservation_salle = rs.getInt("id_reservation_salle");
            reservationSalle = new ReservationSalle();
            reservationSalle.setId_reservation_salle(id_reservation_salle);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }           
        return reservationSalle;
    }

    public ReservationSalle findBySalle(String numero) throws DaoException {
        ReservationSalle reservationSalle = null;
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_RESERVATION_SALLE_BY_SALLE_QUERY);
            pstat.setString(1, numero);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            int id_reservation_salle = rs.getInt("id_reservation_salle");
            reservationSalle = new ReservationSalle();
            reservationSalle.setId_reservation_salle(id_reservation_salle);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }           
        return reservationSalle;
    }
}
