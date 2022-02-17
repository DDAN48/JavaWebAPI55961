package com.educacionit.RestClient;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// URL para contruir el proyecto,ver que ;a URi termina en servicios , en ese
		// punto
		// tenemos disponibles los servicios de INICIAL Y USUARIO
		URI URL_SERVICIOS = UriBuilder.fromUri("http://localhost:8081/Rest").build();

		// creamos el cliente
		Client cliente = ClientBuilder.newClient();

		// LA URL PARA EL SERVICIO USUARIO del CLIENTE , es decir el cliente accede a
		// travez de ese link a
		// los servicios, el WebTarget es como el FECHT de javascript
		WebTarget URL_USUSARIOS = cliente.target(URL_SERVICIOS).path("usuarios");
		WebTarget URL_INICIAL = cliente.target(URL_SERVICIOS);
		
		Usuario usuario = new Usuario();
		usuario.setCorreo("user28@gmail.com");
		//usuario.setClave("12345");

		// agregar usuario ,se envia la petecion usando la url que contiene agregar , se
		// usa
		// la libreria que permite enviar JSON
       
		Response respuestaAgregar = URL_USUSARIOS.path("agregar").request(MediaType.APPLICATION_JSON_PATCH_JSON_TYPE)//se recibira una respuesta en formato Jason
				.post(Entity.entity(usuario, MediaType.APPLICATION_JSON_PATCH_JSON_TYPE));//se envia una entidad usuario transformada en formato JSON 

		Response respuestaUsuarioURN = URL_USUSARIOS.path("buscar").path("user28@gmail.com").request(MediaType.APPLICATION_JSON_PATCH_JSON_TYPE).get();
		//Response inicial =URL_INICIAL.request().get();
		
		System.out.println(respuestaUsuarioURN);
		
	}
}
