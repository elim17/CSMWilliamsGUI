package com.wizzard_gui.src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;




public class ConfigFileParser {

	public ArrayList<String> classesToInstantiate = new ArrayList<String>();
	private String ManifestFileName = "./src/ModuleManifest.txt";
	//public String filename = "ConfigureController.txt";
	

	public void readFile(String filename)
	{

		File file = new File(filename);
		Scanner input;
		try {
			input = new Scanner(file);
		

		while(input.hasNextLine()) {
		    String configLine = input.nextLine();
		    if(configLine.startsWith("//"))
		    {
		    	// it is a comment and should be ignored
		    }
		    else if(configLine.isEmpty())
		    {
		    	// it is empty and should be ignored
		    }
		    else if(configLine.startsWith("-"))
		    {
		    	// user doesn't want to run this module
		    }
		    else if(!isValidInput(configLine))
		    {
		    	//it is not a valid input 
		    	//alert user via command line
		    	System.out.println(configLine + " is not a valid input");
		    	//alert user with a pop up? 
		    }
		    else
		    {
		    	//System.out.println(configLine); // testing
		    	classesToInstantiate.add(configLine);
		    }
		}
		reorderClasses();
		input.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Boolean isValidInput(String configInputLine) throws FileNotFoundException
	{
		ArrayList<String> manifest = readModuleManifest();

			if(!manifest.contains(configInputLine))
			{
				//the input is invalid
				//System.out.println("The input is not in the manifest");
				return false;
			}
			else
			{
				return true;
			}
		
	}
	


	private ArrayList<String> readModuleManifest() throws FileNotFoundException
	{
		ArrayList<String> manifest = new ArrayList<String>();
		File file = new File(ManifestFileName);
		Scanner input = new Scanner(file);
		while(input.hasNextLine()) {
		    String manifestLine = input.nextLine();
		    if(manifestLine.startsWith("//"))
		    {
		    	// it is a comment and should be ignored
		    }
		    else
		    {
		    	manifest.add(manifestLine);
		    }
		}
		return manifest;
	}
	
	private void reorderClasses() {
		System.out.println("reordered the class");
		
		int index = 0;
		for (String module : classesToInstantiate)
		{
			//make sure that camera goes at 0
			if(module.equals("CameraViewModule"))
			{
				Collections.swap(classesToInstantiate, index, 0); // element to be swapped, place where element should go
			}
			//make sure that battery goes at 1
			if(module.equals("BatteryIndicator"))
			{
				Collections.swap(classesToInstantiate, index, 1);
			}
			//make sure that arrow keys goes at 2
			if(module.equals("ImageArrowKeys"))
			{
				Collections.swap(classesToInstantiate, index, 2);
			}
			
			index++;
		}
	}
	
	// getters and setters
	public ArrayList<String> getClassesToInstantiate() {
		return classesToInstantiate;
	}
	
}
