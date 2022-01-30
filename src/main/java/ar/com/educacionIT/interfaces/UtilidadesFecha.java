package ar.com.educacionIT.interfaces;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface UtilidadesFecha {
	
	String FECHA_SQL="yyyy-MM-dd";
	SimpleDateFormat FORMATO_FECHA_SQL = new SimpleDateFormat(FECHA_SQL);
	
	
	static String getFechaAString(Date fecha) {
		return FORMATO_FECHA_SQL.format(fecha);
	}
	
	static Date getStringAFecha(String fecha) throws ParseException {
		
		return FORMATO_FECHA_SQL.parse(fecha);
	}

}
