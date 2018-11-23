/*
 * 20/08/2018 at 19:08:33
 * Receiver.java created by Tsvetelin
 */

package com.crusaders.gauntlet.java.bluetooth.receiving;

import java.io.IOException;
import javax.bluetooth.RemoteDevice;

import com.crusaders.gauntlet.java.util.communication.Channel;

/**
 * 
 * An interface defining the methods for receiving from a Bluetooth device
 * 
 * @author Tsvetelin
 *
 * @param <WhatToReceive>
 */
public interface Receiver< WhatToReceive >
{
    
    /**
     * 
     * Receives data from the <code>RemoteDevice</code>,                <br>
     *  and sends it over to the <code>Channel</code>         <br>
     * 
     * @param sender - the <code>RemoteDevice</code> which will be expected to send data
     * @return a parsed version of the data received
     */
    public void continualReceive(  ) throws IOException;
    
    /**
     * Receives only once from the sender
     * 
     * @param sender
     * @return a parsed version of the data received
     * @throws IOException 
     */
    public WhatToReceive receiveOnce ( RemoteDevice sender ) throws IOException;
    
    /**
     * 
     * @return the pipeline through which the data will be sent
     */
    public Channel< WhatToReceive > getOutputChannel();
    
    
}
