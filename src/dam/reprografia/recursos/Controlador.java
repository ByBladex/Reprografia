package dam.reprografia.recursos;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador {
	
	static GestionColas gestionColas = new GestionColas();
        DAODocumentosProfesores daoP = new DAODocumentosProfesores();
        DAODocumentosAlumnos daoA = new DAODocumentosAlumnos();

	Vista vista = new Vista();
	
	public void ejecutar() throws InterruptedException {
		Integer opcionMenu=0, opcionSubMenu=0;
		while(opcionMenu<4) {
			opcionMenu = vista.cargarMenu("Fotocopiar el siguiente trabajo","Consultar historial fotocopias","Listar todo");
			
			switch (opcionMenu) {
			case 1: gestionColas.fotocopiar();
				break;
			case 2: while(opcionSubMenu<4) {
						opcionSubMenu = vista.cargarSubMenu("Individual por DNI","Todos los usuarios y trabajos ordenados por DNI","Todos los usuarios y trabajos ordenados por nombres");
						switch(opcionSubMenu) {
						case 1: gestionColas.buscarDni(vista.dni());
							break;
						case 2: gestionColas.ordenarDni();
							break;
						case 3: gestionColas.ordenarNombre();
							break;
						}
				}
				break;
			case 3: gestionColas.mostrarTodo();
				break;
			}
		}
	}
    public static void cargarTablasProfesores(JTable tabla){
        DefaultTableModel modeloTabla = new DefaultTableModel();
        
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Num Paginas");
        modeloTabla.addColumn("Dni");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido1");
        modeloTabla.addColumn("Apellido2");
        modeloTabla.addColumn("Departamento");
        
        String[] registros = new String[7];
        
        for(Documento documento: gestionColas.getDocumentosProfesores()){
            registros[0] =  documento.getId().toString();
            registros[1] = documento.getNumPaginas().toString();
            registros[2] = documento.getPersona().getDni();
            registros[3] = documento.getPersona().getNombre();
            registros[4] = documento.getPersona().getApellido1();
            registros[5] = documento.getPersona().getApellido2();
            if(documento.getPersona() instanceof Profesor){
                Profesor hijo = (Profesor) documento.getPersona();
                registros[6] = hijo.getDpto(); //intentando acceder a1 curso de alumno
            }
            modeloTabla.addRow(registros);
        };
            tabla.setModel(modeloTabla);
    }

    public static void cargarTablasAlumnos(JTable tabla){
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Num Paginas");
        modeloTabla.addColumn("Dni");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido1");
        modeloTabla.addColumn("Apellido2");
        modeloTabla.addColumn("Curso");
        
        String[] registros = new String[7];
        
        for(Documento documento: gestionColas.getDocumentosAlumnos()){

            registros[0] =  documento.getId().toString();
            registros[1] = documento.getNumPaginas().toString();
            registros[2] = documento.getPersona().getDni();
            registros[3] = documento.getPersona().getNombre();
            registros[4] = documento.getPersona().getApellido1();
            registros[5] = documento.getPersona().getApellido2();
            if(documento.getPersona() instanceof Alumno){
                Alumno hijo = (Alumno) documento.getPersona();
                registros[6] = hijo.getCurso(); //intentando acceder a1 curso de alumno
            }

            modeloTabla.addRow(registros);
        };
            tabla.setModel(modeloTabla);
    }
    
    public static void cargarHistorial(JTable tabla){        
        DefaultTableModel modeloTabla = new DefaultTableModel();
        
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Num Paginas");
        modeloTabla.addColumn("Dni");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido1");
        modeloTabla.addColumn("Apellido2");
        modeloTabla.addColumn("Dpto/Curso");
        
        String[] registros = new String[7];
        
        for(Documento documento: gestionColas.getListaHistorial()){
            registros[0] =  documento.getId().toString();
            registros[1] = documento.getNumPaginas().toString();
            registros[2] = documento.getPersona().getDni();
            registros[3] = documento.getPersona().getNombre();
            registros[4] = documento.getPersona().getApellido1();
            registros[5] = documento.getPersona().getApellido2();
            if(documento.getPersona() instanceof Profesor){
                Profesor hijo = (Profesor) documento.getPersona();
                registros[6] = hijo.getDpto(); //intentando acceder a1 curso de alumno
            }
            else if(documento.getPersona() instanceof Alumno){
                Alumno hijo = (Alumno) documento.getPersona();
                registros[6] = hijo.getCurso(); //intentando acceder a1 curso de alumno
            }
            modeloTabla.addRow(registros);
        };
            tabla.setModel(modeloTabla);
    }
    
    public static int borrarDocumentoAlum(int id) {
        DAODocumentosAlumnos dao = new DAODocumentosAlumnos();
        
        if (dao.eliminarDocumento(dao.getDocumentos().get(id)) == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
    public static int borrarDocumentoProf(int id) {
        DAODocumentosProfesores dao = new DAODocumentosProfesores();
        
        if (dao.eliminarDocumento(dao.getDocumentos().get(id)) == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
