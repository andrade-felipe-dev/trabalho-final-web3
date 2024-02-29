package br.edu.ifpr.irati.ads.seeders;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.user.Admin;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

public class AdminSeeder {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            InterfaceDAO<Admin> adminDAO = new GenericDAO<>(Admin.class, session);

            Admin admin = new Admin(0, "admin", "admin@admin.com.br");
            adminDAO.save(admin);
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }

    }
}
