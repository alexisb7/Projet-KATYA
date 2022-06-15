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
import com.epf.katya.service.ReservationEquipementService;

import java.io.IOException;


@WebServlet("/equipement")
public class EquipementServlet extends HttpServlet {

    @Autowired
    EquipementService equipementService;
    
    @Autowired
    ReservationEquipementService reservationEquipementService;

   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String role = request.getParameter("role");
                request.setAttribute("role", role);
        request.setAttribute("listEquipement", this.equipementService.findAll());
        request.setAttribute("nombre", this.equipementService.count());
      
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/equipement/equipement.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null){
            int id_equipement = Integer.parseInt(id);
            while(this.reservationEquipementService.findByEquipement(id_equipement)!=null){
                this.reservationEquipementService.delete(this.reservationEquipementService.findByEquipement(id_equipement));
            }
            Equipement equipement = equipementService.findById(Integer.parseInt(id));
            this.equipementService.delete(equipement);    
        }
        doGet(request, response);
    }
}
