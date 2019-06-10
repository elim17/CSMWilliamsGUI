import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


import java.util.ArrayList;


public class TestPaswordLabel {
	public StackPane getStackPane()
	{	
		Label passwordLabel = new Label("Password");
		passwordLabel.setTextFill(Color.WHITE);
		StackPane layout = new StackPane(); // will put button right in the middle
		//layout.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(3.0), Insets.EMPTY)));        
		layout.getChildren().add(passwordLabel);
		return layout;
	}
}
