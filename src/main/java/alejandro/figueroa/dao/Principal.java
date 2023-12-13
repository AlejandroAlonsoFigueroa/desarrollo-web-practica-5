package alejandro.figueroa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import alejandro.figueroa.configuracion.HibernateUtils;
import alejandro.figueroa.entities.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		SessionFactory fabricaSesiones = HibernateUtils.obtenerFabricaSesiones();
		
		Session sesionHibernate = fabricaSesiones.openSession();
		
		Transaction t = null;
		
		// Quiero solamente el nombre de la cancion y el nombre del autor
		try {
			t = sesionHibernate.beginTransaction();
			
			Empleado emp = new Empleado();
			
			emp.setNombre("Ale");
			emp.setApellidos("Alonso Figueroa");
			
			sesionHibernate.save(emp);
			
			t.commit();
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
	
		
		

	}

}
