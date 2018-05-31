package com.crusaders.gauntlet.java.bluetooth;

import java.io.IOException;
import java.util.Vector;
import javax.bluetooth.*;

/**
 * Minimal Device Discovery example.
 */
public class Discoverer {

    public static final Vector<RemoteDevice> devicesDiscovered = new Vector<RemoteDevice>();

    public Vector<RemoteDevice> findDevices() throws BluetoothStateException, InterruptedException
    {
    	final Object inquiryCompletedEvent = new Object();

        devicesDiscovered.clear();
        
        DiscoveryListener listener = new DiscoveryListener() 
        {
        	
            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                System.out.println("Device " + btDevice.getBluetoothAddress() + " found");
                //System.out.println("With address: "+btDevice.getBluetoothAddress());
                devicesDiscovered.addElement(btDevice);
                
                try {
                    System.out.println("     name " + btDevice.getFriendlyName(false));
                } catch (IOException cantGetDeviceName) {
                }
            }

            public void inquiryCompleted(int discType) {
                System.out.println("Device Inquiry completed!");
                synchronized(inquiryCompletedEvent){
                    inquiryCompletedEvent.notifyAll();
                }
            }

            public void serviceSearchCompleted(int transID, int respCode) {
            }

            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
            }
        };

        synchronized(inquiryCompletedEvent) {
            boolean started = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
            if (started) {
                System.out.println("wait for device inquiry to complete...");
                inquiryCompletedEvent.wait();
                System.out.println(devicesDiscovered.size() + " device(s) found");
                
            }
        }
        return devicesDiscovered;
    }


}
