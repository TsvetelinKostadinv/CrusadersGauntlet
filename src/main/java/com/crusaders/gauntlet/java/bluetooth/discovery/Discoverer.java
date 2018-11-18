/*
 * 19/22/2018 at 19:22:22
 * Discoverer.java created by Tsvetelin
 */

package com.crusaders.gauntlet.java.bluetooth.discovery;

import java.util.List;

import javax.bluetooth.RemoteDevice;

/**
 * 
 * An interface defining the core functionality for discovering Bluetooth devices
 * 
 * @author Tsvetelin
 *
 */
public interface Discoverer
{
    /**
     * 
     * Finds all Bluetooth devices nearby and constructs a list of all of them
     * 
     * @return a list of all available devices nearby
     */
    public List<RemoteDevice> getAllDevices();
    
    /**
     * 
     * Finds a specific Bluetooth device
     * 
     * @param address - the address of the searched device
     * @return the <code>RemoteDevice</code> searched or <code>null</code> otherwise
     */
    public RemoteDevice findDevice(String address);
    
    /**
     * 
     * Finds a specific Bluetooth device
     * 
     * @param address - the address of the searched device
     * @return the <code>RemoteDevice</code> searched or <code>null</code> otherwise
     */
    public RemoteDevice findDevice(Long address);
}
