package alejandro.figueroa.servlets;


import alejandro.figueroa.entities.Venta;
import alejandro.figueroa.services.*;
import java.io.BufferedReader;
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
		String respuesta = "";
		String requestBody =obtenerRequestBody(request);
		ObjectMapper objMapper = new ObjectMapper();
		Venta v = objMapper.readValue(requestBody, Venta.class);
		
		Boolean guardadoCorrectamente = ventaService.guardarVenta(v);
		
		System.out.println(v);
		
		if(guardadoCorrectamente.booleanValue()) {
			respuesta = "{\"respuesta\" : \"La venta se ha guardado correctamente\"}";
		}else {
			respuesta = "{\"respuesta\" : \"Algo ha salido mal, la venta no se guardo\"}";
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(respuesta);
	}

	private String obtenerRequestBody(HttpServletRequest request) {
		String cuerpoPeticion = "";
		try {
			StringBuilder buffer = new StringBuilder();
		    BufferedReader reader = request.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        buffer.append(line);
		        buffer.append(System.lineSeparator());
		    }
		    
		    cuerpoPeticion = buffer.toString();
		    
		}catch(IOException e) {
			e.printStackTrace();
		}
		return cuerpoPeticion;
	}
}
