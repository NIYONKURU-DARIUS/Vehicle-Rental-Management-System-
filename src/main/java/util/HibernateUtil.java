package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }catch(HibernateException ex){
            System.err.println("Initial SessionFactory creation failed.");
            throw new  ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession(){
        return sessionFactory.openSession();
    }
    public static void shutdown(){
        sessionFactory.close();
    }
}

