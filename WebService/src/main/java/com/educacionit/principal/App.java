package com.educacionit.principal;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.xml.ws.Endpoint;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.mariadb.UsuarioImplmentacion;
import com.educacionit.interfaces.UtilidadesFecha;
import com.educacionit.servicios.ServicioBasico;
import com.educacionit.servicios.UsuarioServicio;

public class App {

	public static void main(String[] args) throws ParseException {
	// Endpoint.publish("http://localhost:8089/servicio/suma", new ServicioBasico());
		
		

		Endpoint.publish("http://localhost:8081/servicio/usuario2", new UsuarioServicio());
	}
     
}
