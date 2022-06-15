package com.epf.katya.main;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.katya.configuration.AppConfiguration;

import com.epf.katya.dao.DocumentDao;
import com.epf.katya.dao.EquipementDao;
import com.epf.katya.dao.ReservationEquipementDao;
import com.epf.katya.dao.SalleDao;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Document;
import com.epf.katya.model.Equipement;
import com.epf.katya.model.ReservationEquipement;
import com.epf.katya.model.Salle;
import com.epf.katya.service.DocumentService;
import com.epf.katya.service.EquipementService;
import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.SalleService;
import com.epf.katya.dao.UtilisateurDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Utilisateur;
// import com.epf.katya.service.ReservationEquipementService;

import com.epf.katya.service.UtilisateurService;

public class Main {
    public static void main(String[]args){
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        
<<<<<<< HEAD
        DocumentDao documentDao = new DocumentDao();
        DocumentService documentService = new DocumentService(documentDao); 

        Document document = new Document(1, "lien8");

=======
        /* DocumentDao documentDao = new DocumentDao();
        DocumentService documentService = new DocumentService(documentDao); 

        Document document = new Document(1, "lien8"); */
        /*DocumentDao documentDao = new DocumentDao();
        DocumentService documentService = new DocumentService(documentDao); 

        Document document = new Document(2, "lien2");
>>>>>>> 4299ba9f3d94728da48b8eed5ad08da2085291ca
        try {
            documentService.create(document);
            System.out.println(documentService.findAll());
        } catch (ServiceException e1) {
            e1.printStackTrace();
        }  
     
        EquipementDao equipementDao = new EquipementDao();
        EquipementService equipementService = new EquipementService(equipementDao);
        
        Equipement equipement = new Equipement(2, "nom2", "PROUUT", "etat2", 1, LocalDate.now(), "description2", 1);
        try {
            equipementService.create(equipement);
        } catch (ServiceException e) {

            e.printStackTrace();
        }
        System.out.println(equipementService.findAll());
        
        /*try {
            equipementService.delete(equipement);
            System.out.println(equipementService.findAll());
<<<<<<< HEAD
=======


        Equipement equipement = new Equipement(1, "laptop asus", "PROUUT", "etat1", 0, LocalDate.now(), "description1", 2);
        try {
            equipementService.create(equipement);
            System.out.println("Equipements : " + equipementService.findAll());
>>>>>>> 4299ba9f3d94728da48b8eed5ad08da2085291ca
        } catch (ServiceException e) {
            e.printStackTrace();
        }  
        
        //UtilisateurService utilisateurService = context.getBean(UtilisateurService.class);
        //ReservationEquipementService reservationEquipementService = context.getBean(ReservationEquipementService.class);
        
        
        
        /*UtilisateurDao utilisateurDao = new UtilisateurDao();
        UtilisateurService utilisateurService = new UtilisateurService(utilisateurDao);

        
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId_utilisateur("alexis");
        utilisateur.setEmail("alexxis@gmail.com");
        utilisateur.setMdp("password");
        utilisateur.setRole("Eleve");
        utilisateur.setNom_utilisateur("Alexis Beriot");
        utilisateur.setDate_entree(LocalDate.now());
        
        
        utilisateurService.create(utilisateur);
        //utilisateurService.delete(1);
        //utilisateurService.update(utilisateur);
        System.out.println(utilisateurService.findAll()); 
        //System.out.println(utilisateurService.findById(1));   
        //System.out.println(utilisateurService.count());  */   
<<<<<<< HEAD
        
    
=======
>>>>>>> 4299ba9f3d94728da48b8eed5ad08da2085291ca

        /* SalleDao salleDao = new SalleDao();
        SalleService salleService = new SalleService(salleDao);

        Salle salle = new Salle();
        salle.setNumero("P208");
        salle.setEtage(2);
        salle.setCapacite(25);
        salle.setUtilite("salle de reunion");
        salle.setDisponibilite_salle(1);
        salle.setDate_acquisition_salle(LocalDate.now());


        //salleService.create(salle);
        //salleService.delete(salle);
        salleService.update(salle, "A106");
        
        System.out.println(salleService.findAll());
        //System.out.println(salleService.research("A"));
        //System.out.println(salleService.findByNumero("A106"));
<<<<<<< HEAD
        System.out.println("Success");     
        */
<<<<<<< HEAD
        /*System.out.println("Success"); */
        
=======
>>>>>>> 4299ba9f3d94728da48b8eed5ad08da2085291ca
        
        
        ReservationEquipementDao reservationEquipementDao = new ReservationEquipementDao();
        ReservationEquipementService reservationEquipementService = new ReservationEquipementService(reservationEquipementDao);

        ReservationEquipement reservationEquipement = new ReservationEquipement(1, "tristan", "alexis", 1, LocalDate.now(), LocalDate.now(), 0);
        
        try {
            reservationEquipementService.create(reservationEquipement);
            System.out.println(reservationEquipementService.findAll());
        } catch (ServiceException e) {
            e.printStackTrace();
        } 

        /*UtilisateurDao utilisateurDao = new UtilisateurDao();
        UtilisateurService utilisateurService = new UtilisateurService(utilisateurDao);

        Utilisateur utilisateur = new Utilisateur("trist", "polo@epf.fr", "password","beriot","Admin",LocalDate.now());
        //utilisateurService.create(utilisateur);
        //System.out.println(utilisateurService.controlConnection("uvk", "password"));
        //System.out.println(utilisateurService.findAll());
        //System.out.println(utilisateurService.findById("trist"));*/
    }
    
}
