package com.crusaders.gauntlet.java.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetUpWindow {

	private void createAndShowGUI()
	{
        JFrame frame = new JFrame("Set up your macros");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel ringFingerLabel = new JLabel("Input action of the ring finger:");
        
        JTextField txtFieldRingFingerFunction = new JTextField("Action of ring finger");
        
        
        ringFingerLabel.setPreferredSize(new Dimension(600, 600));
        
        frame.getContentPane().add(ringFingerLabel, BorderLayout.CENTER);
        frame.getContentPane().add(txtFieldRingFingerFunction, BorderLayout.CENTER);
 
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public void run()
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() 
            {
                createAndShowGUI();
            }
        }
        );    	
    }

}
