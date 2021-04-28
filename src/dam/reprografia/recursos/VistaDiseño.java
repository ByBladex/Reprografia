package dam.reprografia.recursos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaDiseño {

	private JFrame frame;
	private static JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaDiseño window = new VistaDiseño();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static DefaultListModel mostrar(String string){
		   DefaultListModel model = new DefaultListModel<>();
		   model.addElement(string);
		   return model;
	}
	
	/**
	 * Create the application.
	 */
	public VistaDiseño() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		list = new JList();
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnImprimir.setBounds(10, 82, 89, 23);
		frame.getContentPane().add(btnImprimir);
		
		
		list.setValueIsAdjusting(true);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setVisibleRowCount(10);
		list.setBounds(145, 11, 279, 145);
		frame.getContentPane().add(list);
	}
}
