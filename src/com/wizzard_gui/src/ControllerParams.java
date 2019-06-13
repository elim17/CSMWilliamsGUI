package com.wizzard_gui.src;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ControllerParams {

	private static ControllerParams single_instance = getInstance(); // singleton object

	private ConfigFileParser configParser = new ConfigFileParser();
	private int window_width = 1000;
	private int window_hight = 1000;
	private String windowTitle = "Controller";

	private int grid_wall_padding = 10;
	private int vertical_grid_padding = 10;
	private int horizontal_grid_padding = 10;
	private int grid_number_of_columns = 4;
	private int generalPadding = 15;

	private Boolean cameraExists = false;
	private Boolean batteryExists = false;
	private Boolean arrowKeysExists = false;

	private String configFileName = "./src/ConfigureController.txt"; // need to have some of the path for it to work

	private ArrayList<Pane> moduleList;

	private ControllerParams() {

	} // singleton private constructor

	public ArrayList<Pane> getModules() {

		// Make the arraylist
		return moduleList;
	}

	private void checkModules() {
		for (Pane module : moduleList) {
			if (module instanceof CameraViewModule) {
				cameraExists = true;
			} else if (module instanceof BatteryIndicator) {
				batteryExists = true;
			} else if (module instanceof ImageArrowKeys) {
				arrowKeysExists = true;
			}
		}
	}

	//////////////////////////////////////////////////////////////
	// getters and setters

	public int getWindow_width() {
		return window_width;
	}

	public int getWindow_hight() {
		return window_hight;
	}

	public String getWindowTitle() {
		return windowTitle;
	}

	public int getGrid_wall_padding() {
		return grid_wall_padding;
	}

	public int getVertical_grid_padding() {
		return vertical_grid_padding;
	}

	public int getHorizontal_grid_padding() {
		return horizontal_grid_padding;
	}

	public int getGrid_number_of_columns() {
		return grid_number_of_columns;
	}

	public int getGeneralPadding() {
		return generalPadding;
	}

	public Boolean getCameraExists() {
		return cameraExists;
	}

	public Boolean getBatteryExists() {
		return batteryExists;
	}

	public Boolean getArrowKeysExists() {
		return arrowKeysExists;
	}

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
