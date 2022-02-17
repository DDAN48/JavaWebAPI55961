package com.educacionit.servicios;

import java.util.List;
import java.util.ListIterator;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.educacionit.entidades.Usuario;
import com.educacionit.implementaciones.mariadb.UsuarioImplmentacion;
@Path("/usuarios")
public class UsuarioControlador {

	private UsuarioImplmentacion implementacion = new UsuarioImplmentacion();
	
	
	@GET//envia por POST
	@Produces(MediaType.APPLICATION_JSON)//Responde JSON
	@Path("/listar")//path del end point
	public List<Usuario> listar() {
		return implementacion.listar();
		
	}
	
	@POST//envia por POST
	@Consumes (MediaType.APPLICATION_JSON)//Consume JSON
	@Produces(MediaType.APPLICATION_JSON)//Responde JSON
	@Path("/agregar")//path del end point
	public Response agregar(Usuario usuario) {
		
		 if(usuario==null) {
			 return Response.status(404).build();  
		 } 
		implementacion.guardar(usuario);
		return Response.ok(usuario).build();
	}
	
	
	@POST//envia por POST
	@Consumes (MediaType.APPLICATION_JSON)//Consume JSON
	@Produces(MediaType.APPLICATION_JSON)//Responde JSON
	@Path("/agregarLista")//path del end point
	public List<Usuario> agregarLista(List<Usuario> usuarios) {
		
		ListIterator<Usuario> it= usuarios.listIterator();
		
		while(it.hasNext()) {
			Usuario usuario= it.next();
			if(null!=implementacion.buscar(usuario.getCorreo())) {
				it.remove();
			}else {
				implementacion.guardar(usuario);
			}
			
		}
		return usuarios;
	}
	
	//agregar por formulario 
	
	@POST//envia por POST
	@Path("/agregarFormulario")//path del end point
	@Produces(MediaType.APPLICATION_JSON)//Responde JSON
	public Response agregarFormulario(@FormParam("correo")  String correo,@FormParam("clave") String clave) {
		Usuario usuario= new Usuario();
		usuario.setCorreo(correo);
		usuario.setClave(clave);
		
		if(null!=implementacion.buscar(usuario.getCorreo())) {
			
			return Response.ok("no guardado").build();
		}else {
			
			implementacion.guardar(usuario);
			return Response.ok(usuario).build();
		}
		
		}
		
		
	
	
	
	
		 
	
	@PUT 
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Usuario usuario) {
		 implementacion.guardar(usuario);
		return Response.ok().build();
		
	}
	
	@GET//envia por POST
	@Produces(MediaType.APPLICATION_JSON)//Responde JSON
	@Path("/buscar")//path del end point
	public Response buscarPorQP(@QueryParam("correo") String correo) {
		Usuario usuario= implementacion.buscar(correo);
		if(usuario==null) {
			 return Response.status(404).build(); 
			 
		 }
		return Response.ok(usuario).build();
		
	}
	
	@GET//envia por POST
	@Produces(MediaType.APPLICATION_JSON)//Responde JSON
	@Path("/buscar/{correo}")//path del end point
	public Response buscarPorURN(@PathParam("correo") String correo) {
		Usuario usuario= implementacion.buscar(correo);
		if(usuario==null) {
			 return Response.status(404).build(); 
			 
		 }
		
		return Response.ok(usuario).build();
		
	}
	
	@DELETE //envia por POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/eliminar")//path del end point
	public Response el(Usuario usuario) {
	implementacion.eliminar(usuario);

		return Response.ok("eliminado").build();
		
	}
	
	
	
}
