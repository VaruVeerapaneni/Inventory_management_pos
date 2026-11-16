package com.rafsan.inventory;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static boolean setSessionFactory() {

        if (sessionFactory != null && !sessionFactory.isClosed()) {
            return true;
        }

        try {
            Properties properties = new Properties();

            File externalConfigFile = new File("application.properties");
            if (externalConfigFile.exists() && externalConfigFile.isFile()) {
                try (InputStream input = new FileInputStream(externalConfigFile)) {
                    properties.load(input);
                }
            } else {
                try (InputStream input = HibernateUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
                    if (input == null) {
                        throw new IOException("application.properties not found");
                    }
                    properties.load(input);
                }
            }

            Configuration configuration = new Configuration().configure();
            configuration.setProperty("hibernate.connection.url", properties.getProperty("db.url"));
            configuration.setProperty("hibernate.connection.username", properties.getProperty("db.username"));
            configuration.setProperty("hibernate.connection.password", properties.getProperty("db.password"));

            sessionFactory = configuration.buildSessionFactory();

            return true;

        }
        catch (IOException | HibernateException | NullPointerException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
