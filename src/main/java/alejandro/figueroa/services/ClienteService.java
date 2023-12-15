package alejandro.figueroa.services;
import java.util.List;

import alejandro.figueroa.dao.*;
import alejandro.figueroa.entities.*;
public class ClienteService {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public Cliente obtenerPorId(Long id) {
		return clienteDAO.obtenerPorId(id);
	}
	
	public List<Cliente> obtenerTodos() {
		return clienteDAO.obtenerTodos();
	}
	public Boolean guardarCliente(Cliente c) {
		return clienteDAO.guardar(c);
	}

}
