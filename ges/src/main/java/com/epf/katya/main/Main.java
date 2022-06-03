package com.epf.katya.main;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.katya.configuration.AppConfiguration;
<<<<<<< HEAD
import com.epf.katya.dao.DocumentDao;
import com.epf.katya.dao.EquipementDao;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Document;
import com.epf.katya.model.Equipement;
import com.epf.katya.service.DocumentService;
import com.epf.katya.service.EquipementService;
import com.epf.katya.service.ReservationEquipementService;
=======
import com.epf.katya.dao.UtilisateurDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Utilisateur;
// import com.epf.katya.service.ReservationEquipementService;
>>>>>>> main
import com.epf.katya.service.UtilisateurService;

public class Main {
    public static void main(String[]args){
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
<<<<<<< HEAD
        
        /* DocumentDao documentDao = new DocumentDao();
        DocumentService documentService = new DocumentService(documentDao); 

        Document document = new Document(2, "lien2");
        try {
            documentService.create(document);
            System.out.println(documentService.findAll());
        } catch (ServiceException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }  */
        
        /* EquipementDao equipementDao = new EquipementDao();
        EquipementService equipementService = new EquipementService(equipementDao);

        Equipement equipement = new Equipement(2, "nom2", "zone_stockage2", "etat2", 1, LocalDate.now(), "description2", 1);
        try {
            equipementService.create(equipement);
            System.out.println(equipementService.findAll());
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */
        
=======
        //UtilisateurService utilisateurService = context.getBean(UtilisateurService.class);
        //ReservationEquipementService reservationEquipementService = context.getBean(ReservationEquipementService.class);

        UtilisateurDao utilisateurDao = new UtilisateurDao();
        UtilisateurService utilisateurService = new UtilisateurService(utilisateurDao);


        // Utilisateur utilisateur = new Utilisateur();
        // utilisateur.setId_utilisateur(1);
        // utilisateur.setEmail("nouveau@gmail.com");
        // utilisateur.setMdp("123456");
        // utilisateur.setRole("MIN");
        // utilisateur.setNom_utilisateur("toto");
        // utilisateur.setDate_entree(LocalDate.now());

        try {
            //utilisateurService.create(utilisateur);
            //utilisateurService.delete(1);
            //utilisateurService.update(utilisateur);
            System.out.println(utilisateurService.findAll()); 
            //System.out.println(utilisateurService.findById(1));   
            //System.out.println(utilisateurService.count());     
        } catch (ServiceException e) {
            e.printStackTrace();
        }catch (DaoException e) {
            e.printStackTrace();
        }

        System.out.println("Success");     
>>>>>>> main
    }
}
