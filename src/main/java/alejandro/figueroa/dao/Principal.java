package alejandro.figueroa.dao;
import alejandro.figueroa.entities.*;

public class Principal {

	public static void main(String[] args) {
		EmpleadoDAO empDAO = new EmpleadoDAO();
		
		Empleado e = new Empleado();
		e.setApellidos("Figueroa jejej");
		e.setNombre("Alejandro ");
		
		empDAO.openCurrentSessionwithTransaction();
		empDAO.persist(e);
		empDAO.closeCurrentSessionwithTransaction();
	}

}
