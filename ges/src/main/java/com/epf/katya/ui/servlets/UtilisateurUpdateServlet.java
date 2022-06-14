package com.epf.katya.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.model.Utilisateur;
import com.epf.katya.service.UtilisateurService;

@WebServlet("/utilisateur/update")
public class UtilisateurUpdateServlet extends HttpServlet{

    @Autowired
    UtilisateurService utilisateurService;

    String id="";
    
   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/WEB-INF/views/utilisateur/utilisateur_update.jsp";
        id = request.getParameter("id");
        request.setAttribute("user", this.utilisateurService.findById(id));
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateur = this.utilisateurService.findById(id);
        utilisateur.setId_utilisateur(request.getParameter("id"));
        utilisateur.setEmail(request.getParameter("email"));
        utilisateur.setMdp(request.getParameter("mdp"));
        utilisateur.setNom_utilisateur(request.getParameter("nom"));
        utilisateur.setRole(request.getParameter("role"));
        utilisateurService.update(utilisateur, id);
        response.sendRedirect("/ges/utilisateur");
    }
    
}
