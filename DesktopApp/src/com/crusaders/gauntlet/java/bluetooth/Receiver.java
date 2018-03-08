package com.crusaders.gauntlet.java.bluetooth;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

import com.crusaders.gauntlet.Session;
import com.crusaders.gauntlet.java.models.Direction;
import com.crusaders.gauntlet.java.models.macroFunctionality.MacroSet;
import com.crusaders.gauntlet.java.mouseMovement.MouseInteracter;
import com.crusaders.gauntlet.java.mouseMovement.RobotMouseInteracter;

public class Receiver{
	public final int accXIndex = 1;
	public final int accYIndex = 0;
	
	public final int btn1PushedStateIndex = 3;
	public final int btn2PushedStateIndex = 4;
	public final int btn3PushedStateIndex = 5;
	public final int btn4PushedStateIndex = 6;
	

	private RemoteDevice hc05;
	public static final String hc05Address = "98D33570EFF7";

	private String hc05Url; 
	
	private MouseInteracter mouse = new RobotMouseInteracter();
	MacroSet macros = new MacroSet("asd", "dfg");//(MacroSet) Session.getInstance().getAttribute("macros");

	boolean scanFinished = false;
	
	private Discoverer discoverer;

	public Receiver() {
		initDependencies();
		try {
			Vector<RemoteDevice> all = discoverer.findDevices();

			for (RemoteDevice device : all) {
				if (device.getBluetoothAddress().equals(hc05Address)) {
					hc05 = device;
					
					hc05Url = "btspp://"+hc05Address+":1;authenticate=false;encrypt=false;master=false.";
					
					assignURL();
				}
			}

		} catch (BluetoothStateException | InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initDependencies() {
		discoverer = new Discoverer();

	}

	public void assignURL() throws IOException, InterruptedException 
	{
		UUID uuid = new UUID(0x1101); // scan for btspp://... services (as HC-05 offers it)
		
		UUID[] searchUuidSet = new UUID[] { uuid };
		
		int[] attrIDs = new int[] { 
				0x0100 // service name
		};

		LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet,
				hc05,new DiscoveryListener() {
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
							hc05Url = servRecord[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
							if (hc05Url != null) {
								break; // take the first one
							}
						}
					}
				});

		while (!scanFinished) 
		{
			Thread.sleep(500);
		}

		System.out.println(hc05.getBluetoothAddress());
		System.out.println(hc05Url);
	}

	public String startReceiving()
	{
        try {
        	StreamConnection streamConnection = (StreamConnection) Connector.open(hc05Url);
			
			BufferedInputStream input = new BufferedInputStream(streamConnection.openInputStream());
			
			int bit;
			String unSepValues = "";
			
			boolean isFirst = true;
			
			for(;;)
			{
				do
				{
					bit = input.read();
					unSepValues += (char) bit;
				}while(bit!='#');
				System.out.println("Unseparated value: " + unSepValues);
				
				
				
				String[] strValues = unSepValues.split("\\|");
				
				int[] values = new int[strValues.length];
				
				for(int j=0;j<strValues.length && !isFirst;j++)
				{

					try {
						values[j] = Integer.parseInt(strValues[j]);
					}catch(NumberFormatException e)
					{
						values[j] = Integer.parseInt(strValues[j].charAt(0)+"");
					}
				}
				if(!isFirst) {
				mouse.moveMouse(new Direction((values[accXIndex]*90)/16000, -(values[accYIndex]*90)/16000));
				if(values[btn1PushedStateIndex]==0)
				{
					macros.execute(0);
				}
				if(values[btn2PushedStateIndex]==0)
				{
					macros.execute(1);
				}
				if(values[btn3PushedStateIndex]==0)
				{
					macros.execute(2);
				}
				if(values[btn4PushedStateIndex]==0)
				{
					macros.execute(3);
				}
				}
				unSepValues = "";
				isFirst = false;
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	public static void main(String[] args)
	{
		Receiver receiver = new Receiver();
		receiver.startReceiving();
	}

}
