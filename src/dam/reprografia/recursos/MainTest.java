package dam.reprografia.recursos;

import java.awt.EventQueue;

public class MainTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*Controlador controlador = new Controlador();
		controlador.ejecutar();*/
                
		EventQueue.invokeLater(new Runnable() {
                @Override
                    public void run() {
                        try {
                            Ventana ventana = new Ventana();
                            ventana.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
		});
	}

}
