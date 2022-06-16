package com.epf.katya.ui.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.model.Equipement;
import com.epf.katya.service.EquipementService;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/equipement_create")
public class EquipementCreateServlet extends HttpServlet {

    @Autowired
    EquipementService equipementService;

    String role="";

   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        role = request.getParameter("role");
        request.setAttribute("role", role);
        request.setAttribute("eleve", "Eleve");
        request.setAttribute("secretaire", "Secretaire");
        request.setAttribute("admin", "Responsable");
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/equipement/equipement_create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int idEqui = equipementService.max() + 1;        
        Equipement equipement = new Equipement(idEqui ,request.getParameter("nom_equipement"), request.getParameter("zone_stockage"), request.getParameter("etat"), 1, LocalDate.parse(request.getParameter("date_acquisition")), request.getParameter("description"),request.getParameter("lien_documentation"));
        equipementService.create(equipement);
        response.sendRedirect("/ges/equipement?role="+role);
    }
}
