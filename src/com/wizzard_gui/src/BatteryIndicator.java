package com.wizzard_gui.src;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class BatteryIndicator extends StackPane {
	
	private double batteryPower = 80;
	
	//slider is the user input right now change it to read battery. 
    private Slider slider = new Slider(0,100,100); // min, max , current
    private ProgressBar pb = new ProgressBar(80);
    private Label label = new Label("100%");
    private HBox hb = new HBox();
    
    
	public BatteryIndicator() {
		slider.setMin(0);
		slider.setMax(50);
		
		pb.resize(pb.getWidth(), pb.getHeight() + 10);
		pb.setProgress(batteryPower / 100); // this is the bar that fills in
		
		label.setText(Integer.valueOf((int)batteryPower).toString() + "%");
		label.setId("label-black");
		
		hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll( pb); //slider,
        
        setAlignment(label,Pos.CENTER_RIGHT);
		setAlignment(hb,Pos.CENTER_RIGHT); // comment these out when you take the slider out
		getChildren().addAll(hb, label);
	}
	
	
	public Pane getPane()
	{
//        slider.valueProperty().addListener(new ChangeListener<Number>() {
//            public void changed(ObservableValue<? extends Number> ov,
//                Number old_val, Number new_val) {
//                pb.setProgress(new_val.doubleValue()/50); // this is the bar that fills in
//                Integer currentPercentage = new_val.intValue();
//                label.setText(currentPercentage.toString() + "%");
//                label.setId("label-black");
//            }
//        });
        

		
		return this;
	}
	
	
	
	public double getBatteryPower() {
		return batteryPower;
	}
	public void setBatteryPower(int batteryPower) {
		this.batteryPower = batteryPower;
		pb.setProgress(batteryPower / 100); // this is the bar that fills in
		label.setText(Integer.valueOf((int)batteryPower).toString() + "%");
	}
}
