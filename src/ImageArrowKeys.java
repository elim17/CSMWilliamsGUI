

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class ImageArrowKeys {
	ControllerParams p = ControllerParams.getInstance();
	
	
	Button forwardButton;
	Button backwardButton;
	Button rightButton;
	Button leftButton;
	
	
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
				 
	     //set and rotate the image 
	     forwardButton.setGraphic(forwardView);
	     rightButton.setGraphic(rightView);
	     backwardButton.setGraphic(backView);
		leftButton.setGraphic(leftView);

		// set click listeners for arrow buttons
		forwardButton.setOnAction(e -> {
			moveForward();

		});

		backwardButton.setOnAction(e -> {
			moveBackward();
		});

		rightButton.setOnAction(e -> {
			turnRight();
		});

		leftButton.setOnAction(e -> {
			turnLeft();
		});

		
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
		
        grid.getChildren().addAll(forwardButton, backwardButton, leftButton, rightButton);
        
        StackPane layout = new StackPane(); // will put button right in the middle
        layout.setOnMouseExited(e -> 
        {
        	layout.getParent().requestFocus();
        	forwardButton.setDisable(true);
			backwardButton.setDisable(true);
			rightButton.setDisable(true);
			leftButton.setDisable(true);
		});
        
        layout.setOnMouseEntered(e ->
        {
        	layout.requestFocus();
        	forwardButton.setDisable(false);
			backwardButton.setDisable(false);
			rightButton.setDisable(false);
			leftButton.setDisable(false);
        });
		layout.getChildren().add(grid);
		
		layout.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {

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
				default:
					break;
				}
				
				ke.consume();
			}
        });
		return layout;
	}
	

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