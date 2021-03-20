package dam.reprografia.recursos;

public class Persona {
	String dni, nombre, apellido1;
	
	Persona(String dni, String nombre, String apellido1){
		this.dni=dni;
		this.nombre=nombre;
		this.apellido1=apellido1;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + "]";
	}
	
}
