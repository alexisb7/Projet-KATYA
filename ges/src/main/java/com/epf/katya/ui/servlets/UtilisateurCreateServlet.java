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

import com.epf.katya.model.Utilisateur;
import com.epf.katya.service.UtilisateurService;

@WebServlet("/utilisateur_create")
public class UtilisateurCreateServlet extends HttpServlet{

    @Autowired
    UtilisateurService utilisateurService;
    
    String role="";
    
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="/WEB-INF/views/utilisateur/utilisateur_create.jsp";
        role = request.getParameter("role");
        request.setAttribute("role", role);
        request.setAttribute("eleve", "Eleve");
        request.setAttribute("secretaire", "Secretaire");
        request.setAttribute("admin", "Administrateur");
        this.getServletContext().getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId_utilisateur(request.getParameter("id"));
        utilisateur.setEmail(request.getParameter("email"));
        utilisateur.setMdp(request.getParameter("mdp"));
        utilisateur.setNom_utilisateur(request.getParameter("nom"));
        utilisateur.setRole(request.getParameter("role"));
        utilisateur.setDate_entree(LocalDate.now());
        this.utilisateurService.create(utilisateur);
        response.sendRedirect("/ges/utilisateur?role="+role);
    }
}
