package com.epf.katya.ui.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.katya.service.EquipementService;

import java.io.IOException;

@WebServlet("/equipement")
public class EquipementServlet extends HttpServlet {

    @Autowired
    EquipementService equipementService;

   public void init() throws ServletException {
       super.init();
       SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/equipement.jsp");

        r.forward(request, response);

    }
}
