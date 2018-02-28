package com.crusaders.gauntlet.java.bluetoothIntegration;

import com.crusaders.gauntlet.java.models.Direction;
import com.crusaders.gauntlet.java.models.macroFunctionality.Macro;

public interface BluetoothInput {
	public String receiveMessage();
	public Direction parseButton();
	public Macro parseMacro();
}
