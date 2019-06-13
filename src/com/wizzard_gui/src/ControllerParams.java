package com.wizzard_gui.src;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ControllerParams {

	private static ControllerParams single_instance = getInstance(); // singleton object

	

	ConfigFileParser configParser = new ConfigFileParser();
	int window_width = 1000;
	int window_hight = 1000;
	String windowTitle = "Controller";

	int grid_wall_padding = 10;
	int vertical_grid_padding = 10;
	int horizontal_grid_padding = 10;
	int grid_number_of_columns = 4;
	int generalPadding = 15;

	Boolean cameraExists = false;
	Boolean batteryExists = false;
	Boolean arrowKeysExists = false;

	String configFileName = "./src/ConfigureController.txt"; // need to have some of the path for it to work

	ArrayList<Pane> moduleList;
	
	private ControllerParams() {
		
		
	} // singleton private constructor

	public ArrayList<Pane> getModules() {

		// Make the arraylist
		return moduleList;
	}
	
	private void checkModules() {
		for(Pane module:moduleList) {
			if(module instanceof CameraViewModule) {
				cameraExists = true;
			}else if(module instanceof BatteryIndicator) {
				batteryExists = true;
			}else if(module instanceof ImageArrowKeys) {
				arrowKeysExists = true;
			}
		}
	}


	//////////////////////////////////////////////////////////////
	// getters and setters

	//////////////////////////////////////////////////////////////
	// singleton stuff

	public static ControllerParams getInstance() {
		if (single_instance == null) {
			single_instance = new ControllerParams();
			single_instance.configParser.readFile(single_instance.configFileName); // file name stored in this file
			single_instance.moduleList = single_instance.configParser.moduleList;
			single_instance.checkModules();
		}

		return single_instance;
	}

}
