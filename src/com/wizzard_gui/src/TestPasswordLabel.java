package com.wizzard_gui.src;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TestPasswordLabel extends StackPane {

	private Label passwordLabel;

	public TestPasswordLabel() {
		passwordLabel = new Label("Password");
		passwordLabel.setTextFill(Color.WHITE);
		getChildren().add(passwordLabel);
	}

	public Pane getPane() {
		return this;
	}
}
