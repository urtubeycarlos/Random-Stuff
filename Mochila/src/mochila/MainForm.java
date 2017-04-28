package mochila;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm {

	private JFrame frame;
	private Worker worker;
	private MainForm _this;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		_this = this;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(67, 50, 274, 14);
		frame.getContentPane().add(progressBar);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				worker = new Worker(_this);
				worker.execute();
			}
		});
		btnComenzar.setBounds(87, 88, 89, 23);
		frame.getContentPane().add(btnComenzar);
		
		JButton btnPausar = new JButton("Pausar");
		btnPausar.setBounds(230, 88, 89, 23);
		frame.getContentPane().add(btnPausar);
		btnPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				worker.cancel(true);
			}
		});
	}

	public void mostrarProgreso(double progreso) {
		progressBar.setIndeterminate(false);
		progressBar.setValue((int) progreso);
		progressBar.setStringPainted(true);
	}
}
