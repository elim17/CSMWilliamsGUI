package com.wizzard_gui.src;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class TestPaswordInput {
	public Pane getPane()
	{
		TextField passInput = new TextField();
        passInput.setPromptText("Password"); // gray indicator that disappears on click.
		 
		StackPane layout = new StackPane(); // will put button right in the middle
		layout.getChildren().add(passInput);
		return layout;
	}
}
