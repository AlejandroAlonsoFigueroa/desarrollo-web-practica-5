package alejandro.figueroa.configuracion;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import alejandro.figueroa.entities.Empleado;


public class HibernateUtils {

private static SessionFactory fabricaSesiones = null;
	
	public static SessionFactory obtenerFabricaSesiones() {
		
		if(fabricaSesiones == null) {
			Configuration configHibernate = new Configuration();
			
			configHibernate.configure();
			
			configHibernate.addAnnotatedClass(Empleado.class);
			
			fabricaSesiones = configHibernate.buildSessionFactory();
		}
		
		return fabricaSesiones;
	}
}
