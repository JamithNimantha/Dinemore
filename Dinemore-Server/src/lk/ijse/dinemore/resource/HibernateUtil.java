package lk.ijse.dinemore.resource;

import lk.ijse.dinemore.entity.Chef;
import lk.ijse.dinemore.entity.Menu;
import lk.ijse.dinemore.entity.Rider;
import lk.ijse.dinemore.entity.TelOperator;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory =buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();
        Metadata metadata =new MetadataSources(registry)
                .addAnnotatedClass(Chef.class)
                .addAnnotatedClass(Menu.class)
                .addAnnotatedClass(TelOperator.class)
                .addAnnotatedClass(Rider.class)
                .buildMetadata();
        return metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
