package com.epf.katya.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.model.Equipement;
import com.epf.katya.service.EquipementService;

@WebServlet("/equipement_update")
public class EquipementUpdateServlet extends HttpServlet{

    @Autowired
    EquipementService equipementService;

    int id=0;
    String role="";
    
   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/WEB-INF/views/equipement/equipement_update.jsp";
        String params = request.getParameter("id");
        id = Integer.parseInt(params.split("-")[0]);
        role = params.split("-")[1].split("=")[1];
        request.setAttribute("role", role);
        request.setAttribute("eleve", "Eleve");
        request.setAttribute("secretaire", "Secretaire");
        request.setAttribute("admin", "Administrateur");
        request.setAttribute("equipement", this.equipementService.findById(id));
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Equipement equipement = new Equipement(0, "a", "a", "a", 0, LocalDate.now(), "a");
        equipement = this.equipementService.findById(id);
        equipement.setNom_equipement(request.getParameter("nom_equipement_up"));
        equipement.setZone_stockage(request.getParameter("zone_stockage_up"));
        equipement.setEtat(request.getParameter("etat_up"));
        equipement.setDisponibilite_equipement(Integer.parseInt(request.getParameter("disponibilite_equipement_up")));
        equipement.setDate_acquisition(LocalDate.parse(request.getParameter("date_acquisition_up")));
        equipement.setDescription(request.getParameter("description_up"));
        equipementService.update(equipement);
        response.sendRedirect("/ges/equipement?role="+role);
    }
    
}
