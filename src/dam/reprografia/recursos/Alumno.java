package dam.reprografia.recursos;

public class Alumno extends Persona{

	private String curso;
	
	Alumno(String dni, String nombre, String apellido1, String apellido2, String curso) {
		super(dni, nombre, apellido1, apellido2);
		this.curso=curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [Curso=" + curso + ", Dni=" + getDni() + ", Nombre completo=" + getNombre() + " " + getApellido1() + " " + getApellido2() + "]";
	}
	
	
}
