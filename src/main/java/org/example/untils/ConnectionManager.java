package org.example.untils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionManager {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); // zaczytany plik h config xml

    public static Session getSession() {
        return sessionFactory.openSession();
    }

}
