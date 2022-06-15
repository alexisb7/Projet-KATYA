package com.epf.katya.ui.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.exception.ServiceException;
import com.epf.katya.model.ReservationEquipement;
import com.epf.katya.model.ReservationSalle;
import com.epf.katya.service.EquipementService;
import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.ReservationSalleService;
import com.epf.katya.service.UtilisateurService;

import java.io.IOException;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    
    @Autowired
    ReservationSalleService reservationSalleService;

    @Autowired
    ReservationEquipementService reservationEquipementService;

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    EquipementService equipementService;

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
            request.setAttribute("listResaEquipement", this.reservationEquipementService.findAll());
            request.setAttribute("listUser", this.utilisateurService.findAll());
            request.setAttribute("listEquipement", this.equipementService.findAll());
                
            
        }
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bouton_salle = request.getParameter("bouton_salle");
        String bouton_equip = request.getParameter("bouton_equip");
        String id_salle = request.getParameter("id_salle");
        String id_equipement = request.getParameter("id_equip");
        if(bouton_salle != null){
            resaSalleOrEquipement = 0;
        }   
        if(bouton_equip != null){
            resaSalleOrEquipement = 1;
        }
        if(id_salle != null){
            ReservationSalle reservationSalle = reservationSalleService.findById(Integer.parseInt(id_salle));
            reservationSalleService.delete(reservationSalle);
        }
        if(id_equipement != null){
            try {
                ReservationEquipement reservationEquipement = reservationEquipementService.findById(Integer.parseInt(id_equipement));
                reservationEquipementService.delete(reservationEquipement);
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ServiceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        doGet(request, response);
    }
}
