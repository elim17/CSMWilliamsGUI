

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ImageArrowKeys {
	ControllerParams p = ControllerParams.getInstance();
	
	
	Button forwardButton;
	Button backwardButton;
	Button rightButton;
	Button leftButton;
	Button useKeyPadButton;
	Boolean keypadHover = false;
	
	
	public StackPane getStackPane()
	{
		
		//make 4 buttons for forward, back, right and left. 
		forwardButton = new Button();
		backwardButton = new Button();
		rightButton = new Button();
		leftButton = new Button();
		
		
		//Originally disable the buttons
    	forwardButton.setDisable(true);
		backwardButton.setDisable(true);
		rightButton.setDisable(true);
		leftButton.setDisable(true);
//		useKeyPadButton = new Button();
		
		//set text
//		forwardButton.setText("Forward");
//		backwardButton.setText("Backward");
//		rightButton.setText("Right");
//		leftButton.setText("Left");
//		useKeyPadButton.setText("Keyboard");
		
		//set image for arrow
		 Image image = new Image(getClass().getResourceAsStream("circleArrow.png"));
//		 ImageView imageView = new ImageView(image);
//		 imageView.setFitHeight(100);
//	     imageView.setFitWidth(100);
//	     imageView.setPreserveRatio(true); //By default, it will not preserve the width:height ratio so we can do that with set Preserve ratio
		 ImageView forwardView = getAndRotateImage(image, 270, 50, 50);
		 ImageView backView = getAndRotateImage(image, 90, 50, 50);
		 ImageView leftView = getAndRotateImage(image, 180, 50, 50);
		 ImageView rightView = getAndRotateImage(image, 0, 50, 50);
				 
//		forwardButton.setRotate(270);
//		backwardButton.setRotate(90);
//		leftButton.setRotate(180);
	     
	     //set and rotate the image 
	     forwardButton.setGraphic(forwardView);
	     rightButton.setGraphic(rightView);
	     backwardButton.setGraphic(backView);
	     leftButton.setGraphic(leftView);
	     

	     
		
			//set click listeners
			forwardButton.setOnAction(e -> {//System.out.println("robot move forward");
			  moveForward();
			
			  });
			
			backwardButton.setOnAction(e -> {//System.out.println("robot move backwards");
			  moveBackward();
			  });
			
			rightButton.setOnAction(e -> {//System.out.println("robot turn right");
			  turnRight();
			  });
			
			leftButton.setOnAction(e -> {//System.out.println("robot turn left");
			  turnLeft();
			  });
			
//			useKeyPadButton.setOnAction(e -> {System.out.println("Change to Keyboard");
//					if(!keypadButtonPressed)
//					{
//							keypadButtonPressed = true;
//							useKeyPadButton.setText("Screen");
//							
//							// disable the other buttons
//							forwardButton.setDisable(true);
//							backwardButton.setDisable(true);
//							rightButton.setDisable(true);
//							leftButton.setDisable(true);
//							
//							useKeyArrows();
//							
//					}
//					else // the button is pressed so we need to use the keys on the keyboard
//					{
//						
//						  
//							keypadButtonPressed = false;
//							useKeyPadButton.setText("Keyboard");
//							forwardButton.setDisable(false);
//							backwardButton.setDisable(false);
//							rightButton.setDisable(false);
//							leftButton.setDisable(false);
//							useKeyArrows();
//					}
//			  });
		
		
		
		// make layout 
		GridPane grid = new GridPane();
        grid.setPadding(new Insets(p.grid_wall_padding, p.grid_wall_padding, p.grid_wall_padding, p.grid_wall_padding)); // puts padding in-between the layout and the window.
        grid.setVgap(p.vertical_grid_padding); // puts padding in-between each vertical column
        grid.setHgap(p.horizontal_grid_padding); // puts padding in-between each horizontal row.

        // set constraints on buttons
        
        GridPane.setConstraints(forwardButton, 1, 0);
        GridPane.setConstraints(backwardButton, 1, 2);
        GridPane.setConstraints(rightButton, 2, 1);
        GridPane.setConstraints(leftButton, 0, 1);
//        GridPane.setConstraints(useKeyPadButton, 1, 4);
		
        grid.getChildren().addAll(forwardButton, backwardButton, leftButton, rightButton/*, useKeyPadButton*/);
        
        StackPane layout = new StackPane(); // will put button right in the middle
        layout.setOnMouseExited(e -> 
        {
        	keypadHover = false;
        	layout.getParent().requestFocus();
        	forwardButton.setDisable(true);
			backwardButton.setDisable(true);
			rightButton.setDisable(true);
			leftButton.setDisable(true);
		});
        
        layout.setOnMouseEntered(e ->
        {
        	keypadHover = true;
        	layout.requestFocus();
        	forwardButton.setDisable(false);
			backwardButton.setDisable(false);
			rightButton.setDisable(false);
			leftButton.setDisable(false);
        });
		layout.getChildren().add(grid);
		
		layout.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
//				if(!keypadHover)
//				{
//				//	return; // this will skip the key presses if outside of the arrow module
//				}
				switch (ke.getCode()) {
				case UP:
					moveForward();
					break;
				case DOWN:
					moveBackward();
					break;
				case LEFT:
					turnLeft();
					break;
				case RIGHT:
					turnRight();
					break;
				}
				
				ke.consume();
			}
        });
		return layout;
	}
	
//	private void useKeyArrows()
//	{
//
//            public void keyPressed(KeyEvent e) {
//            	switch (e.getCode()) {
//                case DOWN:
//                    System.out.println("Down arrow");
//                    break;
//                case UP:
//                	System.out.println("Up arrow");
//                    break;
//                case RIGHT:
//                	System.out.println("Left arrow");
//                    break;
//                case LEFT:
//                	System.out.println("Right arrow");
//                    break;
//            }
//            
//        }
//		
//	}
	
	
	private void moveForward() {
		System.out.println("up");
	}

	private void moveBackward() {
		System.out.println("back");
	}

	private void turnLeft() {
		System.out.println("left");
	}

	private void turnRight() {
		System.out.println("right");
	}

	private ImageView getAndRotateImage(Image image, int degrees, int fitHeight, int fitWidth) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(fitHeight);
		imageView.setFitWidth(fitHeight);
	    imageView.setPreserveRatio(true); //By default, it will not preserve the width:height ratio so we can do that with set Preserve ratio
		imageView.setRotate(degrees);    
		return imageView;
	}


	
}