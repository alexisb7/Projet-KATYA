package com.epf.katya.ui.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.service.ReservationEquipementService;
import com.epf.katya.service.ReservationSalleService;
import com.epf.katya.service.UtilisateurService;

import java.io.IOException;

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet {

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    ReservationEquipementService reservationEquipementService;

    @Autowired
    ReservationSalleService reservationSalleService;
    
   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/WEB-INF/views/utilisateur/utilisateur.jsp";
        request.setAttribute("listUtilisateur", this.utilisateurService.findAll());
        request.setAttribute("nombre", this.utilisateurService.count());
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null){
            while(this.reservationEquipementService.findByUser(id)!=null){
                this.reservationEquipementService.delete(this.reservationEquipementService.findByUser(id));
            }
            while(this.reservationSalleService.findByUser(id)!=null){
                this.reservationSalleService.delete(this.reservationSalleService.findByUser(id));               
            }
            this.utilisateurService.delete(id);
        }
        doGet(request, response);
    }
}
