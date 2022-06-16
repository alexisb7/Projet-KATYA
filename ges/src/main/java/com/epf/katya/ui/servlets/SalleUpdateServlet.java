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

@WebServlet("/salle_update")
public class SalleUpdateServlet extends HttpServlet {

    @Autowired
    SalleService salleService;

    String numero;
    String role;
    
   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String params = request.getParameter("numero");
        numero = params.split("-")[0];
        role = params.split("-")[1].split("=")[1];
        request.setAttribute("role", role);
        request.setAttribute("eleve", "Eleve");
        request.setAttribute("secretaire", "Secretaire");
        request.setAttribute("admin", "Administrateur");
        request.setAttribute("salle", salleService.findByNumero(numero));
        RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/salle/salle_update.jsp");
        r.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        Salle salle = salleService.findByNumero(numero);
        salle.setNumero(request.getParameter("id"));
        salle.setEtage(Integer.parseInt(request.getParameter("etage")));
        salle.setCapacite(Integer.parseInt(request.getParameter("capacite")));
        salle.setUtilite(request.getParameter("utilite"));
        salleService.update(salle, numero);

        response.sendRedirect("/ges/salle?role="+role);
    }
}
