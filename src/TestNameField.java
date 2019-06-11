import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class TestNameField {
	
	public StackPane getStackPane()
	{
	TextField nameInput = new TextField("John Doe");
	StackPane layout = new StackPane(); // will put button right in the middle
	layout.getChildren().add(nameInput);
	return layout;
	}
}
