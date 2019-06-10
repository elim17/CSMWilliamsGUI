import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class TestPaswordInput {
	public StackPane getStackPane()
	{
		TextField passInput = new TextField();
        passInput.setPromptText("Password"); // gray indicator that disappears on click.
		 
		StackPane layout = new StackPane(); // will put button right in the middle
		layout.getChildren().add(passInput);
		return layout;
	}
}
