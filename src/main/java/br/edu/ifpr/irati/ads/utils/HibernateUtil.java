package br.edu.ifpr.irati.ads.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifpr.irati.ads.models.Message;
import br.edu.ifpr.irati.ads.models.Theme;
import br.edu.ifpr.irati.ads.models.Ticket;
import br.edu.ifpr.irati.ads.models.user.Admin;
import br.edu.ifpr.irati.ads.models.user.Default;
import br.edu.ifpr.irati.ads.models.user.Helper;
import br.edu.ifpr.irati.ads.models.user.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Map<String, Object> settings = new HashMap<>();
            settings.put("connection.driver_class", "com.mysql.cj.jdbc.Driver");
            settings.put("dialect", "org.hibernate.dialect.MySQLDialect");
            //settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/eapjsfhibernate");
            settings.put("hibernate.connection.url","jdbc:mysql://localhost:3306/helpdesk?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8");
            settings.put("hibernate.connection.username", "root");
            settings.put("hibernate.hbm2ddl.auto", "update");
            settings.put("hibernate.connection.password", "1234");
            settings.put("hibernate.current_session_context_class", "thread");
            settings.put("hibernate.show_sql", "true");
            settings.put("hibernate.format_sql", "true");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();


            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Message.class);
            metadataSources.addAnnotatedClass(Theme.class);
            metadataSources.addAnnotatedClass(Ticket.class);
            metadataSources.addAnnotatedClass(Admin.class);
            metadataSources.addAnnotatedClass(Default.class);
            metadataSources.addAnnotatedClass(Helper.class);
            metadataSources.addAnnotatedClass(User.class);

            Metadata metadata = metadataSources.buildMetadata();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }
}
