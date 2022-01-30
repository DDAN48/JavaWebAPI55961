package ar.com.educacionIT.DAO3;

import ar.com.educacionIT.entidades.Usuario;
import ar.com.educacionIT.implementaciones.Usuarioimplementacion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Usuario usuario = null;
    	
    	Usuarioimplementacion imple = new Usuarioimplementacion();
    
    	usuario=imple.buscar("user2@gmail.com");
    	System.out.println(usuario);
    	
    	
    }
}
