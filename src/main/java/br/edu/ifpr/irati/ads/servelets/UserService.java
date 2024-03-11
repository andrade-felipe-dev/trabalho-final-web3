package br.edu.ifpr.irati.ads.servelets;

import br.edu.ifpr.irati.ads.controls.TicketController;
import br.edu.ifpr.irati.ads.controls.UserController;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements Service{

  @Override
  public void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<User> users = new ArrayList<>();
    UserController userController = new UserController();
    users = userController.findAll();


    req.setAttribute("users", users);
    req.setAttribute("useratual", null);
    req.getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
  }

  @Override
  public void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      UserController userController = new UserController();
      User user = new User();
      int id = Integer.parseInt(req.getParameter("id"));
      if (id != 0) {
        user = userController.findById(id);
      }

      req.setAttribute("users", new ArrayList<>());
      req.setAttribute("useratual", user);
      req.getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
    }catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    String title = req.getParameter("title");
    String description = req.getParameter("description");
    String type = req.getParameter("type");


  }

  @Override
  public void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    UserController userController = new UserController();
    User user = userController.findById(id);

    userController.delete(user);

    listar(req, resp);
  }
}
