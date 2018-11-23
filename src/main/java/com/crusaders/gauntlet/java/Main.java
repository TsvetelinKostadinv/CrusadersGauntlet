/*
 * 23/36/2018 at 12:36:03 ÷.
 * Main.java created by Tsvetelin
 */

/**
 * 23/36/2018 at 12:36:03 ÷.
 * Main.java created by Tsvetelin
 */
package com.crusaders.gauntlet.java;


import java.io.IOException;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.util.List;
import java.util.NoSuchElementException;

import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;

import com.crusaders.gauntlet.java.bluetooth.discovery.BlueCoveDiscoverer;
import com.crusaders.gauntlet.java.bluetooth.discovery.Discoverer;
import com.crusaders.gauntlet.java.bluetooth.receiving.BlueCoveReceiver;
import com.crusaders.gauntlet.java.bluetooth.receiving.Receiver;
import com.crusaders.gauntlet.java.util.GauntletData;
import com.crusaders.gauntlet.java.util.communication.Channel;


/**
 * 
 * This is the main class
 * 
 * @author Tsvetelin
 *
 */
public class Main
{

    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main ( String [] args ) throws InterruptedException , IOException
    {

        if ( LocalDevice.isPowerOn() == false )
        {
            System.out.println( "Turn on your device!" );
        }

        closeAllSockets();

        Discoverer disc = new BlueCoveDiscoverer();
        List< RemoteDevice > devices = disc.getAllDevices();
        RemoteDevice gauntlet = null;
        try
        {
            gauntlet = devices.stream().filter( x -> x.getBluetoothAddress().equals( "98D33570EFF7" ) ).findFirst()
                    .get();
        } catch ( NoSuchElementException e )
        {
            System.out.println( "Not Found!!!" );
            gauntlet = null;
        }


        if ( gauntlet != null )
        {
            Receiver< GauntletData > rec = new BlueCoveReceiver( gauntlet );
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
                    System.out.println( data.next() );
                }

            }
        }


    }


    private static void closeAllSockets ()
    {

    }

}
