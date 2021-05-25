package dam.reprografia.recursos;

import java.util.ArrayList;

public class Cola {

	private ArrayList<Documento> cola;
	
	private Cola() {
		cola = new ArrayList<Documento>();
	}

	public void insertarCola(Documento d) {
		cola.add(d);
	}

	public Documento desenCola() {
		return cola.remove(0);
	}
        
        public ArrayList<Documento> getCola(){
            return this.cola;
        }

	public boolean estaVacia() {
		return cola.isEmpty();
	}
	
	public static Cola crearCola() {
		return new Cola();
	}
	
	public String ToString() {
		StringBuilder cadena = new StringBuilder();
		for(Documento documento:cola) {
			cadena.append(documento+"\n");
		}
		return cadena.toString();
	}
	
}
