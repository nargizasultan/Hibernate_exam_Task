package peaksoft.house.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;

public class Configuration {

    //release hibernate configuration here

    public static SessionFactory createSessionFactory() {
        // write configuration if you want use session factory
        // if you don't use this method then don't remove!
        return null;
    }

    public static EntityManagerFactory createEntityManagerFactory() {
        // write entity manager configuration if you want use entity manager factory
        // if you don't use this method then don't remove!
        return null;
    }
}
