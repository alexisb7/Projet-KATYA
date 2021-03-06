package com.epf.katya.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.model.ReservationSalle;
import com.epf.katya.service.ReservationSalleService;
import com.epf.katya.service.SalleService;
import com.epf.katya.service.UtilisateurService;

@WebServlet("/reservation_create_salle")
public class ReservationSalleCreateServlet extends HttpServlet {

    @Autowired
    ReservationSalleService reservationSalleService;

    @Autowired
    SalleService salleService;

    @Autowired 
    UtilisateurService utilisateurService;

    String role="";

    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/WEB-INF/views/reservation/reservation_create_salle.jsp";
        request.setAttribute("listSalle", this.salleService.findAll());
        request.setAttribute("listUser", this.utilisateurService.findAll());
        request.setAttribute("date", LocalDate.now());
        role = request.getParameter("role");
        request.setAttribute("role", role);
        request.setAttribute("eleve", "Eleve");
        request.setAttribute("secretaire", "Secretaire");
        request.setAttribute("admin", "Responsable");
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationSalle reservationSalle = new ReservationSalle();
        reservationSalle.setId_reservation_salle(reservationSalleService.count()+1);
        reservationSalle.setNumero_salle(request.getParameter("numero_salle"));
        reservationSalle.setId_utilisateur(request.getParameter("id_user"));
        reservationSalle.setEtat_validation(Integer.parseInt(request.getParameter("etat")));
        reservationSalle.setDate(LocalDate.parse(request.getParameter("date")));
        reservationSalle.setHeure_debut(LocalTime.parse(request.getParameter("heure_debut")));
        reservationSalle.setHeure_fin(LocalTime.parse(request.getParameter("heure_fin")));
        reservationSalle.setId_utilisateur_validation(request.getParameter("id_user_valid"));
        reservationSalleService.create(reservationSalle);
        response.sendRedirect("/ges/reservation?role="+role);
    }
}
