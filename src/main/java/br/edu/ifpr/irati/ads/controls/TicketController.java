package br.edu.ifpr.irati.ads.controls;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.TicketDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.user.Helper;
import br.edu.ifpr.irati.ads.models.user.User;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class TicketController {
    private Session session;

    public TicketController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public Ticket findById(int id) throws PersistenceException {
        InterfaceDAO<Ticket> ticketDAO = new GenericDAO<>(Ticket.class, session);
        return ticketDAO.findById(id);
    }

    public List<Ticket> listTickets() throws PersistenceException {
        InterfaceDAO<Ticket> ticketDAO = new GenericDAO<>(Ticket.class, session);
        return ticketDAO.findAll();
    }

    public void createTicket(Ticket ticket) throws PersistenceException {
        InterfaceDAO<Ticket> ticketDAO = new GenericDAO<>(Ticket.class, session);
        ticketDAO.save(ticket);
    }

    public void updateTicket(Ticket ticket) throws PersistenceException {
        InterfaceDAO<Ticket> ticketDAO = new GenericDAO<>(Ticket.class, session);
        ticketDAO.edit(ticket);
    }


    public void deleteTicket(Ticket ticket) throws PersistenceException {
        InterfaceDAO<Ticket> ticketDAO = new GenericDAO<>(Ticket.class, session);
        ticketDAO.destroy(ticket);
    }

    public List<Ticket> listAllTicketWithResponsible(Helper user) {
        TicketDAO ticketDAO = new TicketDAO(session);

        return ticketDAO.findByResponsible(user.getId());
    }

    public List<Ticket> listAllTicketWithCreatedBy(User user) {
        TicketDAO ticketDAO = new TicketDAO(session);

        return ticketDAO.findByCreatedBy(user);
    }
}
