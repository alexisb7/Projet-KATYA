package com.epf.katya.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.ReservationEquipement;
import com.epf.katya.service.EquipementService;
import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.UtilisateurService;

@WebServlet("/reservation_create_equipement")
public class ReservationEquipementCreateServlet extends HttpServlet {

    @Autowired
    ReservationEquipementService reservationEquipementService;

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    EquipementService equipementService;
    
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", this.utilisateurService.findAll());
        request.setAttribute("listEquipement", this.equipementService.findAll());
        request.setAttribute("date", LocalDate.now());

        String path="/WEB-INF/views/reservation/reservation_create_equipement.jsp";
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationEquipement reservationEquipement = new ReservationEquipement();
        try {
            reservationEquipement.setId_reservation_equipement(reservationEquipementService.count()+1);
            reservationEquipement.setId_equipement(Integer.parseInt(request.getParameter("id_equipement")));
            reservationEquipement.setId_utilisateur(request.getParameter("id_user"));
            reservationEquipement.setEtat_validation(Integer.parseInt(request.getParameter("etat")));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            reservationEquipement.setDate_debut(LocalDate.parse(request.getParameter("debut"), formatter));
            reservationEquipement.setDate_fin(LocalDate.parse(request.getParameter("fin"), formatter));
            reservationEquipement.setId_utilisateur_validation(request.getParameter("id_user_valid"));
            reservationEquipementService.create(reservationEquipement);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ges/reservation");
    }
}
