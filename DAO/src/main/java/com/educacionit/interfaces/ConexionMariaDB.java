package com.educacionit.interfaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface ConexionMariaDB {

	default Connection getConexion() {
		//
		Connection conexion = null;
		Properties propiedades = new Properties();
		try {
			// .jar
			propiedades.load(new FileInputStream(
					new File("src" + File.separator + "resources" + File.separator + "database.properties")));
			String URL = propiedades.getProperty("URL");
			String USER = propiedades.getProperty("USER");
			String PASS = propiedades.getProperty("PASS");
			
			/*String URL = "jdbc:mysql://localhost:3306/javawebApi559961";
			String USER = "root";
			String PASS = "123456";
			String driver="com.mysql.cj.jdbc.Driver";*/
					
			
			
			
			
		Class.forName(propiedades.getProperty("driver"));
			//	Class.forName(driver);
			conexion = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();// no encuentro
		} catch (IOException e) {
			e.printStackTrace(); // archivo corrupto bloqueado
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conexion;

	}

}
