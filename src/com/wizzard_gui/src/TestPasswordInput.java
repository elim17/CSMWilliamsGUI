package com.wizzard_gui.src;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class TestPasswordInput extends StackPane {

	private TextField passInput;

	public TestPasswordInput() {
		passInput = new TextField();
		passInput.setPromptText("Password"); // gray indicator that disappears on click.
		getChildren().add(passInput);
	}

	public Pane getPane() {
		return this;
	}
}
