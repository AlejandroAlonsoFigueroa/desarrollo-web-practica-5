package alejandro.figueroa.services;
import java.util.List;

import alejandro.figueroa.dao.*;
import alejandro.figueroa.entities.Venta;
public class VentaService {

	private VentaDAO ventaDAO = new VentaDAO();
	
	
	public Venta obtenerPorId(Long id) {
		return ventaDAO.obtenerPorId(id);
	}
	
	public List<Venta> obtenerTodas() {
		//return ventaDAO.obtenerPorId(id);
		return null;
	}
}
