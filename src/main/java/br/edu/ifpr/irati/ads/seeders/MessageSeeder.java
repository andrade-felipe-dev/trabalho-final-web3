package br.edu.ifpr.irati.ads.seeders;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Message;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.user.Default;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

public class MessageSeeder {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            InterfaceDAO<Ticket> ticketDAO = new GenericDAO<>(Ticket.class, session);
            Ticket ticket = ticketDAO.findById(1);

            InterfaceDAO<Default> defaultDAO = new GenericDAO<>(Default.class, session);
            Default userDefault = defaultDAO.findById(2);


            InterfaceDAO<Message> messageDAO = new GenericDAO<>(Message.class, session);
            Message message = new Message(0,"Em meu computador está gerando um problema muito complicado para ser resolvido, preciso de auxilio urgente", ticket, userDefault);

            messageDAO.save(message);
        } catch (PersistenceException e) {
            throw new RuntimeException(e);
        }


    }
}
