package com.wizzard_gui.src;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class TestNameField extends StackPane{

	private TextField nameInput;

	public TestNameField() {
		nameInput = new TextField("John Doe");
		getChildren().add(nameInput);
	}

	public Pane getPane() {

		return this;
	}
}
