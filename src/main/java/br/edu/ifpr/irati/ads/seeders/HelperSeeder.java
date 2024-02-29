package br.edu.ifpr.irati.ads.seeders;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.user.Default;
import br.edu.ifpr.irati.ads.models.user.Helper;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

public class HelperSeeder {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            InterfaceDAO<Helper> helperDAO = new GenericDAO<>(Helper.class, session);
            Helper helper1 = new Helper(0, "helper 1", "helper1@helper.com.br");
            Helper helper2 = new Helper(0, "helper 2", "helper2@helper.com.br");
            Helper helper3 = new Helper(0, "helper 3", "helper3@helper.com.br");
            helperDAO.save(helper1);
            helperDAO.save(helper2);
            helperDAO.save(helper3);
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }
    }
}
