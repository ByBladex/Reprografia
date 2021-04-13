package dam.reprografia.recursos;

public class Controlador {
	
	GestionColas gestionColas = new GestionColas();
	Vista vista = new Vista();
	ComparatorDocumento comparatorDoc = new ComparatorDocumento();
	
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
}
