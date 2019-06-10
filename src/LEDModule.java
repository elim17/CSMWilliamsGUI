import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LEDModule{

	
	public StackPane getStackPane(){
		Label label = new Label();
		label.setText("LED Color");
        ComboBox LEDSelector = new ComboBox();
        LEDSelector.getItems().addAll(
            "Off",
            "Red",
            "Orange",
            "Green"
        );
        LEDSelector.setValue("Off");
        
        VBox vb = new VBox();
        
        vb.getChildren().add(label);
        vb.getChildren().add(LEDSelector);
        
        StackPane layout = new StackPane();
        
        layout.getChildren().add(vb);
        
        
        return layout;
    
		
	}

}
