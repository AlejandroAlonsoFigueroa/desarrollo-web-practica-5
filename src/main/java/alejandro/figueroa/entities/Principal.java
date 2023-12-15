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

public  class Principal {

	// La entidad dueña de la relacion hace que se intente guardar en cascada
	public static void main(String[] args) {
	        
		//guardarAlgo();
		//obtenerVenta();
		//VentaDAO vdao = new VentaDAO();
		
	}
	
	
	
	// quitar los unique de guardado
	public void guardarAlgo() {
		
		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            Venta v = new Venta();
            v.setTotal(123);
            v.setDescripcion("dfsdfds");
          
            
            Cliente c = new Cliente();
            c.setNombre("fksjflksdfs");
            c.setRfc("134");
            
            
            v.setCliente(c);
            
            session.save(v);             
          
            
            t.commit();
            session.close();
            
            System.out.println("Termino");
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	// ager lazy cascada
	public void obtenerVenta() {

		try {
            Session session = HibernateUtils.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            
            Venta v = session.get(Venta.class, 2l);
          
            System.out.println(v);
            
            t.commit();
            session.close();
            
            System.out.println("Termino");
            
            //CUANDO ES LAZY DOS CONSULTAS, CUANDO ES EAGER UNA SOL CONSULTA
            // O SEA SI ESTA AFECTANDO ACA
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
