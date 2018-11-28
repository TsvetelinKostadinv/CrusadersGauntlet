/*
 * 23/36/2018 at 12:36:03 ÷.
 * Main.java created by Tsvetelin
 */

/**
 * 23/36/2018 at 12:36:03 ÷.
 * Main.java created by Tsvetelin
 */
package com.crusaders.gauntlet.java;


import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;

import com.crusaders.gauntlet.java.bluetooth.discovery.BlueCoveDiscoverer;
import com.crusaders.gauntlet.java.bluetooth.receiving.BlueCoveReceiver;
import com.crusaders.gauntlet.java.bluetooth.receiving.Receiver;
import com.crusaders.gauntlet.java.macros.Macro;
import com.crusaders.gauntlet.java.util.GauntletData;
import com.crusaders.gauntlet.java.util.Reference;
import com.crusaders.gauntlet.java.util.communication.Channel;
import com.crusaders.gauntlet.java.util.fileManagement.creation.Creator;
import com.crusaders.gauntlet.java.util.fileManagement.creation.IFileCreator;
import com.crusaders.gauntlet.java.util.fileManagement.writing.IFileWriter;
import com.crusaders.gauntlet.java.util.fileManagement.writing.Writer;
import com.crusaders.gauntlet.java.util.scriptManagement.Script;


/**
 * 
 * This is the main class
 * 
 * @author Tsvetelin
 *
 */
public class Main
{

    private static Macro [] macros = initIfNotPresentMacros();


    public static final String BASE_PATH = "C://CrusadersGauntletFiles";


    public static final String BASE_NAME = "action";


    public static final String BASE_EXTENTION = ".txt";


    /**
     * @param args
     */
    public static void main ( String [] args )
    {
        new Thread( new MainMenu( macros ) ).start();
    }


    private static Macro [] initIfNotPresentMacros ()
    {

        File dir = new File( BASE_PATH );

        if ( dir.mkdir() )
        {
            IFileCreator creator = new Creator();
            IFileWriter writer = new Writer();

            for ( int i = 0 ; i < 4 ; i++ )
            {
                try
                {
                    creator.createFile( BASE_PATH + "//" + BASE_NAME + i + BASE_EXTENTION );
                } catch ( IOException e )
                {
                    e.printStackTrace();
                }
            }

            File [] files = dir.listFiles();

            try
            {
                String leftMouseButtonScript = KeyEvent.BUTTON1_DOWN_MASK
                        + Reference.CrusadersGauntletSpecialSymbols.DATA_SEPARATION_SYMBOL.getValue() + KeyEvent.BUTTON1_DOWN_MASK;
                
                String rightMouseButtonScript = KeyEvent.BUTTON3_DOWN_MASK
                        + Reference.CrusadersGauntletSpecialSymbols.DATA_SEPARATION_SYMBOL.getValue() + KeyEvent.BUTTON3_DOWN_MASK;
                
                writer.writeToFile( files[0] , leftMouseButtonScript , false );
                writer.writeToFile( files[1] , rightMouseButtonScript , false );
            } catch ( IOException e )
            {
                e.printStackTrace();
            }

            Script [] scriptWrappers = new Script[4];

            for ( int i = 0 ; i < scriptWrappers.length ; i++ )
            {
                scriptWrappers[i] = new Script( files[i] );
            }

            Macro [] macros = new Macro[4];

            for ( int i = 0 ; i < macros.length ; i++ )
            {
                macros[i] = new Macro( scriptWrappers[i] );
            }

            return macros;

        } else
        {
            File [] files = dir.listFiles();

            Script [] scriptWrappers = new Script[4];

            for ( int i = 0 ; i < scriptWrappers.length ; i++ )
            {
                scriptWrappers[i] = new Script( files[i] );
            }

            Macro [] macros = new Macro[4];

            for ( int i = 0 ; i < macros.length ; i++ )
            {
                macros[i] = new Macro( scriptWrappers[i] );
            }

            return macros;

        }

    }

    static class DataReceiver implements Runnable
    {

        public static final DataReceiver PRINTER = new DataReceiver( System.out::println );


        private Consumer< GauntletData > actor;


        public DataReceiver ( Consumer< GauntletData > actor )
        {

            this.actor = actor;
        }


        public void receive ()
        {

            if ( LocalDevice.isPowerOn() == false )
            {
                System.out.println( "Turn on your device to receive!" );
                throw new RuntimeException( new IllegalStateException( "Device must be on!" ) );
            } else
            {
                RemoteDevice gauntlet = getRemoteDevice();

                if ( gauntlet != null )
                {
                    Receiver< GauntletData > rec;
                    try
                    {
                        rec = new BlueCoveReceiver( gauntlet );
                    } catch ( NullPointerException e )
                    {
                        System.out.println( "Devices paired but did not connect!" );
                        throw new IllegalStateException( "The gauntlet must be powered on" );
                    }

                    Channel< GauntletData > data = rec.getOutputChannel();

                    Runnable process = () -> {
                        try
                        {
                            rec.continualReceive();
                        } catch ( IOException e )
                        {
                            e.printStackTrace();
                        }
                    };

                    Thread thread = new Thread( process );

                    thread.start();

                    while ( true )
                    {
                        if ( data.hasNext() )
                        {
                            this.actor.accept( data.next() );
                        }

                    }
                }
            }


        }


        private static RemoteDevice getRemoteDevice ()
        {

            try
            {
                return new BlueCoveDiscoverer().getAllDevices().stream()
                        .filter( x -> x.getBluetoothAddress().equals( "98D33570EFF7" ) ).findFirst().get();
            } catch ( NoSuchElementException e )
            {
                System.out.println( "Not Found!!!" );
                return null;
            }
        }


        @Override
        public void run ()
        {

            receive();

        }
    }

    public static class KeysConsumer implements Consumer< GauntletData >
    {

        @Override
        public void accept ( GauntletData t )
        {

            if ( t.getData()[GauntletData.btn1PushedStateIndex] == 0 ) macros[0].executeMacro();
            if ( t.getData()[GauntletData.btn2PushedStateIndex] == 0 ) macros[1].executeMacro();
            if ( t.getData()[GauntletData.btn3PushedStateIndex] == 0 ) macros[2].executeMacro();
            if ( t.getData()[GauntletData.btn4PushedStateIndex] == 0 ) macros[3].executeMacro();
        }

    }

}
