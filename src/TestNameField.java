import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

public class TestNameField {
	
	public StackPane getStackPane()
	{
	TextField nameInput = new TextField("John Doe");
	StackPane layout = new StackPane(); // will put button right in the middle
	layout.getChildren().add(nameInput);
	return layout;
	}
}
