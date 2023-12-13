package alejandro.figueroa.configuracion;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import alejandro.figueroa.entities.*;


public class HibernateUtils {

private static SessionFactory fabricaSesiones = null;
	
	public static SessionFactory obtenerFabricaSesiones() {
		
		if(fabricaSesiones == null) {
			Configuration configHibernate = new Configuration();
			
			configHibernate.configure();
			
			configHibernate.addAnnotatedClass(Empleado.class);
			configHibernate.addAnnotatedClass(Venta.class);
			
			fabricaSesiones = configHibernate.buildSessionFactory();
		}
		
		return fabricaSesiones;
	}
}
