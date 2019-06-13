package com.wizzard_gui.src;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TestNameLabel extends StackPane {

	private Label nameLabel;

	public TestNameLabel() {
		nameLabel = new Label("Username:"); // make the object
		nameLabel.setTextFill(Color.RED);
		getChildren().add(nameLabel);
	}

	public Pane getPane() {
		return this;
	}
}
