package com.epf.katya.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.katya.configuration.AppConfiguration;
import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.UtilisateurService;

public class Main {
    public static void main(String[]args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        UtilisateurService utilisateurService = context.getBean(UtilisateurService.class);
        ReservationEquipementService reservationEquipementService = context.getBean(ReservationEquipementService.class);
    }
}
