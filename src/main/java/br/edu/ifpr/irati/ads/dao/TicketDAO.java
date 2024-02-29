package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TicketDAO {
    private Session session;

    public TicketDAO(Session session) {
        this.session = session;
    }

    public List<Ticket> findByResponsible(int userId) {
        String hql = "from ticket t where t.responsible.id = :userId";

        Query<Ticket> query = this.session.createQuery(hql, Ticket.class);
        query.setParameter("userId", userId);

        return query.list();
    }

    public List<Ticket> findByCreatedBy(User user) {
        String hql = "FROM ticket t WHERE t.createdBy = :user";

        Query<Ticket> query = this.session.createQuery(hql, Ticket.class);
        query.setParameter("user", user);

        return query.list();
    }
}
