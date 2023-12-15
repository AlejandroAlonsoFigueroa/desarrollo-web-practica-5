package alejandro.figueroa.configuracion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;

import alejandro.figueroa.entities.*;


public class HibernateUtils {

private static SessionFactory fabricaSesiones = null;
	
private static StandardServiceRegistry registry;
private static SessionFactory sessionFactory;

public static SessionFactory getSessionFactory(){
    if (sessionFactory == null){
        try{
            registry = new StandardServiceRegistryBuilder().configure().build();
            MetadataSources sources = new MetadataSources(registry);
            Metadata metadata = sources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
            if (registry != null){
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }
    }
    return sessionFactory;
}
public static void shutdown(){
    
}
}
