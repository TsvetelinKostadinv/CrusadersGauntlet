package com.crusaders.gauntlet.java.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.crusaders.gauntlet.Session;
import com.crusaders.gauntlet.java.models.macroFunctionality.MacroSet;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AutoWriteConfig {

	private JFrame frame;
	private JTextField txtInputActionOf;
	
	private Session sess = Session.getInstance();
	
	private int fingerIndex;

	/**
	 * Launch the application.
	 */
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AutoWriteConfig(int index) {
		fingerIndex = index;
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
		
		txtInputActionOf = new JTextField();
		txtInputActionOf.setBounds(12, 13, 408, 59);
		txtInputActionOf.setText("Input Action Of your desired finger");
		frame.getContentPane().add(txtInputActionOf);
		txtInputActionOf.setColumns(10);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String action = txtInputActionOf.getText();
				frame.setVisible(false);
				MacroSet macros = (MacroSet) sess.getAttribute("macros");
				macros.editAction(fingerIndex, action);
			}
		});
		btnNewButton.setBounds(99, 98, 179, 74);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(btnBack);
	}

}
