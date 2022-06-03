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
import com.epf.katya.model.Utilisateur;
import com.epf.katya.persistence.ConnectionManager;

@Repository
public class UtilisateurDao {

    public UtilisateurDao(){};

    private static final String CREATE_UTILISATEUR_QUERY = "INSERT INTO Utilisateur(id_utilisateur, email, mdp, nom_utilisateur, role, date_entree) VALUES(?, ?, ?, ?, ?, ?);";
    private static final String DELETE_UTILISATEUR_QUERY = "DELETE FROM Utilisateur WHERE id_utilisateur=?;";
    private static final String UPDATE_UTILISATEUR_QUERY = "UPDATE utilisateur SET email=?, mdp=?, nom_utilisateur=?, role=?, date_entree=? WHERE id_utilisateur=?;";
    private static final String FIND_UTILISATEUR_QUERY = "SELECT * FROM Utilisateur;";
    private static final String FIND_UTILISATEUR_BY_ID_QUERY = "SELECT * FROM Utilisateur WHERE id_utilisateur=?;";

    public int create(Utilisateur utilisateur){
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(CREATE_UTILISATEUR_QUERY);

            pstat.setInt(1, utilisateur.getId_utilisateur());
            pstat.setString(2, utilisateur.getEmail());
            pstat.setString(3, utilisateur.getMdp());
            pstat.setString(4, utilisateur.getNom_utilisateur());
            pstat.setString(5, utilisateur.getRole());
            pstat.setDate(6, Date.valueOf(utilisateur.getDate_entree()));

            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(int id_utilisateur) throws DaoException {
        try {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(DELETE_UTILISATEUR_QUERY);
            pstat.setInt(1, id_utilisateur);
            pstat.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Utilisateur> findAll() throws DaoException {
        List<Utilisateur> liste_utilisateur = new ArrayList<Utilisateur>();
        try  {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_UTILISATEUR_QUERY);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            do {
                int id_utilisateur = rs.getInt("id_utilisateur");
                String email = rs.getString("email");
                String mdp = rs.getString("mdp");
                String nom_utilisateur = rs.getString("nom_utilisateur");
                String role = rs.getString("role");
                LocalDate date_entree = rs.getDate("date_entree").toLocalDate();
                Utilisateur utilisateur = new Utilisateur(id_utilisateur, email, mdp, nom_utilisateur, role, date_entree);
                liste_utilisateur.add(utilisateur);
            }while(rs.next());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste_utilisateur;  
    }

    public Utilisateur findById(int id_utilisateur) throws DaoException {
        try  {
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstat = con.prepareStatement(FIND_UTILISATEUR_BY_ID_QUERY);
            pstat.setInt(1, id_utilisateur);
            ResultSet rs = pstat.executeQuery();
            rs.next();
            
            String email = rs.getString("email");
            String mdp = rs.getString("mdp");
            String nom_utilisateur = rs.getString("nom_utilisateur");
            String role = rs.getString("role");
            LocalDate date_entree = rs.getDate("date_entree").toLocalDate();
            Utilisateur utilisateur = new Utilisateur(id_utilisateur, email, mdp, nom_utilisateur, role, date_entree);
            
            con.close();
            return utilisateur;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  
    }

}