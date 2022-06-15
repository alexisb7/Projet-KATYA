package com.epf.katya.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Equipement(id_equipement INT primary key, nom_equipement VARCHAR(25), zone_stockage VARCHAR(50), etat VARCHAR(50), disponibilite_equipement INT, date_acquisition DATETIME, description VARCHAR(50), lien_documentation VARCHAR(250))");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Utilisateur(id_utilisateur VARCHAR(20) primary key, email VARCHAR(30), mdp VARCHAR(25), nom_utilisateur VARCHAR(25), role VARCHAR(25), date_entree DATETIME)");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Salle(numero VARCHAR(10) primary key, etage INT, capacite INT, utilite VARCHAR(25), disponibilite_salle INT, date_acquisition_salle DATETIME)");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Reservation_equipement(id_reservation_equipement INT primary key, id_utilisateur VARCHAR(20), foreign key(id_utilisateur) REFERENCES Utilisateur(id_utilisateur), id_utilisateur_validation VARCHAR(20), foreign key(id_utilisateur_validation) REFERENCES Utilisateur(id_utilisateur), id_equipement INT, foreign key(id_equipement) REFERENCES Equipement(id_equipement), date DATETIME, heure_debut TIME, heure_fin TIME, etat_validation INT)");
        createTablesQueries.add("CREATE TABLE IF NOT EXISTS Reservation_salle(id_reservation_salle INT primary key, numero_salle VARCHAR(10), foreign key(numero_salle) REFERENCES Salle(numero), id_utilisateur VARCHAR(20), foreign key(id_utilisateur) REFERENCES Utilisateur(id_utilisateur), etat_validation INT, date DATETIME, heure_debut TIME, heure_fin TIME, id_utilisateur_validation VARCHAR(20), foreign key(id_utilisateur_validation) REFERENCES Utilisateur(id_utilisateur))");

        try {
            connection.setAutoCommit(false);

            for (String createQuery : createTablesQueries) {
            	createPreparedStatement = connection.prepareStatement(createQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();
            }

            // Remplissage de la base
            Statement stmt = connection.createStatement();

            //Utilisateur
            stmt.execute("INSERT INTO Utilisateur(id_utilisateur, email, mdp, nom_utilisateur, role, date_entree) VALUES('superadmin', 'superadmin@epfedu.fr', 'password', 'Admin', 'Administrateur', '2022-01-01')");
            stmt.execute("INSERT INTO Utilisateur(id_utilisateur, email, mdp, nom_utilisateur, role, date_entree) VALUES('SEC1', 'sec1@epfedu.fr', 'sec1EPF', 'Sec Sec', 'Secretaire', '2022-01-01')");
            stmt.execute("INSERT INTO Utilisateur(id_utilisateur, email, mdp, nom_utilisateur, role, date_entree) VALUES('alex', 'alex@epfedu.fr', 'alexEPF', 'Alexis Beriot', 'Eleve', '2022-01-01')");
            stmt.execute("INSERT INTO Utilisateur(id_utilisateur, email, mdp, nom_utilisateur, role, date_entree) VALUES('trist', 'trist@epfedu.fr', 'tristEPF', 'Tristan Bourhis', 'Eleve', '2022-01-01')");


            //Equipement
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(1, 'Mac', 'salle A205', 'Operationnel', 1, '2022-01-01', 'Couleur Argent', 'https://apple.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(2, 'Mac', 'salle A202', 'Correct', 1, '2022-01-01', 'Couleur Noire', 'https://apple.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(3, 'Mac', 'salle A203', 'Operationnel', 0, '2022-01-01', 'Couleur Rouge', 'https://apple.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(4, 'Souris', 'salle A204', 'Operationnel', 1, '2022-01-01', 'Couleur Argent', 'https://windows.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(5, 'Souris', 'salle B205', 'Correct', 0, '2022-01-01', 'Couleur Noire', 'https://windows.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(6, 'Clavier', 'salle A208', 'Abime', 1, '2022-01-01', 'Couleur Noiree', 'https://windows.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(7, 'Clavier', 'salle B201', 'Operationnel', 0, '2022-01-01', 'Couleur Argent', 'https://windows.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(8, 'Asus', 'salle B202', 'Abime', 1, '2022-01-01', 'Couleur Blanche', 'https://windows.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(9, 'Asus', 'salle A207', 'Correct', 1, '2022-01-01', 'Couleur Noire', 'https://windows.com')");
            stmt.execute("INSERT INTO Equipement(id_equipement, nom_equipement, zone_stockage, etat, disponibilite_equipement, date_acquisition, description, lien_documentation) VALUES(10, 'Intell', 'salle B20&', 'Operationnel', 1, '2022-01-01', 'Couleur Noire', 'https://windows.com')");

            //Salle
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('B201', 2, 20, 'Projet', 1, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('B202', 2, 20, 'Projet', 1, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('B203', 2, 20, 'Projet', 1, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('B204', 2, 20, 'Projet', 1, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('B205', 2, 20, 'Projet', 0, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('B206', 2, 20, 'Projet', 0, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('B207', 2, 20, 'Projet', 0, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A201', 2, 20, 'TP', 0, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A202', 2, 20, 'TP', 0, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A203', 2, 20, 'TP', 0, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A204', 2, 20, 'TP', 0, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A205', 2, 20, 'TP', 1, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A206', 2, 20, 'TP', 1, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A207', 2, 20, 'TP', 1, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A208', 2, 20, 'TP', 1, '2022-01-01')");
            stmt.execute("INSERT INTO Salle(numero, etage, capacite, utilite, disponibilite_salle, date_acquisition_salle) VALUES('A209', 2, 20, 'TP', 1, '2022-01-01')");

            //Reservation
            //Salles
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(1, 'B201', 'alex', 1, '2022-01-01', '14:30:00', '16:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(2, 'B202', 'alex', 1, '2022-01-01', '11:30:00', '12:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(3, 'B203', 'alex', 0, '2022-01-01', '13:30:00', '14:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(4, 'B204', 'alex', 0, '2022-01-01', '09:30:00', '11:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(5, 'B205', 'trist', 1, '2022-01-01', '15:30:00', '17:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(6, 'A201', 'trist', 1, '2022-01-01', '15:30:00', '17:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(7, 'A203', 'trist', 1, '2022-01-01', '15:30:00', '17:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(8, 'A204', 'trist', 0, '2022-01-01', '14:30:00', '17:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(9, 'A205', 'trist', 0, '2022-01-01', '11:30:00', '14:00:00', 'superadmin')");
            stmt.execute("INSERT INTO Reservation_Salle(id_reservation_salle, numero_salle, id_utilisateur, etat_validation, date, heure_debut, heure_fin, id_utilisateur_validation) VALUES(10, 'A206', 'trist', 0, '2022-01-01', '15:30:00', '17:00:00', 'superadmin')");

            //Equipements
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(1, 'alex', 'superadmin', 1, '2022-06-15', '14:30:00', '16:00:00', 0)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(2, 'alex', 'superadmin', 2, '2022-06-15', '11:30:00', '12:00:00', 1)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(3, 'alex', 'superadmin', 4, '2022-06-15', '10:30:00', '13:00:00', 0)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(4, 'alex', 'superadmin', 7, '2022-06-15', '14:30:00', '16:00:00', 1)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(5, 'alex', 'superadmin', 2, '2022-06-15', '14:30:00', '16:00:00', 0)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(6, 'trist', 'superadmin', 3, '2022-06-15', '11:30:00', '13:00:00', 0)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(7, 'trist', 'superadmin', 8, '2022-06-15', '16:30:00', '18:00:00', 1)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(8, 'trist', 'superadmin', 5, '2022-06-15', '14:30:00', '15:00:00', 0)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(9, 'trist', 'superadmin', 9, '2022-06-15', '14:30:00', '16:00:00', 1)");
            stmt.execute("INSERT INTO Reservation_equipement(id_reservation_equipement, id_utilisateur, id_utilisateur_validation, id_equipement, date, heure_debut, heure_fin, etat_validation) VALUES(10, 'trist', 'superadmin', 1, '2022-06-15', '14:30:00', '16:00:00', 0)");


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
