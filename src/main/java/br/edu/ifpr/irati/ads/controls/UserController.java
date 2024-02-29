package br.edu.ifpr.irati.ads.controls;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.user.User;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

public class UserController {
    private final Session session;

    public UserController() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public User findById(int id) {
        try {
            InterfaceDAO<User> userDAO = new GenericDAO<>(User.class, this.session);

            return userDAO.findById(id);
        } catch (PersistenceException e) {
            throw new RuntimeException(e);
        }
    }
}