package alejandro.figueroa.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import alejandro.figueroa.services.*;
import alejandro.figueroa.entities.*;
/**
 * Servlet implementation class EmpleadoServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//A vr
		EmpleadoServicio emp = new EmpleadoServicio();
		List<Venta> ventas = new ArrayList();
		
		
		/*Venta v = new Venta();
		v.setMonto(new BigDecimal(123));
		//v.setEmp(e);
	
		ventas.add(v);
		
		
		Empleado e = new Empleado(ventas);
		e.setNombre("Ale servlet");
		e.setApellidos("servlets jklfksdf");
		e.setVentas(ventas);
		emp.persist(e);
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
