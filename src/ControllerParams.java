import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllerParams {
	
	private static ControllerParams single_instance = getInstance(); // singleton object
	private ControllerParams(){} // singleton private constructor
	
	ConfigFileParser configParser = new ConfigFileParser();	
	int window_width = 1000;
	int window_hight = 1000;
	String windowTitle = "Controller";
	
	int grid_wall_padding = 10;
	int vertical_grid_padding = 5;
	int horizontal_grid_padding = 5;
	int grid_number_of_columns = 4;
	
	Boolean cameraExists = false;
	Boolean batteryExists = false;
	Boolean arrowKeysExists = false;
	
	String configFileName = "./src/ConfigureController.txt";	// need to have some of the path for it to work
	
	
	ArrayList <String> modulesToInstanmoduletiate = configParser.getClassesToInstantiate();
	ArrayList<StackPane> controller_module_list;
	
	// start to make objects for all the classes //////////////////////////////////////
	 TestNameField testNameField;
	 TestNameLabel testNameLabel; 
	 TestPaswordInput testpInput; 
	 ThemeChangeMenue themeMenu; 
	 RobotDrivingCommandsModule driver; 
	 ArrowKeysModue arrowKeys; 
	 ImageArrowKeys imageKeys;
	 TestPaswordLabel testpL; 
	 VideoViewModule  vm; 
	 CameraViewModule cm; 
	 BatteryIndicator bI;
	 LEDModule lM;
	
	
	public ArrayList<StackPane> getModules() {
		
		
	
	// Make the arraylist
	controller_module_list = new ArrayList<StackPane>();
	//make the correct objects 
	specialObjectIntantiater(); // if adding things to this, you need to change the layout in the grid pane
	
	//make stuff to go into the grid pane.
	objectInstantiater();
	 
	 
	// add the stack pane holders from all the different modules to the module list.	
		//// indexes 0-2
		//controller_module_list.add(vm.getStackPane());
	 
//	 	cm = CameraViewModule.getInstance();
//		controller_module_list.add(cm.getStackPane());
//		bI = new BatteryIndicator();
//		controller_module_list.add(bI.getStackPane());
//		imageKeys = new ImageArrowKeys();
//		controller_module_list.add(imageKeys.getStackPane());
	



		
		return controller_module_list;
	}
	


	public void readConfig() throws FileNotFoundException // gets called by main in grid pane
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
			
			
//			if(module.equals("VideoViewModule"))
//			{
//			  vm = new VideoViewModule();
//			  controller_module_list.add(vm.getStackPane());
//			}
			if(module.equals("CameraViewModule"))
			{ 
				
			  cm = CameraViewModule.getInstance();
			  controller_module_list.add(cm.getStackPane());
			  cameraExists = true;
			}
			if(module.equals("BatteryIndicator"))
			{		  
			  bI = new BatteryIndicator();
			  controller_module_list.add(bI.getStackPane());
			  batteryExists = true;
			}
//			if(module.equals("RobotDrivingCommandsModule"))
//			{
//			  driver = new RobotDrivingCommandsModule();
//			  controller_module_list.add(driver.getStackPane());
//			}
//			if(module.equals("ArrowKeysModue"))
//			{
//			 arrowKeys = new ArrowKeysModue();
//			 controller_module_list.add(arrowKeys.getStackPane());
//			}
			if(module.equals("ImageArrowKeys"))
			{ 
			 imageKeys = new ImageArrowKeys();
			 controller_module_list.add(imageKeys.getStackPane());
			 arrowKeysExists = true;
			}
		}
	}
	
	//determines which classes will continue to be instantiated.
	private void objectInstantiater()
	{
		for (String module : modulesToInstanmoduletiate) {
			if(module.equals("TestNameField") )
			{
				 testNameField = new TestNameField();
				 controller_module_list.add(testNameField.getStackPane());
			}
			if(module.equals("TestNameLabel"))
			{
				testNameLabel = new TestNameLabel();
				controller_module_list.add(testNameLabel.getStackPane());
			}
			if(module.equals("LEDModule"))
			{
				lM = new LEDModule();
				controller_module_list.add(lM.getStackPane());
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
