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

public class TestNameLabel {
	public StackPane getStackPane()
	{
	Label nameLabel = new Label("Username:"); // make the object
	nameLabel.setTextFill(Color.RED);
	StackPane layout = new StackPane(); // will put button right in the middle
	layout.getChildren().add(nameLabel);
	return layout;
	}
}
