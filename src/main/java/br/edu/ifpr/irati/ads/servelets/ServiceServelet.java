package br.edu.ifpr.irati.ads.servelets;

import br.edu.ifpr.irati.ads.controls.ThemeController;
import br.edu.ifpr.irati.ads.controls.TicketController;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Theme;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.enums.StatusTicketEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "serviceservelet", urlPatterns = {
        "/tickets/listar",
        "/tickets/editar",
        "/tickets/salvar",
        "/tickets/excluir"
})
public class ServiceServelet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String path = req.getServletPath();

    if (path.split("/").length == 3) {
      String entity = path.split("/")[1];
      Service service = Service.ServiceFactory.getService(entity);
      String method = path.split("/")[2];
      switch (method) {
        case "listar":
          service.listar(req, resp);
          break;
        case "editar":
          service.editar(req, resp);
          break;
        case "salvar":
          service.salvar(req, resp);
          break;
        case "excluir":
          service.excluir(req, resp);
          break;
        default:
          //enviar para página de erro
          break;
      }
    }
  }


}
