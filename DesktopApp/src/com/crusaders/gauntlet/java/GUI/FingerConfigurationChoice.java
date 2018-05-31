package com.crusaders.gauntlet.java.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FingerConfigurationChoice {

	private JFrame frame;
	
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
	public FingerConfigurationChoice(int index) {
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

		JButton btnAutowrite = new JButton("Auto-Write");
		btnAutowrite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AutoWriteConfig(fingerIndex).run();
			}
		});
		btnAutowrite.setBounds(26, 41, 372, 63);
		frame.getContentPane().add(btnAutowrite);

		JButton btnKeyCombination = new JButton("Key Combination");
		btnKeyCombination.setEnabled(false);
		btnKeyCombination.setBounds(26, 117, 372, 63);
		frame.getContentPane().add(btnKeyCombination);
		
		JButton button = new JButton("Back");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		button.setBounds(323, 215, 97, 25);
		frame.getContentPane().add(button);
	}

}
