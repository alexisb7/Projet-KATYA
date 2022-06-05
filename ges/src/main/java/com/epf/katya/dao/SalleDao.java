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
import com.epf.katya.model.Salle;
import com.epf.katya.persistence.ConnectionManager;

@Repository
public class SalleDao {

    private static final String CREATE_SALLE_QUERY = "INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES(?, ?, ?, ?, ?, ?);";
    private static final String DELETE_SALLE_QUERY = "DELETE FROM Salle WHERE numero=?;";
    private static final String UPDATE_SALLE_QUERY = "UPDATE Salle SET etage=?, capacite=?, utilite=?, disponibilite_salle=?, date_acquisition_salle=? WHERE numero=?;";
    private static final String FIND_SALLE_QUERY = "SELECT * FROM Salle;";
    private static final String FIND_SALLE_BY_NUMERO_QUERY = "SELECT * FROM Salle WHERE numero=?;";
    private static final String COUNT_SALLE_QUERY = "SELECT COUNT(numero) FROM Salle;";

    public SalleDao() {}
    
    public int create(Salle salle){
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(CREATE_SALLE_QUERY);

            pstat.setString(1, salle.getNumero());
            pstat.setInt(2, salle.getEtage());
            pstat.setInt(3, salle.getCapacite());
            pstat.setString(4, salle.getUtilite());
            pstat.setInt(5, salle.getDisponibilite_salle());
            pstat.setDate(6, Date.valueOf(salle.getDate_acquisition_salle()));

            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Salle salle) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(UPDATE_SALLE_QUERY);

            pstat.setString(6, salle.getNumero());
            pstat.setInt(1, salle.getEtage());
            pstat.setInt(2, salle.getCapacite());
            pstat.setString(3, salle.getUtilite());
            pstat.setInt(4, salle.getDisponibilite_salle());
            pstat.setDate(5, Date.valueOf(salle.getDate_acquisition_salle()));

            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Salle salle) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(DELETE_SALLE_QUERY);
            pstat.setString(1, salle.getNumero());
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Salle> findAll() throws DaoException {
        List<Salle> liste_salle = new ArrayList<Salle>();
        Connection con;
        try {
            con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_SALLE_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            do{
                String numero = rs.getString("numero");
                int etage = rs.getInt("etage");
                int capacite = rs.getInt("capacite");
                String utilite = rs.getString("utilite");
                int disponibilite_salle = rs.getInt("disponibilite_salle");
                LocalDate date_acquisition_salle = rs.getDate("date_acquisition_salle").toLocalDate();
                Salle salle = new Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle);
                liste_salle.add(salle);
            }while(rs.next());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste_salle;
    }

    public Salle findByNumero(String numero) throws DaoException {
        try  {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_SALLE_BY_NUMERO_QUERY);
            pstat.setString(1, numero);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            
            int etage = rs.getInt("etage");
            int capacite = rs.getInt("capacite");
            String utilite = rs.getString("utilite");
            int disponibilite_salle = rs.getInt("disponibilite_salle");
            LocalDate date_acquisition_salle = rs.getDate("date_acquisition_salle").toLocalDate();
            Salle salle = new Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle);
            con.close();
            return salle;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  
    }

    public int count(){
		int nb_salle=0;
		try {	
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pstat = con.prepareStatement(COUNT_SALLE_QUERY);
			ResultSet rs = pstat.executeQuery();
			rs.next();
			nb_salle=rs.getInt(1);
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return nb_salle;
	}
}