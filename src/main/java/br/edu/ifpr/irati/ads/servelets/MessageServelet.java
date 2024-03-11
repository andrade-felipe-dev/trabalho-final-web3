package br.edu.ifpr.irati.ads.servelets;

import br.edu.ifpr.irati.ads.controls.MessageController;
import br.edu.ifpr.irati.ads.controls.TicketController;
import br.edu.ifpr.irati.ads.controls.UserController;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Message;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.user.User;
import br.edu.ifpr.irati.ads.utils.CookieUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MessageServelet", urlPatterns = {
        "/salvarMensagem"
})
public class MessageServelet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    try {
      String newMessage = req.getParameter("message");
      int idTicket = Integer.parseInt(req.getParameter("ticketid"));

      MessageController messageController = new MessageController();
      TicketController ticketController = new TicketController();
      Ticket ticket = ticketController.findById(idTicket);
      UserController userController = new UserController();

      CookieUtil cookieUtil  = new CookieUtil();
      Cookie emailCookie = cookieUtil.getEmail(req);
      User author = userController.findEmail(emailCookie.getValue());

      Message message = new Message(0, newMessage, ticket, author);
      messageController.createMessage(message);

      resp.sendRedirect(req.getContextPath() + "/tickets/editar?id=" + idTicket);
    } catch (PersistenceException e) {
      throw new RuntimeException(e);
    }
  }
}
