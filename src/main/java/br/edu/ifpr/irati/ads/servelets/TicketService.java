package br.edu.ifpr.irati.ads.servelets;

import br.edu.ifpr.irati.ads.controls.ThemeController;
import br.edu.ifpr.irati.ads.controls.TicketController;
import br.edu.ifpr.irati.ads.controls.UserController;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Theme;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.enums.StatusTicketEnum;
import br.edu.ifpr.irati.ads.models.user.User;
import br.edu.ifpr.irati.ads.utils.CalendarUtil;
import br.edu.ifpr.irati.ads.utils.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TicketService implements Service {
  @Override
  public void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      TicketController ticketController = new TicketController();
      List<Ticket> tickets = ticketController.listTickets();
      Collections.sort(tickets);
      req.setAttribute("tickets", tickets);
      req.setAttribute("ticketAtual", null);
      req.getServletContext().getRequestDispatcher("/tickets.jsp").forward(req, resp);
    } catch (PersistenceException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Ticket ticket = new Ticket();
      TicketController ticketController = new TicketController();
      ThemeController themeController = new ThemeController();

      int id = Integer.parseInt(req.getParameter("id"));
      if (id != 0) {
        ticket = ticketController.findById(id);
      }

      req.setAttribute("tickets", new ArrayList<>());
      req.setAttribute("ticketatual", ticket);
      req.setAttribute("themes", themeController.findAll());
      req.getServletContext().getRequestDispatcher("/tickets.jsp").forward(req, resp);

    }catch (NumberFormatException | PersistenceException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      String daysOfTicket = req.getParameter("newDateTicket");

      CookieUtil cookieUtil = new CookieUtil();
      Cookie emailCookie = cookieUtil.getEmail(req);
      TicketController ticketController = new TicketController();
      UserController userController = new UserController();
      CalendarUtil calendarUtil = new CalendarUtil();
      Date dayTicket = calendarUtil.formatStringToDate(daysOfTicket);

      int id = Integer.parseInt(req.getParameter("id"));
      String title = req.getParameter("title");
      String description = req.getParameter("description");
      int idTheme = Integer.parseInt(req.getParameter("theme"));

      String email = emailCookie.getValue();
      User createdBy = userController.findEmail(email);
      Theme theme = null;
      if (idTheme != 0) {
        ThemeController themeController = new ThemeController();
        theme = themeController.findById(idTheme);
      }
      Date previsionWithFinish = calendarUtil.addDays(dayTicket, theme.getEndDateWithDays());

      if (id == 0) {
        Ticket ticket = new Ticket(0, title, description, createdBy, theme, previsionWithFinish, StatusTicketEnum.ABERTO);
        ticketController.save(ticket);
      } else {
        Ticket ticket = ticketController.findById(id);
        ticket.setStatus(StatusTicketEnum.ABERTO);
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setTheme(theme);
        ticketController.updateTicket(ticket);
      }
      listar(req, resp);
    } catch (PersistenceException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      int id = Integer.parseInt(req.getParameter("id"));
      TicketController ticketController = new TicketController();
      Ticket ticket = ticketController.findById(id);

      ticketController.deleteTicket(ticket);

      listar(req, resp);
    } catch (PersistenceException e) {
      throw new RuntimeException(e);
    }
  }
}
