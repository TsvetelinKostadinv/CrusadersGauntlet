package com.crusaders.gauntlet.java.scriptManagementJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.crusaders.gauntlet.java.keyPress.KeyPresser;
import com.crusaders.gauntlet.java.keyPress.RobotKeyPresser;
import com.crusaders.gauntlet.java.scriptManagementJava.Finding.ScriptFinderJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Generation.ScriptGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Writing.ScriptWriterJava;
import com.crusaders.gauntlet.java.scriptManagementJava.codeGeneration.CodeGeneratorJava;
import com.crusaders.gauntlet.java.scriptManagementJava.Reading.ScriptReader;

public class PilotClass {
	public static void main(String[] args)
	{
		CodeGeneratorJava codeGen = new CodeGeneratorJava();
		ScriptGeneratorJava scriptGen = new ScriptGeneratorJava();
		ScriptFinderJava finder = new ScriptFinderJava();

		File script1 = scriptGen.generateNewScript();
		File script2 = scriptGen.generateNewScript();
		File script3 = scriptGen.generateNewScript();
		
		ScriptWriterJava writer;
		writer = new ScriptWriterJava(script1);
		codeGen.insertKeys("this is the first script !! ");
		String toInsert = codeGen.getCode();
		writer.writeToScript(toInsert);
 
		codeGen.clearCode();
		writer = new ScriptWriterJava(script2);
		codeGen.insertKeys("and this is the second@{ what about here } ");
		toInsert = codeGen.getCode();
		writer.writeToScript(toInsert);
		
		codeGen.clearCode();
		writer = new ScriptWriterJava(script3);
		codeGen.insertKeys("EveN the third one works []");
		toInsert = codeGen.getCode();
		writer.writeToScript(toInsert);
		
		KeyPresser presser = new RobotKeyPresser();
		
		ScriptReader reader = new ScriptReader();
		
		try {
			Integer[] keys = reader.getKeycodesFromScript(finder.findScript(0));
			Thread.sleep(3000);
			
			for(Integer i = 0;i<keys.length-1;i++)
			{
				presser.pressKey(keys[i]);
			}
			presser.releaseShift();
			
			keys = reader.getKeycodesFromScript(finder.findScript(1));
			Thread.sleep(3000);
			
			for(Integer i = 0;i<keys.length-1;i++)
			{
				presser.pressKey(keys[i]);
			}

			presser.releaseShift();
			
			keys = reader.getKeycodesFromScript(finder.findScript(2));
			Thread.sleep(3000);
			
			for(Integer i = 0;i<keys.length-1;i++)
			{
				presser.pressKey(keys[i]);
			}
			presser.releaseShift();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
