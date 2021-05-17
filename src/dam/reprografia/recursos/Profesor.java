package dam.reprografia.recursos;

public class Profesor extends Persona{

	private String dpto;
	
	Profesor(String dni, String nombre, String apellido1, String apellido2, String dpto) {
		super(dni, nombre, apellido1, apellido2);
		this.dpto=dpto;
	}
	
	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	@Override
	public String toString() {
		return "Profesor [Departamento=" + dpto + ", Dni=" + getDni() + ", Nombre completo=" + getNombre() + " " + getApellido1() + " " + getApellido2() + "]";
	}
	
	

}
