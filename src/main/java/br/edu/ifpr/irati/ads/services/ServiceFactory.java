package br.edu.ifpr.irati.ads.services;

import br.edu.ifpr.irati.ads.servelets.Service;

public class ServiceFactory {
  public static Service getService(String name) {
    switch (name) {
      case "tickets":
        return new TicketService();
      default:
        return null;
    }
  }
}
