/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam.reprografia.recursos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author josel
 */
public class DAODocumentosHistorial {
    		//HashMap: Los elementos que se insertan en el map no tienen un orden espec�fico. No acepta clave duplicadas ni valores null.
		//TreeMap: El mapa se ordena de forma "natural". Por ejemplo, si la clave son valores enteros los ordena de menor a mayor.
		//LinkedHasMap: Los elementos se insertan en el map en el orden de llegada, no sigue ninguna ordenaci�n, por ello realiza las b�squedas de forma m�s lenta que los dem�s.
		
                private static Connection conn;
		private ArrayList<Documento> listaHistorial = new ArrayList<Documento>();
                
		DAODocumentosHistorial(){
                    conn = ConexionBD.getConexion();
                    enlistarHistorialAlumnos(ConexionBD.queryHistorialDocumentosAlum());
                    enlistarHistorialProfesores(ConexionBD.queryHistorialDocumentosProf());
                    ConexionBD.cerrarConexionBD();
		}
                
                private void enlistarHistorialAlumnos(ResultSet rs) {
                    try {
                        while (rs.next()){ 
                            listaHistorial.add(new Documento(rs.getInt("numPaginas"), new Alumno(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("curso"))));
                        }
                    } 
                    catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }

                private void enlistarHistorialProfesores(ResultSet rs) {
                    try {
                        while (rs.next()){ 
                            listaHistorial.add(new Documento(rs.getInt("numPaginas"), new Profesor(rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1"),rs.getString("apellido2"),rs.getString("dpto"))));
                        }
                    } 
                    catch (SQLException ex) {
			System.out.println("Error en la ejecución SQL: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                
                public ArrayList<Documento> getHistorial(){
                    return this.listaHistorial;
                }
                
                public int insertarDocumentoProf(Documento documento, Profesor profesor) {
                    conn = ConexionBD.getConexion();
                    if (ConexionBD.queryInsertarDocumentoHistorialProf(documento, profesor) == 1) {
                        enlistarHistorialProfesores(ConexionBD.queryHistorialDocumentosProf());
                        ConexionBD.cerrarConexionBD();
                        return 1;  
                    }
                    else {
                        ConexionBD.cerrarConexionBD();
                        return 0;
                    }
                }

                public int insertarDocumentoAlum(Documento documento, Alumno alumno) {
                    conn = ConexionBD.getConexion();
                    if (ConexionBD.queryInsertarDocumentoHistorialAlum(documento, alumno) == 1) {
                        enlistarHistorialAlumnos(ConexionBD.queryHistorialDocumentosAlum());
                        ConexionBD.cerrarConexionBD();
                        return 1;  
                    }
                    else {
                        ConexionBD.cerrarConexionBD();
                        return 0;
                    }
                }
                
                public ArrayList<Documento> getListaHistorial(){
                    return this.listaHistorial;
                }
}
