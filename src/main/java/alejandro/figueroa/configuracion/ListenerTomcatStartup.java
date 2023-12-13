package alejandro.figueroa.configuracion;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerTomcatStartup implements ServletContextListener{
	

	public void contextInitialized(ServletContextEvent sce) {
		// Acá podría inicializar hibernate
		System.out.println("A ver si es cierto jejej");
		
	}
}

