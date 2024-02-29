package br.edu.ifpr.irati.ads.seeders;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Theme;
import br.edu.ifpr.irati.ads.models.enums.NameThemeEnum;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

public class ThemeSeeder {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            InterfaceDAO<Theme> themeDAO = new GenericDAO<>(Theme.class, session);
            Theme theme1 = new Theme(0, NameThemeEnum.PROBLEMAS_SO, 10);
            Theme theme2 = new Theme(0, NameThemeEnum.CONEXAO_INTERROMPIDA, 5);
            Theme theme3 = new Theme(0, NameThemeEnum.INSTALACAO_APLICATIVO, 3);
            Theme theme4 = new Theme(0, NameThemeEnum.OUTROS, 7);
            themeDAO.save(theme1);
            themeDAO.save(theme2);
            themeDAO.save(theme3);
            themeDAO.save(theme4);
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }
    }
}
