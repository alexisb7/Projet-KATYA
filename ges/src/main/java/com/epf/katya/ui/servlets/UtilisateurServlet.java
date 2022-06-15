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

@WebServlet("/utilisateur")
public class UtilisateurServlet extends HttpServlet {

    @Autowired
    UtilisateurService utilisateurService;
    
   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/WEB-INF/views/utilisateur/utilisateur.jsp";
        String role = request.getParameter("role");
        request.setAttribute("role", role);
        request.setAttribute("listUtilisateur", this.utilisateurService.findAll());
        request.setAttribute("nombre", this.utilisateurService.count());
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null){
            this.utilisateurService.delete(id);
        }
        doGet(request, response);
    }
}
