package com.wizzard_gui.src;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class ControlerGridPane extends Application {
	
    public Stage window;
    private static ControllerParams p;
    public Scene scene;
    Boolean skyTheme  = false;
    private VBox vBox = new VBox();
    private HBox hBox = new HBox();
    private VBox verticalLayout = new VBox();
    
    public ControlerGridPane(){
    	p = ControllerParams.getInstance();
    }
    
    public static void main(String[] args) {
    	//configure using the config file
    	//ControlerGridPane cgp = new ControlerGridPane();
    	launch(args);
    	System.out.println("in main method");
    	
    }

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle(p.windowTitle);
        window.setOnCloseRequest(e -> closeWindow()); // calls function for cleaning up after closing via red x in window. 
        //GridPane with 10px padding around edge
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(p.grid_wall_padding)); // puts padding in-between the layout and the window.
        grid.setVgap(p.vertical_grid_padding); // puts padding in-between each vertical column
        grid.setHgap(p.horizontal_grid_padding); // puts padding in-between each horizontal row.
        
        vBox.setPadding(new Insets(p.generalPadding));
        hBox.setPadding(new Insets(p.generalPadding));
        //get objects off of module list
        ArrayList<Pane> modules = p.getModules();
        
        //add the camera view if it exists
        if(cameraViewExists())
        {
        	vBox.getChildren().add(modules.get(0)); // make sure that the Camera is added first in the 0 index
        	modules.get(0).setPadding(new Insets(p.generalPadding));
        	modules.remove(0);
        }
        
        //add the battery indicator if it exits 
        if(batteryIndicatorExists())
        {
        	verticalLayout.getChildren().add(modules.get(0)); // make sure battery is in 1 index
        	modules.get(0).setPadding(new Insets(p.generalPadding));
        	modules.remove(0);
        }
        
        //add the keyPad if it exits 
        if(keyPadExists())
        {
        	verticalLayout.getChildren().add(modules.get(0));  // make sure keypad is in 2 index
        	modules.get(0).setPadding(new Insets(p.generalPadding));
        	modules.remove(0);
        }
        
        int rowCounter = -1; // start at -1 to account for the first time the col is 0;
        for(int i=0; i < modules.size(); ++i)
        {
        	Pane module = modules.get(i);
        	module.setPadding(new Insets(p.generalPadding));
        	int col = i%p.grid_number_of_columns;
        	if (col ==0) // when the column gets back to 0 it will increment the row Counter
        	{
        		rowCounter ++;
        	}
        		
        	GridPane.setConstraints(module,col,rowCounter); //column, row
        		
            
        }
        
        
        for(Pane module : modules)
        {
        	grid.getChildren().add(module);
        	
        }
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().addAll(grid, verticalLayout);
        vBox.getChildren().add(hBox);
        //make the scene
        scene = new Scene(vBox, p.window_width, p.window_hight);
        scene.getStylesheets().add("../../../SkyTheme.css");
        window.setScene(scene);
        window.show();
    }
    
    // check if there is a camera view and set it to the top of the Vbox 
    private Boolean  cameraViewExists()
    {
    	if(p.cameraExists)
    	{
    	   	return true;
    	}
    	else 
    	{
    		return false;
    	}
    }
    
    private Boolean  batteryIndicatorExists()
    {
    	if(p.batteryExists){
    		return true;
    	}
    	else {
    		return false;
		}
    }
    
    private Boolean  keyPadExists()
    {
    	if(p.arrowKeysExists){
    		return true;
    	}
    	else {
    		return false;
		}
    }
    
    private void closeWindow() 
    {
    	// closeWindow
    	if(cameraViewExists())
    	{
    		CameraViewModule cm = CameraViewModule.getInstance();
    		System.out.println("right before close");
    		System.out.println("right after close");
    		cm.getWebcam().close();  //If this is run on mac, take this out
			cm.getWebcamPanel().stop();
    		cm.getWebcam().removeWebcamListener(cm.getWebcamPanel()); // ADD THIS LINE

    		//cm.obsBoolean.set(true);
    	}
    	window.close();
    }
    
    
	
	

}