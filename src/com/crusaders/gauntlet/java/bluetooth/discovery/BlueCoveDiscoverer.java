/*
 * 19/29/2018 at 19:29:22
 * BlueCoveDiscoverer.java created by Tsvetelin
 */

package com.crusaders.gauntlet.java.bluetooth.discovery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;


public class BlueCoveDiscoverer implements Discoverer
{
    
    @Override
    public List< RemoteDevice > getAllDevices () {
        
        List<RemoteDevice> devices = new ArrayList<>();
            
        final Object notifier = new Object();

        DiscoveryListener listener = new DiscoveryListener() 
        {
            
            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                System.out.println("Device " + btDevice.getBluetoothAddress() + " found");
                   
                devices.add(btDevice);
                    
                try {
                    System.out.println("     name " + btDevice.getFriendlyName(false));
                    System.out.println("     with address: "+btDevice.getBluetoothAddress());
                } catch (IOException cantGetDeviceName) {
                    System.err.println( "     name not supported or device cannot be contacted" );
                    System.out.println("      with address: "+btDevice.getBluetoothAddress());
                }
        }

            public void inquiryCompleted(int discType) {
                System.out.println("Device Inquiry completed!");
                synchronized(notifier)
                {
                    notifier.notifyAll();
                }
            }

            public void serviceSearchCompleted(int transID, int respCode) {
            }

            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
            }
                
        };

        synchronized(notifier) {
            boolean started = false;
            try
            {
                started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
            } catch ( BluetoothStateException e )
            {
                System.out.println( "Connot execute operation in current state" );
            }
            if (started) {
                System.out.println("wait for device inquiry to complete...");
                try
                {
                    notifier.wait();
                } catch ( InterruptedException e )
                {
                    System.out.println( "We were interrupted" );
                }
                    System.out.println(devices.size() + " device(s) found");
                }
        }
            
        return devices;
        }
      

    
    @Override
    public RemoteDevice findDevice ( String address ) {
        List< RemoteDevice > devices = getAllDevices();
        for(RemoteDevice i : devices)
        {
            if(i.getBluetoothAddress().equals( address ))
            {
                return i;
            }
        }
        return null;
    }


    @Override
    public RemoteDevice findDevice ( Long address ) {
        
        return findDevice( address.toString() );
    }
    
}
