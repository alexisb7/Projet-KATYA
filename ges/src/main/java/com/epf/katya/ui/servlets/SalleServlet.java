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
import com.epf.katya.service.ReservationSalleService;
import com.epf.katya.service.SalleService;

import java.io.IOException;


@WebServlet("/salle")
public class SalleServlet extends HttpServlet {

    @Autowired
    SalleService salleService;

    @Autowired 
    ReservationSalleService reservationSalleService;

    public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
 
        request.setAttribute("listeSalle", this.salleService.findAll());
        request.setAttribute("nombre", this.salleService.count());
        RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/views/salle/salle.jsp");

        r.forward(request, response);
  
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response, String research) throws ServletException, IOException{
        if(research != null) {
            request.setAttribute("listeSalle", this.salleService.research(research));
        }else {        
            request.setAttribute("listeSalle", this.salleService.findAll());
        }				
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/salle/salle.jsp").forward(request, response);
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String numero = request.getParameter("numero");
        if(numero!=null) {   
            while(this.reservationSalleService.findBySalle(numero)!=null) {
                this.reservationSalleService.delete(this.reservationSalleService.findBySalle(numero));
            } 
            Salle salle = new Salle();
            salle.setNumero(numero);
            salleService.delete(salle);
        }
        
        doGet(request, response, request.getParameter("research"));
    }
}
