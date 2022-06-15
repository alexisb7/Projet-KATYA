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
import com.epf.katya.service.UtilisateurService;

@WebServlet("/reservation_update_salle")
public class ReservationSalleUpdateServlet extends HttpServlet{

    @Autowired
    ReservationSalleService reservationSalleService;

    @Autowired
    UtilisateurService utilisateurService;

    int id=0;

    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/WEB-INF/views/reservation/reservation_update_salle.jsp";
        id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("resa", this.reservationSalleService.findById(id));
        request.setAttribute("listUser", this.utilisateurService.findAll());
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationSalle reservationSalle = reservationSalleService.findById(id);
        reservationSalle.setEtat_validation(Integer.parseInt(request.getParameter("etat")));
        reservationSalle.setDate(LocalDate.parse(request.getParameter("date")));
        reservationSalle.setHeure_debut(LocalTime.parse(request.getParameter("heure_debut")));
        reservationSalle.setHeure_fin(LocalTime.parse(request.getParameter("heure_fin")));
        reservationSalle.setId_utilisateur_validation(request.getParameter("id_user_valid"));
        reservationSalleService.update(reservationSalle);
        response.sendRedirect("/ges/reservation");
    }
}
