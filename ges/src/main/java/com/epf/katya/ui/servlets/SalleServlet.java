package com.epf.katya.ui.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

<<<<<<< HEAD
@WebServlet("/salle")
=======
@WebServlet("/salles")
>>>>>>> 59357f7f2bca09e448d27eefaaf72f1600719efb
public class SalleServlet extends HttpServlet {
//    public void init() throws ServletException {
//        super.init();
//        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher r = request.getRequestDispatcher("WEB-INF/views/salle.jsp");

        r.forward(request, response);

    }
}
