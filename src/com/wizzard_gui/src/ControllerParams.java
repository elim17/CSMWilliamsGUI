package com.wizzard_gui.src;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ControllerParams {
	
	private static ControllerParams single_instance = getInstance(); // singleton object
	private ControllerParams(){} // singleton private constructor
	
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
	
	String configFileName = "./src/ConfigureController.txt";	// need to have some of the path for it to work
	
	
	ArrayList <String> modulesToInstanmoduletiate = configParser.getClassesToInstantiate();
	ArrayList<Pane> controller_module_list;
	
	// start to make objects for all the classes //////////////////////////////////////
	 TestNameField testNameField;
	 TestNameLabel testNameLabel; 
	 TestPaswordInput testpInput; 
	 ThemeChangeMenue themeMenu;  
	 ImageArrowKeys imageKeys;
	 TestPaswordLabel testpL; 
	 VideoViewModule  vm; 
	 CameraViewModule cm; 
	 BatteryIndicator bI;
	 LEDModule lM;
	
	
	public ArrayList<Pane> getModules() {
		
		
	
	// Make the arraylist
	controller_module_list = new ArrayList<Pane>();
	//make the correct objects 
	specialObjectIntantiater(); // if adding things to this, you need to change the layout in the grid pane
	
	//make stuff to go into the grid pane.
	objectInstantiater();
	 
	 		
		return controller_module_list;
	}
	


	public void readConfig() // gets called by main in grid pane
	{
		configParser.readFile(configFileName); // file name stored in this file
	}
	
	private void specialObjectIntantiater() {
		//for special placed objects
		//index 0 has to be camera view
		//index 1 has to be battery indicator
		// index 2 has to be the arrow keys
		for (String module : modulesToInstanmoduletiate) {
			
			System.out.println(module);
			
			if(module.equals("CameraViewModule"))
			{ 
				
			  cm = CameraViewModule.getInstance();
			  controller_module_list.add(cm.getStackPane());
			  cameraExists = true;
			}
			if(module.equals("BatteryIndicator"))
			{		  
			  bI = new BatteryIndicator();
			  controller_module_list.add(bI.getPane());
			  batteryExists = true;
			}

			if(module.equals("ImageArrowKeys"))
			{ 
			 imageKeys = new ImageArrowKeys();
			 controller_module_list.add(imageKeys.getPane());
			 arrowKeysExists = true;
			}
		}
	}
	
	//determines which classes will continue to be instantiated in the grid pane.
	private void objectInstantiater()
	{
		for (String module : modulesToInstanmoduletiate) {
			if(module.equals("TestNameField") )
			{
				 testNameField = new TestNameField();
				 controller_module_list.add(testNameField.getPane());
			}
			if(module.equals("TestNameLabel"))
			{
				testNameLabel = new TestNameLabel();
				controller_module_list.add(testNameLabel.getPane());
			}
			if(module.equals("LEDModule"))
			{
				lM = new LEDModule();
				controller_module_list.add(lM.getPane());
			}
			if(module.equals("VideoViewModule"))
			{
			  vm = new VideoViewModule();
			  controller_module_list.add(vm.getPane());
			}

			
		}
	}
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////
	//getters and setters

	
	
	
	
	//////////////////////////////////////////////////////////////
	//singleton stuff
	
	
	public static ControllerParams getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new ControllerParams(); 
  
        return single_instance; 
    } 

	
	
}
