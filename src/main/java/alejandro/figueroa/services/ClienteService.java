package alejandro.figueroa.services;
import alejandro.figueroa.dao.*;
import alejandro.figueroa.entities.*;
public class ClienteService {
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public Cliente obtenerPorId(Long id) {
		return clienteDAO.obtenerPorId(id);
	}

}
