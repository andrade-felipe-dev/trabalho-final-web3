package br.edu.ifpr.irati.ads.seeders;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;

import br.edu.ifpr.irati.ads.models.user.Default;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

public class DefaultSeeder {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            InterfaceDAO<Default> defaultDAO = new GenericDAO<>(Default.class, session);
            Default user1 = new Default(0, "usuario 1", "usuario1@user.com.br");
            Default user2 = new Default(0, "usuario 2", "usuario2@user.com.br");
            Default user3 = new Default(0, "usuario 3", "usuario3@user.com.br");
            defaultDAO.save(user1);
            defaultDAO.save(user2);
            defaultDAO.save(user3);
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }
    }
}
