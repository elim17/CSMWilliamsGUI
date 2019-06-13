package com.wizzard_gui.src;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ImageArrowKeys extends StackPane {
	ControllerParams p = ControllerParams.getInstance();

	Button forwardButton;
	Button backwardButton;
	Button rightButton;
	Button leftButton;
	GridPane grid;

	public ImageArrowKeys() {
		// make 4 buttons for forward, back, right and left.
		forwardButton = new Button();
		backwardButton = new Button();
		rightButton = new Button();
		leftButton = new Button();

		// Originally disable the buttons
		forwardButton.setDisable(true);
		backwardButton.setDisable(true);
		rightButton.setDisable(true);
		leftButton.setDisable(true);
		// set image for arrow
		Image image = new Image(getClass().getResourceAsStream("../../../circleArrow.png"));
//		ImageView imageView = new ImageView(image);
//		imageView.setFitHeight(100);
//		imageView.setFitWidth(100);
//		imageView.setPreserveRatio(true); //By default, it will not preserve the width:height ratio so we can do that with set Preserve ratio
		ImageView forwardView = getAndRotateImage(image, 270, 50, 50);
		ImageView backView = getAndRotateImage(image, 90, 50, 50);
		ImageView leftView = getAndRotateImage(image, 180, 50, 50);
		ImageView rightView = getAndRotateImage(image, 0, 50, 50);

		// set and rotate the image
		forwardButton.setGraphic(forwardView);
		rightButton.setGraphic(rightView);
		backwardButton.setGraphic(backView);
		leftButton.setGraphic(leftView);

		grid = new GridPane();
		// make layout

		grid.setPadding(new Insets(p.grid_wall_padding, p.grid_wall_padding, p.grid_wall_padding, p.grid_wall_padding)); // puts
																															// padding
																															// in-between
																															// the
																															// layout
																															// and
																															// the
																															// window.
		grid.setVgap(p.vertical_grid_padding); // puts padding in-between each vertical column
		grid.setHgap(p.horizontal_grid_padding); // puts padding in-between each horizontal row.
		// set constraints on buttons

		GridPane.setConstraints(forwardButton, 1, 0);
		GridPane.setConstraints(backwardButton, 1, 2);
		GridPane.setConstraints(rightButton, 2, 1);
		GridPane.setConstraints(leftButton, 0, 1);
		setBehavior();
		grid.getChildren().addAll(forwardButton, backwardButton, leftButton, rightButton);
		this.getChildren().add(grid);
	}

	public Pane getPane() {

		return this;
	}

	private void setBehavior() {
		// set click listeners for arrow buttons

		forwardButton.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				moveForward();
			}
		});
		forwardButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stopForward();
			}
		});
		
		backwardButton.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				moveBackward();
			}
		});
		backwardButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stopBackward();
			}
		});
		
		rightButton.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				turnRight();
			}
		});
		rightButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stopRight();
			}
		});
		
		leftButton.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				turnLeft();
			}
		});
		leftButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				stopLeft();
			}
		});

		this.setOnMouseExited(e -> {
			this.getParent().requestFocus();
			forwardButton.setDisable(true);
			backwardButton.setDisable(true);
			rightButton.setDisable(true);
			leftButton.setDisable(true);
		});

		this.setOnMouseEntered(e -> {
			this.requestFocus();
			forwardButton.setDisable(false);
			backwardButton.setDisable(false);
			rightButton.setDisable(false);
			leftButton.setDisable(false);
		});

		this.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
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

		this.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {

				switch (ke.getCode()) {
				case UP:
					stopForward();
					break;
				case DOWN:
					stopBackward();
					break;
				case LEFT:
					stopLeft();
					break;
				case RIGHT:
					stopRight();
					break;
				default:
					break;
				}

				ke.consume();
			}
		});
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
	
	private void stopForward() {
		System.out.println("stop up");
	}

	private void stopBackward() {
		System.out.println("stop back");
	}

	private void stopLeft() {
		System.out.println("stop left");
	}

	private void stopRight() {
		System.out.println("stop right");
	}

	private ImageView getAndRotateImage(Image image, int degrees, int fitHeight, int fitWidth) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(fitHeight);
		imageView.setFitWidth(fitHeight);
		imageView.setPreserveRatio(true); // By default, it will not preserve the width:height ratio so we can do that
											// with set Preserve ratio
		imageView.setRotate(degrees);
		return imageView;
	}

}