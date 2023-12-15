package alejandro.figueroa.services;


import alejandro.figueroa.dao.EmpleadoDAO;


public class EmpleadoServicio {
	
	private static EmpleadoDAO empDAO;
	
	public EmpleadoServicio(){
		empDAO = new EmpleadoDAO();
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
