package dam.reprografia.recursos;

import java.util.Comparator;

public class ComparatorDocumento implements Comparator<Documento>{

	@Override
	public int compare(Documento o1, Documento o2) {
		// TODO Auto-generated method stub
		Integer salida;
		if(o1.getPersona().getDni().compareToIgnoreCase(o2.getPersona().getDni())==0)
			salida = 0;
		else if(o1.getPersona().getDni().compareToIgnoreCase(o2.getPersona().getDni())>0)
			salida = -1;
		else
			salida = 1;
		return salida;
	}
	
}
