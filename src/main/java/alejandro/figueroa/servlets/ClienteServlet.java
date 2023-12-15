package alejandro.figueroa.servlets;
import alejandro.figueroa.entities.Cliente;

import alejandro.figueroa.services.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private ClienteService clienteService = new ClienteService();
	
    public ClienteServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idCliente = null;
		String respuesta = "";
		String idParam = request.getParameter("idCliente");
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		if(idParam != null) {
			idCliente = Long.parseLong(idParam);
			Cliente c = clienteService.obtenerPorId(idCliente);
			respuesta = ow.writeValueAsString(c);
		}else {
			List<Cliente> clientes = clienteService.obtenerTodos();
			respuesta = ow.writeValueAsString(clientes);
		}
		
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(respuesta);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
