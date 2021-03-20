package dam.reprografia.recursos;

public class Documento {

	private Integer id=1;
	private static Integer idCount=1;
	private Integer numPaginas;
	private Persona persona;

	
	Documento(Integer numPaginas, Persona persona){
		this.id=idCount++;
		this.numPaginas=numPaginas;
		this.persona=persona;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", numPaginas=" + numPaginas + "]";
	}
}
