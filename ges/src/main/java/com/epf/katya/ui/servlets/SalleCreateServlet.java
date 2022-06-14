package com.epf.katya.ui.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.model.Salle;
import com.epf.katya.service.SalleService;

import java.io.IOException;
import java.time.LocalDate;

<<<<<<< HEAD
@WebServlet("/salle_create")
=======
@WebServlet("/salle/create")
>>>>>>> main
public class SalleCreateServlet extends HttpServlet {

    @Autowired
    SalleService salleService;
    
   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {


<<<<<<< HEAD
        RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/salle_create.jsp");
=======
        RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/salle/salle_create.jsp");
>>>>>>> main
        r.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        Salle salle = new Salle();
        salle.setNumero(request.getParameter("numero"));
        salle.setEtage(Integer.parseInt(request.getParameter("etage")));
        salle.setCapacite(Integer.parseInt(request.getParameter("capacite")));
        salle.setUtilite(request.getParameter("utilite"));
        salle.setDisponibilite_salle(1);
        salle.setDate_acquisition_salle(LocalDate.now()); 
        salleService.create(salle);

        response.sendRedirect("/ges/salle");
    }
}
