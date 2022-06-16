package com.epf.katya.ui.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.service.UtilisateurService;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    
    @Autowired
    UtilisateurService utilisateurService;

    boolean isConnected = false;
    boolean erreurId = false;
    boolean erreurMdp = false;
    int connection = 0;
    String id="";
    String role="";

   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="";
        if(connection == 1){
            erreurId = false;
            erreurMdp = false;
            isConnected = true;
            request.setAttribute("erreurMdp", erreurMdp);
            request.setAttribute("erreurId", erreurId);
            request.setAttribute("id", id);
            role = utilisateurService.findById(id).getRole();
            request.setAttribute("role", utilisateurService.findById(id).getRole());
            request.setAttribute("eleve", "Eleve");
            request.setAttribute("secretaire", "Secretaire");
            request.setAttribute("admin", "Responsable");
            path= "/WEB-INF/views/home/home_connected.jsp";
        }
        if(connection == 0){
            erreurId = false;
            erreurMdp = false;
            request.setAttribute("erreurMdp", erreurMdp);
            request.setAttribute("erreurId", erreurId);
            path = "/WEB-INF/views/home/home_not_connected.jsp";
        }
        if(connection == 2){ //erreur mdp
            erreurMdp = true;
            erreurId=false;
            request.setAttribute("erreurMdp", erreurMdp);
            request.setAttribute("erreurId", erreurId);
            path = "/WEB-INF/views/home/home_not_connected.jsp";
        }
        if(connection == 3){ //erreur id
            erreurId = true;
            erreurMdp = false;
            request.setAttribute("erreurMdp", erreurMdp);
            request.setAttribute("erreurId", erreurId);
            path = "/WEB-INF/views/home/home_not_connected.jsp";
        }
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isConnected == true){
            String deconnect = request.getParameter("deconnected");
            if(deconnect != null){
                isConnected = false;
                connection = 0;
                erreurId = false;
                erreurMdp = false;
                request.setAttribute("erreurMdp", erreurMdp);
                request.setAttribute("erreurId", erreurId);
                doGet(request, response);
            }
        }
        else {
            id = request.getParameter("id");
            String mdp = request.getParameter("mdp");
            connection = this.utilisateurService.controlConnection(id, mdp);
            doGet(request, response);
        }
    }
}
