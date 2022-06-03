package com.epf.katya.main;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.katya.configuration.AppConfiguration;
import com.epf.katya.dao.DocumentDao;
import com.epf.katya.dao.EquipementDao;
import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Document;
import com.epf.katya.model.Equipement;
import com.epf.katya.service.DocumentService;
import com.epf.katya.service.EquipementService;
import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.UtilisateurService;

public class Main {
    public static void main(String[]args){
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        
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
        
    }
}
