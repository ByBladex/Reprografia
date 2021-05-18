package dam.reprografia.recursos;

import java.util.ArrayList;
import java.util.Collections;

public class GestionColas {
	
	private DAODocumentosProfesores daoDocumentosP = new DAODocumentosProfesores();
	private DAODocumentosAlumnos daoDocumentosA = new DAODocumentosAlumnos();
        private Cola colaProfesores;
	private Cola colaAlumnos;
	private ArrayList<Documento> listaHistorial = new ArrayList<Documento>();

	
	GestionColas(){
		colaProfesores = daoDocumentosP.obtenerColaProfesores();
		colaAlumnos = daoDocumentosA.obtenerColaAlumnos();
	}
	
	public void fotocopiar() throws InterruptedException {
		Documento siguienteDocumento = cargarSiguienteDocumento();
		
		if(siguienteDocumento!=null) {
			Integer numPaginas = siguienteDocumento.getNumPaginas();
			listaHistorial.add(siguienteDocumento);
			while(numPaginas>0) {
				numPaginas -= 10;
				if(numPaginas<0)
					numPaginas = 0;
				Thread.sleep(1000);
				Vista.mostrar(siguienteDocumento.toString()+" Quedan "+numPaginas+" p�ginas por imprimir");
			}
		}
		else
			Vista.mostrar("No quedan documentos que imprimir");
	}
	
	public ArrayList<Documento> cargarDocumentos(){
		ArrayList<Documento> listaDocumentos = new ArrayList<Documento>();
		
		for(Documento documento:daoDocumentosP.mapDocumentosProfesores.values()) {
			listaDocumentos.add(documento);
		}
                for(Documento documento:daoDocumentosA.mapDocumentosAlumnos.values()) {
			listaDocumentos.add(documento);
		}
		return listaDocumentos;
	}
	
	public Documento cargarSiguienteDocumento() {
		if(!colaProfesores.estaVacia())
			return colaProfesores.desenCola();
		else if(!colaAlumnos.estaVacia())
			return colaAlumnos.desenCola();
		else
			return null;
	}
	
	public void mostrarTodo() {
		// TODO Auto-generated method stub
		if(!colaProfesores.estaVacia() || !colaAlumnos.estaVacia()) {
			Vista.mostrar("Documentos pendientes de impresi�n: ");
			Vista.mostrar(colaProfesores.ToString());
			Vista.mostrar(colaAlumnos.ToString());
		}
		else
			Vista.mostrar("No hay ning�n documento pendiente de impresi�n.");
		
		if(!listaHistorial.isEmpty()) {
			Vista.mostrar("Documentos impresos: ");
			for(Documento documento:listaHistorial) {
				Vista.mostrar(documento.toString());
			}
		}
		else
			Vista.mostrar("No hay documentos impresos.");
	}

	public void buscarDni(String dni) {
		// TODO Auto-generated method stub
		Cola colaDni = Cola.crearCola();
		for(int i=0;i<listaHistorial.size();i++) {
			if(listaHistorial.get(i).getPersona().getDni().equalsIgnoreCase(dni))
				colaDni.insertarCola(listaHistorial.get(i));
		}
		if(!colaDni.estaVacia())
			Vista.mostrar(colaDni.ToString());
		else
			Vista.mostrar("El DNI introducido no concuerda");
	}

	public void ordenarDni() {
		// TODO Auto-generated method stub
		ArrayList<Documento> listaDni = this.cargarDocumentos();
		Collections.sort(listaDni, new ComparatorDocumento());
		for(Documento documento: listaDni) {
			Vista.mostrar(documento.toString());
		}
	}

	public void ordenarNombre() {
		// TODO Auto-generated method stub
		ArrayList<Documento> listaNombres = this.cargarDocumentos();
		Collections.sort(listaNombres);
		for(Documento documento: listaNombres) {
			Vista.mostrar(documento.toString());
		}
	}
        
        public ArrayList<Documento> getListaHistorial(){
            return this.listaHistorial;
        }
}
