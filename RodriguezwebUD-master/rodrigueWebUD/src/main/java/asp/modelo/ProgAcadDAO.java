package asp.modelo;

import java.util.ArrayList;

public class ProgAcadDAO {
	public static ArrayList<ProgAcad> lista_P = new ArrayList<ProgAcad>();

	public static void cargaDatos() {
		if(lista_P.isEmpty()) {
			System.out.println("Lista vacia");
			lista_P.add( new ProgAcad(10, "Ingeniería de Sistemas"));
			lista_P.add( new ProgAcad(20, "Ingeniería de Industrial"));
			lista_P.add( new ProgAcad(30, "Ingeniería de Telemática"));
			lista_P.add( new ProgAcad(40, "Ingeniería de Electronica"));
			lista_P.add( new ProgAcad(50, "Derecho"));
		
		}
		
	}
}


//Autor: Jerferson David Rodriguez Guarnizo