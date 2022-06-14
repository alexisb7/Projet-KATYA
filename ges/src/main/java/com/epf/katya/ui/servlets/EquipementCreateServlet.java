package com.epf.katya.ui.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.Equipement;
import com.epf.katya.service.EquipementService;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/equipement/equipementCreate")
public class EquipementCreateServlet extends HttpServlet {

    @Autowired
    EquipementService equipementService;

   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/equipement/equipementCreate.jsp").forward(request, response);
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Equipement equipement = new Equipement(100 ,request.getParameter("Nom_equipement"), request.getParameter("Zone_stockage"), request.getParameter("etat"), Integer.parseInt(request.getParameter("disponibilite_equipement")), LocalDate.parse(request.getParameter("date_acquisition")), request.getParameter("description"),2);
        try {
            equipementService.create(equipement);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        doGet(request, response);

    }
        //RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/equipement.jsp");

        //r.forward(request, response);

    
}
