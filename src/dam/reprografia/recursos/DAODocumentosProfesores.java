package dam.reprografia.recursos;

import java.util.LinkedHashMap;
import java.sql.*;

public class DAODocumentosProfesores {		
		//HashMap: Los elementos que se insertan en el map no tienen un orden espec�fico. No acepta clave duplicadas ni valores null.
		//TreeMap: El mapa se ordena de forma "natural". Por ejemplo, si la clave son valores enteros los ordena de menor a mayor.
		//LinkedHasMap: Los elementos se insertan en el map en el orden de llegada, no sigue ninguna ordenaci�n, por ello realiza las b�squedas de forma m�s lenta que los dem�s.
		
		public static LinkedHashMap<Integer, Documento> mapDocumentosProfesores;
                private static Connection conn;
		
		DAODocumentosProfesores(){
                    mapDocumentosProfesores = new LinkedHashMap<Integer, Documento>();
                    conn = ConexionBD.getConexion();
                    enlistarDocumentosProfesores(ConexionBD.queryDocumentosProf());
                    ConexionBD.cerrarConexionBD();
		}
		
                private void enlistarDocumentosProfesores(ResultSet rs) {
                    try {
                        while (rs.next()){ 
                            mapDocumentosProfesores.put(rs.getInt("id"), new Documento(rs.getInt("numPaginas"), new Profesor(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("dpto"))));
                        }
                    } 
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }

		public static Cola obtenerColaProfesores() {
	        Cola colaProfesores = Cola.crearCola();
	        for (Documento valor : mapDocumentosProfesores.values()) {
	           if(valor.getPersona() instanceof Profesor)
	        	   colaProfesores.insertarCola(valor);
	        }
	        return colaProfesores;
	    }
}
