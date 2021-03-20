package dam.reprografia.recursos;

import java.util.LinkedList;
import java.util.List;

public class Cola {

	private List<Documento> cola;
	
	private Cola() {
		cola = new LinkedList<Documento>();
	}

	public void insertarCola(Documento d) {
		cola.add(d);
	}

	public Documento imprimir() {
		return cola.remove(0);
	}

	public boolean estaVacia() {
		return cola.isEmpty();
	}
	
	public static Cola crearCola() {
		return new Cola();
	}
	
	public String ToString() {
		StringBuilder cadena = new StringBuilder();
		for(Documento valor:cola) {
			cadena.append(valor+"\n");
		}
		return cadena.toString();
	}
	
}
