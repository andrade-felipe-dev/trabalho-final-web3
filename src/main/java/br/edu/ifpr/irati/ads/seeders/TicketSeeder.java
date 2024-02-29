package br.edu.ifpr.irati.ads.seeders;

import br.edu.ifpr.irati.ads.dao.GenericDAO;
import br.edu.ifpr.irati.ads.dao.InterfaceDAO;
import br.edu.ifpr.irati.ads.dao.exception.PersistenceException;
import br.edu.ifpr.irati.ads.models.Theme;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.enums.StatusTicketEnum;
import br.edu.ifpr.irati.ads.models.user.Default;
import br.edu.ifpr.irati.ads.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TicketSeeder {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            InterfaceDAO<Default> defaultDAO = new GenericDAO<>(Default.class, session);
//            Default userDefault = defaultDAO.findById(2);
//
            InterfaceDAO<Theme> themeDAO = new GenericDAO<>(Theme.class, session);
            Theme theme = themeDAO.findById(1);


            InterfaceDAO<Ticket> ticketDAO = new GenericDAO<>(Ticket.class, session);
//            Ticket ticket = new Ticket(0, "Novo problema", "Houve um problema em minha máquina", userDefault, theme, theme.getEndDateWithDays(), StatusTicketEnum.ABERTO);
//            ticketDAO.save(ticket);

            //---------------------//

            Default userDefault1 = defaultDAO.findById(3);
            Theme theme1 = themeDAO.findById(3);
            Ticket ticket1 = new Ticket(0, "Novo problema", "Preciso que instale um software em minha máquina", userDefault1, theme1, theme.getEndDateWithDays(), StatusTicketEnum.ABERTO);
            ticketDAO.save(ticket1);

            //-----------------------------//
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }
    }
}
