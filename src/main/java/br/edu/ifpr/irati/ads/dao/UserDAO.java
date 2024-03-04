package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public boolean existsEmail(String email) {
        String hql = "FROM user u WHERE u.email = :email";
        Query<User> query = this.session.createQuery(hql, User.class);

        query.setParameter("email", email);
        var result = query.getFirstResult();

        System.out.println(result);

        return true;
    }
}