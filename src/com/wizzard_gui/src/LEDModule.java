package com.wizzard_gui.src;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class LEDModule extends StackPane{

	private Label label;
	private ComboBox<String> LEDSelector;
	
	public LEDModule() {
		label = new Label();
		label.setText("LED Color");
        LEDSelector = new ComboBox<String>();
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
        
        
        this.getChildren().add(vb);
	}
	
	public Pane getPane(){
        return this;
    
		
	}

}
