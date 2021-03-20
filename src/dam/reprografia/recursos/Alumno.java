package dam.reprografia.recursos;

public class Alumno extends Persona{

	private Curso curso;
	
	Alumno(String dni, String nombre, String apellido1, String apellido2, Curso curso) {
		super(dni, nombre, apellido1, apellido2);
		this.curso=curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [Curso=" + curso + ", Dni=" + getDni() + ", Nombre completo=" + getNombre() + " " + getApellido1() + " " + getApellido2() + "]";
	}
	
	
}
