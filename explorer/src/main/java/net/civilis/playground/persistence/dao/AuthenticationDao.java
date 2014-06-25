package net.civilis.playground.persistence.dao;

import net.civilis.playground.persistence.entity.AppUser;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AuthenticationDao {

    private static ServiceRegistry serviceRegistry;
    private static SessionFactory factory;

    private static void initFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);

            // deprecated code
            // factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory getFactory() {
        if (factory == null) {
            initFactory();
        }
        return factory;
    }
    
    public static AppUser getAppUser(String username)
    {
    	AppUser result = null;
    	String sql = "select o from AppUser o where o.username = :username";

        Session session = getFactory().openSession();
        Transaction transaction = null;

        try
        {
        	transaction = session.beginTransaction();
        	Query query = session.createQuery(sql);
        	query.setString("username", username);
        	result = (AppUser) query.uniqueResult();
        	transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        
        return result;
    }

}
