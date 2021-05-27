/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam.reprografia.recursos;

import java.sql.*;

/**
 *
 * @author josel
 */
public class ConexionBD {
    
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static String bd = "fotocopiadora";
    static String user = "fotocopiadora";
    static String password = "root";
    static String url = "jdbc:mysql://localhost/"+bd+"?serverTimezone=Europe/Madrid";
    
    public static Connection getConexion(){ //Método para conexion a la bd
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user, password);
        }
        catch(ClassNotFoundException ex){
            System.out.println("Imposible acceder al driver Mysql");		
        }
        catch(SQLException ex){
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
        }
        return conn;
    }
    
    public static ResultSet queryDocumentosProf(){ //Método para consultar datos de la tabla documentosprofesores
        conn = ConexionBD.getConexion();
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            rs = st.executeQuery("select * from documentosprofesores");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        return rs;
    }
    
    public static ResultSet queryDocumentosAlum(){  //Método para consultar datos de la tabla documentosalumnos
        conn = ConexionBD.getConexion();
        try{
            st = conn.createStatement();
            
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            rs = st.executeQuery("select * from documentosalumnos");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        return rs;
    }
    
    public static ResultSet queryHistorialDocumentosProf(){ //Método para consultar datos de las tabla historialprofesores
        conn = ConexionBD.getConexion();
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            rs = st.executeQuery("select * from historialprofesores");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        return rs;
    }
    
    public static ResultSet queryHistorialDocumentosAlum(){ //Método para consultar datos de las tabla historialalumnos
        conn = ConexionBD.getConexion();
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            rs = st.executeQuery("select * from historialalumnos");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        return rs;
    }
    
    public static int queryInsertarDocumentoProf(Documento documento,Profesor profesor){ //Método para insertar documentos en la tabla documentosprofesores
        Statement st = ConexionBD.st;
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            st.executeUpdate("insert into documentosprofesores (numPaginas, dni, nombre, apellido1, apellido2, dpto)"
                    + "values('"+documento.getNumPaginas()+"', '"+documento.getPersona().getDni()
                    +"', '"+profesor.getNombre()+"', '"+profesor.getApellido1()+"', '"+profesor.getApellido2()+"', '"+profesor.getDpto()+"')");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
            return 0;
	}
        return 1;
    }
    
    public static int queryInsertarDocumentoAlum(Documento documento, Alumno alumno){ //Método para insertar documentos en la tabla documentosalumnos
        Statement st = ConexionBD.st;
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            st.executeUpdate("insert into documentosalumnos (numPaginas, dni, nombre, apellido1, apellido2, curso)"
                    + "values('"+documento.getNumPaginas()+"', '"+documento.getPersona().getDni()
                    +"', '"+alumno.getNombre()+"', '"+alumno.getApellido1()+"', '"+alumno.getApellido2()+"', '"+alumno.getCurso()+"')");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
            return 0;
	}
        return 1;
    }
   
    public static int queryInsertarDocumentoHistorialProf(Documento documento, Profesor profesor){ //Método para insertar documentos en la tabla documentosalumnos
        Statement st = ConexionBD.st;
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            st.executeUpdate("insert into historialprofesores (id, numPaginas, dni, nombre, apellido1, apellido2, dpto)"
                    + "values('"+documento.getId()+"', '"+documento.getNumPaginas()+"', '"+documento.getPersona().getDni()
                    +"', '"+profesor.getNombre()+"', '"+profesor.getApellido1()+"', '"+profesor.getApellido2()+"', '"+profesor.getDpto()+"')");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
            return 0;
	}
        return 1;
    }
    
    public static int queryInsertarDocumentoHistorialAlum(Documento documento, Alumno alumno){ //Método para insertar documentos en la tabla documentosalumnos
        Statement st = ConexionBD.st;
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            st.executeUpdate("insert into historialalumnos (id, numPaginas, dni, nombre, apellido1, apellido2, curso)"
                    + "values('"+documento.getId()+"', '"+documento.getNumPaginas()+"', '"+documento.getPersona().getDni()
                    +"', '"+alumno.getNombre()+"', '"+alumno.getApellido1()+"', '"+alumno.getApellido2()+"', '"+alumno.getCurso()+"')");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
            return 0;
	}
        return 1;
    }
    
    public static int queryEliminarDocumentoProf(Documento documento){
        Statement st = ConexionBD.st;
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            st.executeUpdate("delete from documentosprofesores where id='"+documento.getId()+"'");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
            return 0;
	}
        return 1;
    }
    
    public static int queryEliminarDocumentoAlum(Documento documento){
        Statement st = ConexionBD.st;
        try{
            st = conn.createStatement();
        }
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
	}
        
        try{
            st.executeUpdate("delete from documentosalumnos where id='"+documento.getId()+"'");
        }
	catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
            return 0;
	}
        return 1;
    }
    
    public static int queryModificarDocumentoProf(Documento documento, Integer numPaginas, String dni, String nombre, String apellido1, String apellido2, String dpto){
        Statement st = ConexionBD.st;
        try{
            st = conn.createStatement();
        }
        catch(SQLException ex){
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
        }
        
        try{
            st.executeUpdate("update documentoprofesores set numPaginas = '"+numPaginas+"', dni = '"+dni+"', '"+nombre+"', '"+apellido1+"', '"+apellido2+"', '"+dpto+"' where id = '"+documento.getId()+"'");
        }
        catch(SQLException ex){
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
            return 0;
        }
        return 1;
    }
    
    public static void cerrarConexionBD(){
        try{
            rs.close();
            st.close();
            conn.close();
        }
        catch(SQLException ex){
            System.out.println("Error al cerrar la conexion con la BD: " + ex.getMessage());
        }
    }
}
