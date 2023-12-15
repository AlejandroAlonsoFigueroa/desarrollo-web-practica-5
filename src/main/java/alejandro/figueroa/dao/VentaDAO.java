package alejandro.figueroa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import alejandro.figueroa.configuracion.HibernateUtils;
import alejandro.figueroa.entities.Venta;

public class VentaDAO {
	
	public void guardar(Venta v) {
		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
                        
            session.save(v);             
            
            t.commit();
            session.close();
            
            System.out.println("Termino");
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	public void eliminar(Venta v) {
		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
                                    
            session.remove(v);
            t.commit();
            session.close();
            
            System.out.println("Termino");
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	public void actualizar(Venta v) {
		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
                                    
            session.update(v);
            t.commit();
            session.close();
            
            System.out.println("Termino");
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	public Venta obtenerPorId(Long id) {
		Venta v  = null;
		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
                                    
            v = session.get(Venta.class, id);
            t.commit();
            session.close();
            
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return v;
	}
	
	
}
