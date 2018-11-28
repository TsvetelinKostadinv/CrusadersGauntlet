/*
 * 28/18/2018 at 0:18:46 ÷.
 * MainMenu.java created by Tsvetelin
 */

package com.crusaders.gauntlet.java;

import javax.swing.JFrame;

import com.crusaders.gauntlet.java.actions.mouseMovement.MouseInteracter;
import com.crusaders.gauntlet.java.actions.mouseMovement.RobotMouseInteracter;
import com.crusaders.gauntlet.java.macros.Macro;
import com.crusaders.gauntlet.java.util.Direction;
import com.crusaders.gauntlet.java.util.GauntletData;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.awt.Toolkit;
import javax.swing.JLabel;


public class MainMenu extends JFrame implements Runnable
{

    
    
    /**
     * 
     */
    private static final long serialVersionUID = 6349703368649132302L;

    boolean isActiveReceiving = false;
    
    List< Thread > currentRunning = new ArrayList<>();
    
    Macro[] macros;
    
    /**
     * Create the frame.
     * @param macros 
     */
    public MainMenu (Macro [] macros)
    {
        
        this.macros = macros;
        
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CrusadersGauntletRevamp\\CrusadersGauntlet v2.0\\resources\\images\\logo16x16.png"));
        setTitle("Crusaders Gauntlet");
        setResizable(false);

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setBounds( 100 , 100 , 370 , 320 );
        getContentPane().setLayout(null);
        
        JLabel lblProblems = new JLabel("Problems: none");
        lblProblems.setToolTipText("Displays the current state of the problems with the gauntlet or app.\r\n");
        lblProblems.setBounds(24, 190, 177, 82);
        getContentPane().add(lblProblems);
        
        JButton btnToggleReceiving = new JButton("Start Receiving");
        btnToggleReceiving.setToolTipText("Start receiving");
        btnToggleReceiving.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isActiveReceiving)
                {
                    isActiveReceiving = true;
                    btnToggleReceiving.setText( "Stop Receiving" );
                    btnToggleReceiving.setToolTipText( "Stop receiving" );
                    
                    MouseInteracter< Direction > mover = new RobotMouseInteracter();
                    Consumer< GauntletData > runnerMover = x -> mover.moveMouse( x.castToDirection() );
                    
                    Consumer< GauntletData > runnerPresser = new Main.KeysConsumer();
                    
                    Thread moverThread = new Thread( new Main.DataReceiver( runnerMover ), "Mover Thread" );
                    Thread keyPresserThread = new Thread( new Main.DataReceiver( runnerPresser ), "Presser Thread" );
                    
                    Thread.UncaughtExceptionHandler handlerForIllegalState = (x,y) ->
                    {
                        if ( x.getClass().equals( IllegalStateException.class ) )
                        {
                            lblProblems.setText( "Problem: The gauntlet is off!" );
                            isActiveReceiving = false;
                            btnToggleReceiving.setText( "Start Receiving" );
                        }
                    };
                    
                    moverThread.setUncaughtExceptionHandler( handlerForIllegalState );
                    keyPresserThread.setUncaughtExceptionHandler( handlerForIllegalState );
                    
                    currentRunning.add( moverThread );
                    currentRunning.add( keyPresserThread );

                    currentRunning.forEach( x -> x.start() );
                    
                }else {
                    isActiveReceiving = false;
                    btnToggleReceiving.setText( "Start Receiving" );
                    btnToggleReceiving.setToolTipText( "Start receiving" );
                    lblProblems.setText( "Problems: none" );
                    
                    currentRunning.forEach( x -> {
                            try
                            {
                                x.join();
                            } catch ( InterruptedException e1 )
                            {
                                e1.printStackTrace();
                            }
                        } );
                    
                }
                
                
            }
        });
        btnToggleReceiving.setBounds(24, 25, 315, 63);
        getContentPane().add(btnToggleReceiving);
        
        JButton btnExit = new JButton("Exit");
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                System.exit( 0 );
            }
        });
        btnExit.setBounds(224, 210, 115, 46);
        getContentPane().add(btnExit);
        
        JButton btnChangeMacros = new JButton("Change macros");
        btnChangeMacros.setToolTipText("Change the macros");
        btnChangeMacros.setBounds(24, 101, 315, 63);
        getContentPane().add(btnChangeMacros);
        
    }


    @Override
    public void run ()
    {

        try
        {
            MainMenu frame = new MainMenu( this.macros );
            frame.setVisible( true );
        } catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
