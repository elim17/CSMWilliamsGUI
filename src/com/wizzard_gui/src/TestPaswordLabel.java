package com.wizzard_gui.src;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class TestPaswordLabel {
	public StackPane getPane()
	{	
		Label passwordLabel = new Label("Password");
		passwordLabel.setTextFill(Color.WHITE);
		StackPane layout = new StackPane(); // will put button right in the middle
		//layout.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(3.0), Insets.EMPTY)));        
		layout.getChildren().add(passwordLabel);
		return layout;
	}
}
