package ar.com.educacionIT.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConexionMariaDB {
	
	//coneccion por defecto ,tipo connection 
	
	//tambien usaremos un properties para guardar todas las credenciales de la conexion
	
	default Connection getConexion() {
		
		//incializa la Connection
		
		
		
		Connection conexion=null;
		Properties propiedades = new Properties();
		
		
		// instanciar la conexion a travez del metodo estatico driverManager
		
		try {
			//cargamos el archivo propiedades leyendo la ruta 
		    propiedades.load( new FileInputStream(new File("src"+File.separator+"resources"+File.separator +"database.properties")));
			String URL=propiedades.getProperty("URL");
			String USER=propiedades.getProperty("USER");
			String PASS=propiedades.getProperty("PASS","123456");//SI NO ENCUENTRA LA CLAVE EN properties puede usar la clave por defecto ingresada 123456
					
			conexion = DriverManager.getConnection(URL,USER,PASS);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return conexion;}

}
