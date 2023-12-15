package alejandro.figueroa.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;


import alejandro.figueroa.dao.ClienteDAO;
import alejandro.figueroa.dao.VentaDAO;
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
		//EmpleadoServicio emp = new EmpleadoServicio();
		//List<Venta> ventas = new ArrayList();
		
		
		
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
		//Principal p = new Principal();
		//p.obtenerVenta();
		
		VentaDAO vDAO = new VentaDAO();
		
		
		/*Venta v = vDAO.obtenerPorId(2l);
		
		System.out.println(v);
		Venta vEj = new Venta();
		vEj.setDescripcion("fdsfds");
		vEj.setIdventa(3l);
		vEj.setTotal(342);
		 String json = new Gson().toJson(v);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);*/
		
		ClienteDAO cDAO = new ClienteDAO();
		
		Cliente c = cDAO.obtenerPorId(7l);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(c);
		//String json = new Gson().toJson(c);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
