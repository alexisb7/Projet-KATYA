package com.epf.katya.ui.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.model.ReservationEquipement;
import com.epf.katya.service.EquipementService;
import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.UtilisateurService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/reservation_equipement_update")
public class ReservationUpdateEquipementServlet extends HttpServlet {
    
    int id;
    String role="";

    @Autowired
    ReservationEquipementService reservationEquipementService;

    @Autowired
    EquipementService equipementService;

    @Autowired
    UtilisateurService utilisateurService;

   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("resa", reservationEquipementService.findById(id));
        request.setAttribute("listEquipement", equipementService.findAll());
        request.setAttribute("listUser", utilisateurService.findAll());
        String params = request.getParameter("id");
        id = Integer.parseInt(params.split("-")[0]);
        role = params.split("-")[1].split("=")[1];
        request.setAttribute("role", role);
        request.setAttribute("eleve", "Eleve");
        request.setAttribute("secretaire", "Secretaire");
        request.setAttribute("admin", "Responsable");
        String path="/WEB-INF/views/reservation/reservation_equipement_update.jsp";
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationEquipement reservationEquipement = reservationEquipementService.findById(id);
        reservationEquipement.setId_utilisateur(request.getParameter("id_user"));
        reservationEquipement.setId_utilisateur_validation(request.getParameter("id_user_valid"));
        reservationEquipement.setId_equipement(Integer.parseInt(request.getParameter("id_equipement")));
        reservationEquipement.setEtat_validation(Integer.parseInt(request.getParameter("etat")));
        reservationEquipement.setDate(LocalDate.parse(request.getParameter("date")));
        reservationEquipement.setHeure_debut(LocalTime.parse(request.getParameter("heure_debut")));
        reservationEquipement.setHeure_fin(LocalTime.parse(request.getParameter("heure_fin")));
        reservationEquipementService.update(reservationEquipement);
        response.sendRedirect("/ges/reservation?role="+role);
    }
}
