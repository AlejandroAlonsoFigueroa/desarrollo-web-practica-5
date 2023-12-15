package alejandro.figueroa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import alejandro.figueroa.configuracion.HibernateUtils;
import alejandro.figueroa.entities.Cliente;


public class ClienteDAO {

	public  Cliente obtenerPorId(Long id) {
		Cliente c  = null;
		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
                                    
            c = session.get(Cliente.class, id);
            t.commit();
            session.close();
            
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return c;
	}
	
	public  List<Cliente> obtenerTodos() {
		List<Cliente> clientes  = new ArrayList<Cliente>();
		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
                                    
            Query<Cliente> consultaClientes = session.createQuery("from Cliente", Cliente.class);
            
            clientes = consultaClientes.getResultList();
            
            t.commit();
            session.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return clientes;
	}
	
	public  void guardar(Cliente c) {
		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
                        
            session.save(c);             
            
            t.commit();
            session.close();
            
            System.out.println("Termino");
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	//detached
	
	/*public static void main(String[] args) {
		Cliente c = new Cliente();
		c.setNombre("Alejandro Figueroa");
		c.setRfc("RFC-123");
		//guardar(c);
		// Para clientes no mas el guardar y el obtener por id
		
		Cliente cOb = obtenerPorId(7l);
		
		List<Venta> ventas = cOb.getVentas();
		
		for(Venta v: ventas) {
			System.out.println(v);
		}
		
	}*/
	//El dao ya inserta clientes y obtiene el cliente con todas sus ventas
}



