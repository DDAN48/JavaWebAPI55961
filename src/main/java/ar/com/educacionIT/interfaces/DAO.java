package ar.com.educacionIT.interfaces;

import java.util.ArrayList;

public interface DAO <E,K>{


	E buscar(K k);
	
	Boolean insertar (E e);
	
	Boolean eliminar (E e);
	
	Boolean actualizar (E e);
	
	ArrayList<E> listar(); 
}
