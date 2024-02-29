package br.edu.ifpr.irati.ads.servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/login")
public class LoginServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");

        if (usuario.equals("zedavila") && senha.equals("123")) {
            String stoken = "F1EE133C90D3ABBB9CE63190C3B2360D10A13B7DAB3E391C267ECF0BA84647D5";
            Cookie token = new Cookie("token",stoken);
            token.setMaxAge(60);
            resp.addCookie(token);
        }
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cheguei");

        resp.sendRedirect("/login.jsp");
    }
}
