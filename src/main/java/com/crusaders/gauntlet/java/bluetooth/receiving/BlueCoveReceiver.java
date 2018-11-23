/*
 * 20/31/2018 at 19:31:57
 * BlueCoveReceiver.java created by Tsvetelin
 */

package com.crusaders.gauntlet.java.bluetooth.receiving;


import java.io.BufferedInputStream;
import java.io.IOException;
import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

import com.crusaders.gauntlet.java.util.GauntletData;
import com.crusaders.gauntlet.java.util.communication.Channel;


/**
 * 
 * A simple class implementation of the <code>Receiver</code> interface with
 * BlueCove library
 * 
 * @author Tsvetelin
 *
 */
public class BlueCoveReceiver implements Receiver< GauntletData >
{

    public static final int bufferedErrorIterations = 3;


    private RemoteDevice sender;


    private volatile Channel< GauntletData > out;


    private BufferedInputStream inputFromDevice;


    private String url;


    private boolean scanFinished = false;


    public BlueCoveReceiver ( RemoteDevice sender )
    {

        this.setSender( sender );
        try
        {
            assignURL( sender );
        } catch ( BluetoothStateException e )
        {
            System.out.println( "Exceeding the max number of devices" );
            e.printStackTrace();
        }

        initDependencies();
    }


    @Override
    public GauntletData receiveOnce ( RemoteDevice sender ) throws IOException
    {

        this.setSender( sender );

        return this.receiveOnce();
    }


    public GauntletData receiveOnce () throws IOException
    {

        char bit;
        StringBuffer unSepValues = new StringBuffer();

        do
        {
            bit = (char) inputFromDevice.read();
            unSepValues.append( bit );
        } while ( bit != '#' );

        return new GauntletData().parse( unSepValues.toString() );
    }


    @Override
    public void continualReceive ()
    {

        int bit = 0;
        StringBuffer unSepValues = new StringBuffer();

        for ( int i = 0 ; i < bufferedErrorIterations ; i++ )
        {
            unSepValues.delete( 0 , unSepValues.length() );
            do
            {
                try
                {
                    bit = inputFromDevice.read();
                } catch ( IOException e )
                {
                    e.printStackTrace();
                }
                if ( bit != -1 )
                {
                    unSepValues.append( bit );
                }
            } while ( bit != '#' );
            System.out.println( "Unseparated value(Error Iterations): " + unSepValues );
        }

        while ( true )
        {
            try
            {
                GauntletData d = this.receiveOnce();
                // System.out.println( "Added value: " + d );
                out.add( d );
            } catch ( IOException e )
            {
                continue;
            }
        }

    }


    @Override
    public Channel< GauntletData > getOutputChannel ()
    {

        return out;
    }


    private void assignURL ( RemoteDevice sender ) throws BluetoothStateException
    {

        this.sender = sender;

        UUID [] searchUuidSet = new UUID[] { new UUID( 0x1101 ) };

        int [] attrIDs = new int[] { 0x0100 // service name
        };

        LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices( attrIDs , searchUuidSet , sender ,
                new DiscoveryListener()
                {

                    @Override
                    public void deviceDiscovered ( RemoteDevice btDevice , DeviceClass cod )
                    {

                    }


                    @Override
                    public void inquiryCompleted ( int discType )
                    {

                    }


                    @Override
                    public void serviceSearchCompleted ( int transID , int respCode )
                    {

                        scanFinished = true;
                    }


                    @Override
                    public void servicesDiscovered ( int transID , ServiceRecord [] servRecord )
                    {

                        for ( int i = 0 ; i < servRecord.length ; i++ )
                        {
                            url = servRecord[i].getConnectionURL( ServiceRecord.NOAUTHENTICATE_NOENCRYPT , false );
                            if ( url != null )
                            {
                                break; // take the first one
                            }
                        }
                    }
                } );

        while ( !scanFinished )
        {
            try
            {
                Thread.sleep( 500 );
            } catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
        }

    }


    private void initDependencies ()
    {

        out = new Channel<>();

    }


    private void initStreams ()
    {

        System.out.println( "URL of device = " + url );


        try
        {
            StreamConnection streamConnectionToDevice = (StreamConnection) Connector.open( url , Connector.READ );

            inputFromDevice = new BufferedInputStream( streamConnectionToDevice.openInputStream() );

        } catch ( IOException e )
        {
            e.printStackTrace();
        }


    }


    /**
     * 
     * @return the currently assigned sender
     */
    public RemoteDevice getSender ()
    {

        return sender;
    }


    /**
     * 
     * Sets the sender and assigns it's url
     * 
     * @param sender
     */
    public void setSender ( RemoteDevice sender )
    {

        if ( sender == null ) throw new IllegalArgumentException( "The sender cannot be null!!!" );

        this.sender = sender;
        try
        {
            while ( this.url == null )
            {
                assignURL( sender );
            }

        } catch ( BluetoothStateException e )
        {
            e.printStackTrace();
        }

        initStreams();
    }

}
