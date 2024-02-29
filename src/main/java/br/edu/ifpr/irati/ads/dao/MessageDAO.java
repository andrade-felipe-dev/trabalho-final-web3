package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.models.Message;
import br.edu.ifpr.irati.ads.models.Ticket;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MessageDAO {
    private Session session;

    public MessageDAO(Session session) {
        this.session = session;
    }

    public List<Message> findByTicket(Ticket ticket) {
        String hql = "from message m where m.ticket.id  = :idTicket";

        Query<Message> query = this.session.createQuery(hql, Message.class);
        query.setParameter("idTicket", ticket.getId());

        return query.list();
    }
}
