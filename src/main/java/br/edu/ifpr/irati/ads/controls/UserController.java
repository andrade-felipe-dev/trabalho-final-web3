package br.edu.ifpr.irati.ads.controls;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.UserDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.user.Default;
import br.edu.ifpr.irati.ads.models.user.Helper;
import br.edu.ifpr.irati.ads.models.user.User;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

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

    public Helper findByIdHelper(int id) {
        try {
            InterfaceDAO<Helper> userDAO = new GenericDAO<>(Helper.class, this.session);

            return userDAO.findById(id);
        } catch (PersistenceException e) {
            throw new RuntimeException(e);
        }
    }

    public User findEmail(String email) {
        UserDAO userDAO = new UserDAO(this.session);

        return userDAO.findEmail(email);
    }

    public void saveDefaultUser(String name, String email) {
        try {
            Default defaultUser = new Default(0, name, email);
            InterfaceDAO<Default> userDAO = new GenericDAO<>(Default.class, session);

            userDAO.save(defaultUser);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    public List<Helper> listAllHelpers() {
        try {
            InterfaceDAO<Helper> userDAO = new GenericDAO<>(Helper.class, session);

            return userDAO.findAll();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(User user) {
        try {
            InterfaceDAO<User> userDAO = new GenericDAO<>(User.class, session);

            userDAO.destroy(user);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        try {
            InterfaceDAO<User> userDAO = new GenericDAO<>(User.class, session);

            return userDAO.findAll();
        } catch (PersistenceException e) {
          e.printStackTrace();
        }
      return null;
    }
}
