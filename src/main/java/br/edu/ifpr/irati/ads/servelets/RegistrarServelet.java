package br.edu.ifpr.irati.ads.servelets;

import br.edu.ifpr.irati.ads.controls.UserController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistrarServelet", urlPatterns = {"/registrar"})
public class RegistrarServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("name");
        String email = req.getParameter("email");
        UserController userController = new UserController();
        userController.saveDefaultUser(nome, email);

        resp.sendRedirect("/login");

//        req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/registrar.jsp").forward(req, resp);
    }
}
