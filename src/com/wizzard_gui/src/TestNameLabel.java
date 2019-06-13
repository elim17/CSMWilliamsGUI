package com.wizzard_gui.src;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TestNameLabel {
	public StackPane getPane()
	{
	Label nameLabel = new Label("Username:"); // make the object
	nameLabel.setTextFill(Color.RED);
	StackPane layout = new StackPane(); // will put button right in the middle
	layout.getChildren().add(nameLabel);
	return layout;
	}
}
