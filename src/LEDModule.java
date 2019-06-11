import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class LEDModule{

	
	public StackPane getStackPane(){
		Label label = new Label();
		label.setText("LED Color");
        ComboBox<String> LEDSelector = new ComboBox<String>();
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
