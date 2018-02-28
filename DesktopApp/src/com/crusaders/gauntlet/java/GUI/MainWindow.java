package com.crusaders.gauntlet.java.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow {

    private void createAndShowGUI() {
    	
        JFrame frame = new JFrame("Crusaders Gauntlet Desktop");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel emptyLabel = new JLabel("Label");
        
        emptyLabel.setPreferredSize(new Dimension(600, 600));
        
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
 
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