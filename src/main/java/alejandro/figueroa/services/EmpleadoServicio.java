package alejandro.figueroa.services;


import alejandro.figueroa.dao.VentaDAO;


public class EmpleadoServicio {
	
	private static VentaDAO empDAO;
	
	public EmpleadoServicio(){
		empDAO = new VentaDAO();
	}
	
	//public void persist(Empleado e) {
		//empDAO.openCurrentSessionwithTransaction();
		//empDAO.persist(e);
		//empDAO.closeCurrentSessionwithTransaction();
	//}
	 
	public void deleteById() {
		
	}
	public void getById() {
		
	}
	
}
