package br.edu.ifpr.irati.ads.servelets;

import br.edu.ifpr.irati.ads.controls.UserController;
import br.edu.ifpr.irati.ads.models.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "LoginServelet", urlPatterns = {"/login"})
public class LoginServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        UserController userController = new UserController();
        User user  = userController.findEmail(email);

        if (user != null) {
            Cookie userEmail = new Cookie("email", user.getEmail());
            Cookie userRule = new Cookie("type", user.getTypeUser(user));

            userEmail.setMaxAge(86400);
            userRule.setMaxAge(86400);

            resp.addCookie(userEmail);
            resp.addCookie(userRule);
        }

        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }

        req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
