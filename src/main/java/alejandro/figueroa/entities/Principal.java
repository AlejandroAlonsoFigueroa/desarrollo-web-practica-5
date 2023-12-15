package alejandro.figueroa.entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import alejandro.figueroa.configuracion.HibernateUtils;

public class Principal {

	public static void main(String[] args) {
	        try {
	            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	            Transaction t = session.beginTransaction();

	            /*Venta v = new Venta();
	            java.util.Date fechaT = new java.util.Date();
	            v.setFecha(new Date(fechaT.getTime()));
	            Cliente c = new Cliente();
	            c.setIdCliente(1L);
	            //v.setCliente(1L);
	            v.setCliente(c);
	            v.setTotal(new BigDecimal(20));   */
	            java.util.Date fechaT = new java.util.Date();
	            List<Venta> ventas = new ArrayList();
	            
	            Venta v = new Venta();
	            v.setTotal(123);
	            v.setDescripcion("Hola");
	            ventas.add(v);
	            
	            Cliente c = new Cliente();
	            c.setNombre("fsfdsds");
	            c.setRfc("134");
	            c.setVentas(ventas);
	            
	            v.setCliente(c);
	            
	            session.save(v);            

	            
	            
	          
	            
	            t.commit();
	            session.close();
	            
	            System.out.println("Termino");
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	    }
	
}
