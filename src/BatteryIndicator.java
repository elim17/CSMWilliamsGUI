import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class BatteryIndicator {
	
	private double batteryPower = 80;
	public StackPane getStackPane()
	{
		
		
		//slider is the user input right now change it to read battery. 
        final Slider slider = new Slider(0,100,100); // min, max , current
        slider.setMin(0);
        slider.setMax(50);

        
         
        final ProgressBar pb = new ProgressBar(80);
        pb.resize(pb.getWidth(), pb.getHeight() + 10);
        final Label label = new Label("100%");
        

        
        
//        slider.valueProperty().addListener(new ChangeListener<Number>() {
//            public void changed(ObservableValue<? extends Number> ov,
//                Number old_val, Number new_val) {
//                pb.setProgress(new_val.doubleValue()/50); // this is the bar that fills in
//                Integer currentPercentage = new_val.intValue();
//                label.setText(currentPercentage.toString() + "%");
//                label.setId("label-black");
//            }
//        });
        
          pb.setProgress(batteryPower/100); // this is the bar that fills in
	      Integer currentPercentage = (int)batteryPower;
	      label.setText(currentPercentage.toString() + "%");
	      label.setId("label-black");
        
 
        final HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll( pb); //slider,
		
		
		
		StackPane layout = new StackPane(); // will put button right in the middle
		layout.setAlignment(label,Pos.CENTER_RIGHT);
		layout.setAlignment(hb,Pos.CENTER_RIGHT); // comment these out when you take the slider out
		layout.getChildren().addAll(hb, label);
		return layout;
	}
	public double getBatteryPower() {
		return batteryPower;
	}
	public void setBatteryPower(int batteryPower) {
		this.batteryPower = batteryPower;
	}
}
