package ar.com.educacionIT.implementaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import ar.com.educacionIT.entidades.Usuario;
import ar.com.educacionIT.interfaces.ConexionMariaDB;
import ar.com.educacionIT.interfaces.DAO;
import ar.com.educacionIT.interfaces.UtilidadesFecha;

public class Usuarioimplementacion implements DAO<Usuario, String>, ConexionMariaDB {

	private PreparedStatement psBuscar;
	private PreparedStatement psInsertar;
	private PreparedStatement psEliminar;
	private PreparedStatement psActualizar;
	private PreparedStatement psListar;
	private final String KEY = "JavaWebAPI";
			
			
	
	
	
	
	@Override
	public Usuario buscar(String correo) {
	Usuario usuario = null;
	String query = "select correo , cast(aes_decrypt(clave,?) as char(100)) as clave ,fechaActualizacion,fechaCreacion from usuarios where correo= ?";
	
	
	try {
		psBuscar = getConexion().prepareStatement(query);
		psBuscar.setString(1, KEY);
		psBuscar.setString(2, correo);
		ResultSet resultado=psBuscar.executeQuery();
		
	if(resultado.next()) {
		
		usuario=new Usuario();
		usuario.setCorreo(correo);
		usuario.setClave(resultado.getString("clave"));
		usuario.setFechaActualizacion(UtilidadesFecha.getStringAFecha(resultado.getString("fechaActualizacion")));
		usuario.setFechaCreacion(UtilidadesFecha.getStringAFecha(resultado.getString("fechaCreacion")));  
		//usuario.setFechaActualizacion(resultado.getString("fechaActualizacion"));
		
	}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return usuario;
	}

	@Override
	public Boolean insertar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean actualizar(Usuario e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
