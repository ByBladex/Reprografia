package dam.reprografia.recursos;

import java.sql.*;
import java.util.ArrayList;

public class DAODocumentosProfesores {		
		//HashMap: Los elementos que se insertan en el map no tienen un orden espec�fico. No acepta clave duplicadas ni valores null.
		//TreeMap: El mapa se ordena de forma "natural". Por ejemplo, si la clave son valores enteros los ordena de menor a mayor.
		//LinkedHasMap: Los elementos se insertan en el map en el orden de llegada, no sigue ninguna ordenaci�n, por ello realiza las b�squedas de forma m�s lenta que los dem�s.
		
		public static ArrayList<Documento> mapDocumentosProfesores;
                private static Connection conn;
		
		DAODocumentosProfesores(){
                    mapDocumentosProfesores = new ArrayList<Documento>();
                    conn = ConexionBD.getConexion();
                    enlistarDocumentosProfesores(ConexionBD.queryDocumentosProf());
		}
		
                private static void enlistarDocumentosProfesores(ResultSet rs) {
                    try {
                        while (rs.next()){ 
                            mapDocumentosProfesores.add(new Documento(rs.getInt("id"), rs.getInt("numPaginas"), new Profesor(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("dpto"))));
                        }
                    } 
		catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }

		public static Cola obtenerColaProfesores() {
	        Cola colaProfesores = Cola.crearCola();
	        for (Documento valor : mapDocumentosProfesores) {
	           if(valor.getPersona() instanceof Profesor)
	        	   colaProfesores.insertarCola(valor);
	        }
	        return colaProfesores;
	    }
                
            public void actualizarDAO(){
                mapDocumentosProfesores.clear();
                enlistarDocumentosProfesores(ConexionBD.queryDocumentosProf());
            }
            
                
                public int insertarDocumento(Documento documento, Profesor profesor) {
                    conn = ConexionBD.getConexion();
                    if (ConexionBD.queryInsertarDocumentoProf(documento, profesor) == 1) {
                        enlistarDocumentosProfesores(ConexionBD.queryDocumentosProf());
                        ConexionBD.cerrarConexionBD();
                        return 1;  
                    }
                    else {
                        ConexionBD.cerrarConexionBD();
                        return 0;
                    }
                }
                
                public int eliminarDocumento(Documento documento) {
                        // TODO Auto-generated method stub
                        conn = ConexionBD.getConexion();
                        if (ConexionBD.queryEliminarDocumentoProf(documento) == 1) {
                            enlistarDocumentosProfesores(ConexionBD.queryDocumentosProf());
                            ConexionBD.cerrarConexionBD();
                            return 1;
                        }
                        else {
                            ConexionBD.cerrarConexionBD();
                            return 0;
                        }
                }
                
                public ArrayList<Documento> getDocumentos(){
                    return this.mapDocumentosProfesores;
                }
}
