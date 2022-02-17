package com.educacionit.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/inicial")
public class Inicial {
	
	private static List<String> nombres= new ArrayList<String>();
	
	 
	@GET
	@Path("/holamundo")
	@Produces(MediaType.TEXT_PLAIN)
	public String holaMundo() {
		return "<h1>Hola Mundo</h1>";
	}
	
	
	
	
	@POST//envia por POST
	@Consumes (MediaType.APPLICATION_JSON)//Consume JSON
	@Produces(MediaType.APPLICATION_JSON)//Responde JSON
	@Path("/agregar")//path del end point
	public Response agregar(String nombre) {
		
		
		if(nombre!="") {
			nombres.add(nombre);
			return Response.ok().build();// responde con el objeto construido
			
		}
		return Response.ok(406).build();// responde con el objeto construido
		
	}
	
	@GET//envia por POST
	@Produces(MediaType.APPLICATION_JSON)//Responde JSON
	@Path("/listar")//path del end point
	public Response listar(String nombre) {
		return Response.ok(nombres).build();// retorna una lista 
		
	}

	
	

}
