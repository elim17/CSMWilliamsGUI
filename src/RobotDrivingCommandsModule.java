import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class RobotDrivingCommandsModule {
	ControllerParams p = ControllerParams.getInstance();
	
	
	Button forwardButton;
	Button backwardButton;
	Button rightButton;
	Button leftButton;
	Button useKeyPadButton;
	Boolean keypadButtonPressed = false;
	
	public StackPane getStackPane()
	{
		
		//make 4 buttons for forward, back, right and left. 
		forwardButton = new Button();
		backwardButton = new Button();
		rightButton = new Button();
		leftButton = new Button();
		useKeyPadButton = new Button();
		
		//set text
		forwardButton.setText("Forward");
		backwardButton.setText("Backward");
		rightButton.setText("Right");
		leftButton.setText("Left");
		useKeyPadButton.setText("Keyboard");
		
		

		
			//set click listeners
			forwardButton.setOnAction(e -> {System.out.println("robot move forward");
			  //System.out.println("multiple lines of code in it!");
				//todo: call function for moving forward
			
			  });
			
			backwardButton.setOnAction(e -> {System.out.println("robot move backwards");
			  //System.out.println("multiple lines of code in it!");
				//todo: call function for moving backwards
			  });
			
			rightButton.setOnAction(e -> {System.out.println("robot turn right");
			  //System.out.println("multiple lines of code in it!");
					//todo: call function for moving right
			  });
			
			leftButton.setOnAction(e -> {System.out.println("robot turn left");
			  //System.out.println("multiple lines of code in it!");
					//todo: call function for moving left
			  });
			
			useKeyPadButton.setOnAction(e -> {System.out.println("Change to Keyboard");
					if(!keypadButtonPressed)
					{
							keypadButtonPressed = true;
							useKeyPadButton.setText("Screen");
							
							// disable the other buttons
							forwardButton.setDisable(true);
							backwardButton.setDisable(true);
							rightButton.setDisable(true);
							leftButton.setDisable(true);
							
							useKeyArrows();
							
					}
					else // the button is pressed so we need to use the keys on the keyboard
					{
						
						  //System.out.println("multiple lines of code in it!");
							keypadButtonPressed = false;
							useKeyPadButton.setText("Keyboard");
							forwardButton.setDisable(false);
							backwardButton.setDisable(false);
							rightButton.setDisable(false);
							leftButton.setDisable(false);
						 
					}
			  });
		
		
		
		// make layout 
		GridPane grid = new GridPane();
        grid.setPadding(new Insets(p.grid_wall_padding, p.grid_wall_padding, p.grid_wall_padding, p.grid_wall_padding)); // puts padding in-between the layout and the window.
        grid.setVgap(p.vertical_grid_padding); // puts padding in-between each vertical column
        grid.setHgap(p.horizontal_grid_padding); // puts padding in-between each horizontal row.

        // set constraints on buttons
        
        GridPane.setConstraints(forwardButton, 1, 0);
        GridPane.setConstraints(backwardButton, 1, 2);
        GridPane.setConstraints(rightButton, 0, 1);
        GridPane.setConstraints(leftButton, 2, 1);
        GridPane.setConstraints(useKeyPadButton, 1, 4);
		
        grid.getChildren().addAll(forwardButton, backwardButton, leftButton, rightButton, useKeyPadButton);
        
		StackPane layout = new StackPane(); // will put button right in the middle
		layout.getChildren().add(grid);
		return layout;
	}
	
	private Boolean useKeyArrows()
	{
		
		
		return true;
	}
	
}
