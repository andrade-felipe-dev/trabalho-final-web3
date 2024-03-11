package br.edu.ifpr.irati.ads.controls;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Theme;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ThemeController {
  private Session session;

  public ThemeController() {
    session = HibernateUtil.getSessionFactory().openSession();
  }

  public Theme findById(int id) throws PersistenceException {
    InterfaceDAO<Theme> themeDAO = new GenericDAO<>(Theme.class, session);
    return themeDAO.findById(id);
  }

  public List<Theme> findAll() throws PersistenceException {
    InterfaceDAO<Theme> themeDAO = new GenericDAO<>(Theme.class, session);
    return themeDAO.findAll();
  }

  public void save(Theme theme) throws PersistenceException {
    InterfaceDAO<Theme> themeDAO = new GenericDAO<>(Theme.class, session);
    themeDAO.save(theme);
  }
}
