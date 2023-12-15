package alejandro.figueroa.servlets;

import alejandro.figueroa.entities.Venta;
import alejandro.figueroa.services.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private VentaService ventaService = new VentaService();
    
    public VentaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idVenta = null;
		String respuesta = "";
		String idParam = request.getParameter("idVenta");
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
	
		if(idParam != null) {
			idVenta = Long.parseLong(idParam);
			Venta v = ventaService.obtenerPorId(idVenta);
			respuesta = ow.writeValueAsString(v);
		}else {
			List<Venta> ventas = ventaService.obtenerTodas();
			respuesta = ow.writeValueAsString(ventas);
		}	
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(respuesta);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
