package com.epf.katya.ui.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.exception.ServiceException;
import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.ReservationSalleService;

import java.io.IOException;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    
    @Autowired
    ReservationSalleService reservationSalleService;

    @Autowired
    ReservationEquipementService reservationEquipementService;

    int resaSalleOrEquipement = 0;

   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="";
        if(resaSalleOrEquipement == 0){
            path = "/WEB-INF/views/reservation/reservation_salle.jsp";
            request.setAttribute("listResaSalle", this.reservationSalleService.findAll());
        }
        if(resaSalleOrEquipement == 1){
            path = "/WEB-INF/views/reservation/reservation_equipement.jsp";
            try {
                request.setAttribute("listResaEquipement", this.reservationEquipementService.findAll());
            } catch (ServiceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bouton_salle = request.getParameter("bouton_salle");
        String bouton_equip = request.getParameter("bouton_equip");
        if(bouton_salle != null){
            resaSalleOrEquipement = 0;
        }   
        if(bouton_equip != null){
            resaSalleOrEquipement = 1;
        }
        doGet(request, response);
    }
}
