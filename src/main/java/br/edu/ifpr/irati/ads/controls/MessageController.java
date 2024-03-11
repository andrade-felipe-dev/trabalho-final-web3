package br.edu.ifpr.irati.ads.controls;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.MessageDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Message;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MessageController {
    private final Session session;


    public MessageController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public List<Message> findByTicket(Ticket ticket) {
        MessageDAO messageDAO = new MessageDAO(this.session);

        return messageDAO.findByTicket(ticket);
    }

    public void createMessage(Message message) throws PersistenceException {
        InterfaceDAO<Message> messageDAO = new GenericDAO<>(Message.class, session);
        messageDAO.save(message);
    }
}
