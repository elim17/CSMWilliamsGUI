import javax.swing.text.Position;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class ArrowKeysModue {
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
		
		
		//style the buttons // fix me- this is not working?
		
		forwardButton.getStyleClass().add("button-arrow");
		backwardButton.getStyleClass().add("button-arrow");
		rightButton.getStyleClass().add("button-arrow");
		leftButton.getStyleClass().add("button-arrow");
		

		
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
		
		

        
		StackPane stackPane = new StackPane(); // will put button right in the middle
		stackPane.setPadding(new Insets(10,10,10,10));
		
		stackPane.setAlignment(forwardButton,Pos.TOP_CENTER );
		stackPane.setAlignment(rightButton, Pos.CENTER_RIGHT);
		stackPane.setAlignment(backwardButton, Pos.BOTTOM_CENTER);
		stackPane.setAlignment(leftButton, Pos.CENTER_LEFT);
		stackPane.setAlignment(useKeyPadButton, Pos.CENTER);
		
		
		// rotate the appropriate buttons
		forwardButton.setRotate(270);
		backwardButton.setRotate(90);
		leftButton.setRotate(180);
		
		//set padding
		forwardButton.setPadding(new Insets(10,10,10,10));
		backwardButton.setPadding(new Insets(10,10,10,10));
		rightButton.setPadding(new Insets(10,10,10,10));
		leftButton.setPadding(new Insets(10,10,10,10));
		useKeyPadButton.setPadding(new Insets(10,10,10,10));
		
//		stackPane.setMargin(forwardButton, new Insets(10,10,10,10));
//		stackPane.setMargin(rightButton, new Insets(10, 10, 10, 10));
//		stackPane.setMargin(backwardButton, new Insets(10, 10, 10, 10));
//		stackPane.setMargin(leftButton, new Insets(10, 10, 10, 10));
//		stackPane.setMargin(useKeyPadButton, new Insets(10, 10, 10, 10));
		
		stackPane.getChildren().addAll(forwardButton, backwardButton, rightButton, leftButton, useKeyPadButton); 
		
		
		return stackPane;
	}
	
	private Boolean useKeyArrows()
	{
		
		
		return true;
	}
	
}
