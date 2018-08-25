/*
 * 20/08/2018 at 19:08:33
 * Receiver.java created by Tsvetelin
 */

package com.crusaders.gauntlet.java.bluetooth.receiving;

import java.io.IOException;
import java.io.PipedOutputStream;

import javax.bluetooth.RemoteDevice;

public interface Receiver< WhatToReceive >
{
    
    /**
     * 
     * Receives data from the <code>RemoteDevice</code>,                <br>
     *  and sends it over to the <code>PipedOutputStream</code>         <br>
     * 
     * @param sender - the <code>RemoteDevice</code> which will be expected to send data
     * @return a parsed version of the data received
     */
    public void ContinualReceive( RemoteDevice sender ) throws IOException;
    
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
    public PipedOutputStream getOutputChannel();
    
    
}
