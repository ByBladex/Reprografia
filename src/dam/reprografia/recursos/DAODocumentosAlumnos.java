package dam.reprografia.recursos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author josel
 */
public class DAODocumentosAlumnos {
    		//HashMap: Los elementos que se insertan en el map no tienen un orden espec�fico. No acepta clave duplicadas ni valores null.
		//TreeMap: El mapa se ordena de forma "natural". Por ejemplo, si la clave son valores enteros los ordena de menor a mayor.
		//LinkedHasMap: Los elementos se insertan en el map en el orden de llegada, no sigue ninguna ordenaci�n, por ello realiza las b�squedas de forma m�s lenta que los dem�s.
		
		public static ArrayList<Documento> mapDocumentosAlumnos;
                private static Connection conn;
                
		DAODocumentosAlumnos(){
                    mapDocumentosAlumnos = new ArrayList<Documento>();
                    conn = ConexionBD.getConexion();
                    enlistarDocumentosAlumnos(ConexionBD.queryDocumentosAlum());
		}
                
                private static void enlistarDocumentosAlumnos(ResultSet rs) {
                    try {
                        while (rs.next()){ 
                            mapDocumentosAlumnos.add(new Documento(rs.getInt("id"), rs.getInt("numPaginas"), new Alumno(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("curso"))));
                        }
                    } 
                    catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                
		public static Cola obtenerColaAlumnos() {
			Cola colaAlumnos = Cola.crearCola();
			for(Documento valor : mapDocumentosAlumnos) {
				if(valor.getPersona() instanceof Alumno)
					colaAlumnos.insertarCola(valor);
			}
			return colaAlumnos;
		}
                
                public void actualizarDAO(){
                    mapDocumentosAlumnos.clear();
                    enlistarDocumentosAlumnos(ConexionBD.queryDocumentosAlum());
                }
                
                public int insertarDocumento(Documento documento, Alumno alumno) {
                    conn = ConexionBD.getConexion();
                    if (ConexionBD.queryInsertarDocumentoAlum(documento, alumno) == 1) {
                        enlistarDocumentosAlumnos(ConexionBD.queryDocumentosAlum());
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
                        if (ConexionBD.queryEliminarDocumentoAlum(documento) == 1) {
                            enlistarDocumentosAlumnos(ConexionBD.queryDocumentosAlum());
                            ConexionBD.cerrarConexionBD();
                            return 1;
                        }
                        else {
                            ConexionBD.cerrarConexionBD();
                            return 0;
                        }
                }
                
                public ArrayList<Documento> getDocumentos(){
                    return this.mapDocumentosAlumnos;
                }
}
