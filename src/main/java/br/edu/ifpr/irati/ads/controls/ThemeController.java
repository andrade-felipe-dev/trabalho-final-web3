package br.edu.ifpr.irati.ads.controls;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Theme;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

public class ThemeController {
  private Session session;

  public ThemeController() {
    session = HibernateUtil.getSessionFactory().openSession();
  }

  public Theme findById(int id) throws PersistenceException {
    InterfaceDAO<Theme> themeDAO = new GenericDAO<>(Theme.class, session);
    return themeDAO.findById(id);
  }
}
