/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam.reprografia.recursos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

/**
 *
 * @author josel
 */
public class DAODocumentosAlumnos {
    		//HashMap: Los elementos que se insertan en el map no tienen un orden espec�fico. No acepta clave duplicadas ni valores null.
		//TreeMap: El mapa se ordena de forma "natural". Por ejemplo, si la clave son valores enteros los ordena de menor a mayor.
		//LinkedHasMap: Los elementos se insertan en el map en el orden de llegada, no sigue ninguna ordenaci�n, por ello realiza las b�squedas de forma m�s lenta que los dem�s.
		
		public static LinkedHashMap<Integer, Documento> mapDocumentosAlumnos;
                private static Connection conn;
		
		DAODocumentosAlumnos(){
                    mapDocumentosAlumnos = new LinkedHashMap<Integer, Documento>();
                    conn = ConexionBD.getConexion();
                    enlistarDocumentosAlumnos(ConexionBD.queryDocumentosAlum());
                    ConexionBD.cerrarConexionBD();
		}
                
                private void enlistarDocumentosAlumnos(ResultSet rs) {
                    try {
                        while (rs.next()){ 
                            mapDocumentosAlumnos.put(rs.getInt("id"), new Documento(rs.getInt("numPaginas"), new Alumno(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("curso"))));
                        }
                    } 
                    catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                
                		
		public static Cola obtenerColaAlumnos() {
			Cola colaAlumnos = Cola.crearCola();
			for(Documento valor : mapDocumentosAlumnos.values()) {
				if(valor.getPersona() instanceof Alumno)
					colaAlumnos.insertarCola(valor);
			}
			return colaAlumnos;
		}
}
