package alejandro.figueroa.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import alejandro.figueroa.configuracion.HibernateUtils;
import alejandro.figueroa.entities.Venta;
import alejandro.figueroa.entities.*;
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
	
	public static void main(String[] args) {
		//Venta v = obtenerPorId(2l);
		//System.out.println(v.getCliente().getNombre());
		
		Venta v  = new Venta();
		v.setDescripcion("Mi venta otra jejeej");
		v.setTotal(534);
		
		//Cliente c = new Cliente();
		//c.setNombre("Ale");
		//c.setRfc("RFC-FALSO");
		ClienteDAO cDAO = new ClienteDAO();
		Cliente c = cDAO.obtenerPorId(11l);
		
		v.setCliente(c);
		
		//guardar(v);
	}
	// Se trae la venta y su respectivo y obligatorio cliente
	// Para guardar igual es obligatorio el cliente, ni modo que no tenga no, si no quien compró
	// Va, si esta guardando el cliente cuando no esta en transient
}
