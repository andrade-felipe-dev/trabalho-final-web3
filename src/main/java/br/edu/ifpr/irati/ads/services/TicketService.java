package br.edu.ifpr.irati.ads.services;

import br.edu.ifpr.irati.ads.controls.ThemeController;
import br.edu.ifpr.irati.ads.controls.TicketController;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Theme;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.enums.StatusTicketEnum;
import br.edu.ifpr.irati.ads.servelets.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
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
      req.getServletContext().getRequestDispatcher("/tickets").forward(req, resp);
    } catch (PersistenceException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  public void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      TicketController ticketController = new TicketController();

      Ticket ticket = new Ticket();

      int id = Integer.parseInt(req.getParameter("id"));
      String title = req.getParameter("title");
      String description = req.getParameter("description");
      int idTheme = Integer.parseInt(req.getParameter("theme"));
      Theme theme = null;
      if (idTheme != 0) {
        ThemeController themeController = new ThemeController();
        theme = themeController.findById(idTheme);
      }
      if (id == 0) {
        ticket.setStatus(StatusTicketEnum.ABERTO);
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setTheme(theme);
        ticket.setEndDateWithDays(theme.getEndDateWithDays());
      }

    } catch (PersistenceException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}
