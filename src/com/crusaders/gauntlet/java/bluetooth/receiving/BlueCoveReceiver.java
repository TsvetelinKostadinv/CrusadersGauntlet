/*
 * 20/31/2018 at 19:31:57
 * BlueCoveReceiver.java created by Tsvetelin
 */

package com.crusaders.gauntlet.java.bluetooth.receiving;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

import com.crusaders.gauntlet.java.util.GauntletData;

public class BlueCoveReceiver implements Receiver< GauntletData >
{
    public static final int bufferedErrorIterations = 3;

    private RemoteDevice sender;
    
    private PipedOutputStream out;
    private PipedInputStream in;
    
    
    BufferedInputStream inputFromDevice;
    
    private String url;
    
    private boolean scanFinished = false;
    
    public BlueCoveReceiver (RemoteDevice sender)
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
    
    public GauntletData receiveOnce (  ) throws IOException
    {
        int bit;
        StringBuffer unSepValues = new StringBuffer();
        
        do
        {
            bit = inputFromDevice.read();
            unSepValues.append( bit );
        }while(bit!='#');
        System.out.println("Unseparated value: " + unSepValues);
        
        for(int i=0;i<unSepValues.length();i++)
        {
            out.write( unSepValues.charAt( i ) );
        }
        return new GauntletData().parse( unSepValues.toString() );
    }
    

    @Override
    public void ContinualReceive ( RemoteDevice sender ) 
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
                unSepValues.append( bit );
            }while(bit!='#');
            System.out.println("Unseparated value(Error Iterations): " + unSepValues);
        }
        
        while( true )
        {
            try
            {
                out.write( inputFromDevice.read() );
            } catch ( IOException e )
            {
                continue;
            }
        }
        
    }

    @Override
    public PipedOutputStream getOutputChannel () {
        return out;
    }
    
    private void assignURL(RemoteDevice sender) throws BluetoothStateException
    {
        
        this.sender  = sender;
        
        UUID[] searchUuidSet = new UUID[] { new UUID(0x1101) };
        
        int[] attrIDs = new int[] { 
                0x0100 // service name
        };

        LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet,
                sender, new DiscoveryListener() {
                    @Override
                    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                    }

                    @Override
                    public void inquiryCompleted(int discType) {
                    }

                    @Override
                    public void serviceSearchCompleted(int transID, int respCode) {
                        scanFinished = true;
                    }

                    @Override
                    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) 
                    {
                        for (int i = 0; i < servRecord.length; i++) {
                            url = servRecord[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
                            if (url != null) {
                                break; // take the first one
                            }
                        }
                    }
                });

        while (!scanFinished) 
        {
            try
            {
                Thread.sleep(500);
            } catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
        
    }
    
    private void initDependencies ()
    {
        
        out = new PipedOutputStream();
        try
        {
            in = new PipedInputStream( out );
            out.connect( in );
            
            initStreams();
        } catch ( IOException e )
        {
            e.printStackTrace();
        }
        
    }



    private void initStreams () throws IOException 
    {
        inputFromDevice.close();
        StreamConnection streamConnectionToDevice = (StreamConnection) Connector.open(url);
        
        inputFromDevice = new BufferedInputStream(streamConnectionToDevice.openInputStream());
    }
    
    /**
     * 
     * @return the currently assigned sender
     */
    public RemoteDevice getSender () {

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
        this.sender = sender;
        try
        {
            assignURL( sender );
        } catch ( BluetoothStateException e )
        {
            e.printStackTrace();
        }
        
        try
        {
            initStreams();
        } catch ( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
