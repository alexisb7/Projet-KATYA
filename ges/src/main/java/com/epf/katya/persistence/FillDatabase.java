package com.epf.katya.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.tools.DeleteDbFiles;

//import com.epf.katya.persistence.ConnectionManager;

public class FillDatabase {


    public static void main(String[] args) throws Exception {
        try {
            DeleteDbFiles.execute("~", "KatyaDatabase", true);
            insertWithPreparedStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private static void insertWithPreparedStatement() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement createPreparedStatement = null;

        List<String> createTablesQueries = new ArrayList<>();
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Document(id_document INT primary key, lien VARCHAR(250))");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Equipement(id_equipement INT primary key, nom_equipement VARCHAR(25), zone_stockage VARCHAR(50), etat VARCHAR(50), disponibilite_equipement INT, date_acquisition DATETIME, description VARCHAR(50), id_document INT, foreign key(id_document) REFERENCES Document(id_document))");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Utilisateur(id_utilisateur VARCHAR(20) primary key, email VARCHAR(30), mdp VARCHAR(25), nom_utilisateur VARCHAR(25), role VARCHAR(25), date_entree DATETIME)");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Salle(numero VARCHAR(10) primary key, etage INT, capacite INT, utilite VARCHAR(25), disponibilite_salle INT, date_acquisition_salle DATETIME)");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Reservation_equipement(id_reservation_equipement INT primary key, id_utilisateur VARCHAR(20), foreign key(id_utilisateur) REFERENCES Utilisateur(id_utilisateur), id_utilisateur_validation VARCHAR(20), foreign key(id_utilisateur_validation) REFERENCES Utilisateur(id_utilisateur), id_equipement INT, foreign key(id_equipement) REFERENCES Equipement(id_equipement), date_debut DATETIME, date_fin DATETIME, etat_validation INT)");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Reservation_salle(id_reservation_salle INT primary key, numero_salle VARCHAR(10), foreign key(numero_salle) REFERENCES Salle(numero), id_utilisateur VARCHAR(20), foreign key(id_utilisateur) REFERENCES Utilisateur(id_utilisateur), etat_validation INT, date_debut DATETIME, date_fin DATETIME, id_utilisateur_validation VARCHAR(20), foreign key(id_utilisateur_validation) REFERENCES Utilisateur(id_utilisateur))");

        try {
            connection.setAutoCommit(false);

            for (String createQuery : createTablesQueries) {
            	createPreparedStatement = connection.prepareStatement(createQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();
            }

            // Remplissage de la base
            Statement stmt = connection.createStatement();
            //stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description ) VALUES(00, 'Mac01', 'salle A205', 'Opérationnel', 1, 2022-01-01 00:00:00, 'Couleur Argent')");


            connection.commit();
            System.out.println("Success!");
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
