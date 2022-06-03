package com.epf.katya.main;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.katya.configuration.AppConfiguration;
import com.epf.katya.dao.UtilisateurDao;
import com.epf.katya.exception.DaoException;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Utilisateur;
// import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.UtilisateurService;

public class Main {
    public static void main(String[]args){
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        //UtilisateurService utilisateurService = context.getBean(UtilisateurService.class);
        //ReservationEquipementService reservationEquipementService = context.getBean(ReservationEquipementService.class);

        UtilisateurDao utilisateurDao = new UtilisateurDao();
        UtilisateurService utilisateurService = new UtilisateurService(utilisateurDao);


        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId_utilisateur(1);
        utilisateur.setEmail("toto@gmail.com");
        utilisateur.setMdp("123456");
        utilisateur.setRole("MIN");
        utilisateur.setNom_utilisateur("toto");
        utilisateur.setDate_entree(LocalDate.now());

        try {
            //utilisateurService.create(utilisateur);
            //utilisateurService.delete(1);
            System.out.println(utilisateurService.findAll()); 
            System.out.println(utilisateurService.findById(1));        
        } catch (ServiceException e) {
            e.printStackTrace();
        }catch (DaoException e) {
            e.printStackTrace();
        }

        System.out.println("Success");
        
    }
}
