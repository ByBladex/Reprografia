package dam.reprografia.recursos;

import java.util.LinkedHashMap;
import java.sql.*;

public class DAODocumentos {		
		//HashMap: Los elementos que se insertan en el map no tienen un orden espec�fico. No acepta clave duplicadas ni valores null.
		//TreeMap: El mapa se ordena de forma "natural". Por ejemplo, si la clave son valores enteros los ordena de menor a mayor.
		//LinkedHasMap: Los elementos se insertan en el map en el orden de llegada, no sigue ninguna ordenaci�n, por ello realiza las b�squedas de forma m�s lenta que los dem�s.
		
		public static LinkedHashMap<Integer, Documento> mapDocumentos;
                private static Connection conn;
		
		DAODocumentos(){
                    mapDocumentos = new LinkedHashMap<Integer, Documento>();
                    conn = ConexionBD.getConexion();
                    enlistarDocumentosProfesores(ConexionBD.queryDocumentosProf());
                    enlistarDocumentosAlumnos(ConexionBD.queryDocumentosAlum());
                    ConexionBD.cerrarConexionBD();
		}
		
                private void enlistarDocumentosProfesores(ResultSet rs) {
                    try {
                        while (rs.next()){ 
                            mapDocumentos.put(rs.getInt("id"), new Documento(rs.getInt("numPaginas"), new Profesor(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("dpto"))));
                        }
                    } 
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                
                private void enlistarDocumentosAlumnos(ResultSet rs) {
                    try {
                        while (rs.next()){ 
                            mapDocumentos.put(rs.getInt("id"), new Documento(rs.getInt("numPaginas"), new Alumno(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("curso"))));
                        }
                    } 
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
                        ex.printStackTrace();
                    }
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
