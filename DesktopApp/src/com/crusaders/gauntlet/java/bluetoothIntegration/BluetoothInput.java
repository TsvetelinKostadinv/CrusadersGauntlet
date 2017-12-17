package com.crusaders.gauntlet.java.bluetoothIntegration;

import com.crusaders.gauntlet.java.models.DirectionPointer;
import com.crusaders.gauntlet.java.models.macroFunctionality.Macro;

public interface BluetoothInput {
	public String receiveMessage();
	public DirectionPointer parseButton();
	public Macro parseMacro();
}
