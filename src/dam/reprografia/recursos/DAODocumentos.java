package dam.reprografia.recursos;

import java.util.LinkedHashMap;

public class DAODocumentos {		
		//HashMap: Los elementos que se insertan en el map no tienen un orden espec�fico. No acepta clave duplicadas ni valores null.
		//TreeMap: El mapa se ordena de forma "natural". Por ejemplo, si la clave son valores enteros los ordena de menor a mayor.
		//LinkedHasMap: Los elementos se insertan en el map en el orden de llegada, no sigue ninguna ordenaci�n, por ello realiza las b�squedas de forma m�s lenta que los dem�s.
		
		public static LinkedHashMap<Integer, Documento> mapDocumentos = new LinkedHashMap<Integer, Documento>();
		
		DAODocumentos(){
	        this.mapDocumentos.put(1, new Documento(35, new Profesor("65148956L", "Amelia", "Sanchez", "Perez", Dpto.HISTORIA)));
	        this.mapDocumentos.put(2, new Documento(50, new Alumno("56895146J", "Jaime", "Gallego", "Herrera", Curso.PRIMEROBACH)));
	        this.mapDocumentos.put(3, new Documento(10, new Alumno("23156849F", "Luis", "Lopez", "Hortega", Curso.SEGUNDODAM)));
	        this.mapDocumentos.put(4, new Documento(10, new Alumno("15487695A", "Andres", "Garcia", "Fernandez", Curso.PRIMERODAM)));
	        this.mapDocumentos.put(5, new Documento(20, new Profesor("51648957K", "Carmen", "Jimenez", "Hurtado",Dpto.PLASTICA)));
		}
		

		public static Cola obtenerColaProfesores() {
	        Cola colaProfesores = Cola.crearCola();
	        for (Documento valor : mapDocumentos.values()) {
	           if(valor.getPersona() instanceof Profesor)
	        	   colaProfesores.insertarCola(valor);
	        }
	        return colaProfesores;
	    }
		
		public static Cola obtenerColaAlumnos() {
			Cola colaAlumnos = Cola.crearCola();
			for(Documento valor : mapDocumentos.values()) {
				if(valor.getPersona() instanceof Alumno)
					colaAlumnos.insertarCola(valor);
			}
			return colaAlumnos;
		}
}