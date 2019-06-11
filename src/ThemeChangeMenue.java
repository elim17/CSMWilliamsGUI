import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ThemeChangeMenue{
	
	//ControlerGridPane gui = ControlerGridPane.getInstance();

    public StackPane getStackPane()
    {

       Button button =  new Button("Set Theame");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        //getItems returns the ObservableList object which you can add items to
        choiceBox.getItems().add("Normal");
        choiceBox.getItems().add("Sky");

        //Set a default value
        choiceBox.setValue("Normal");

        button.setOnAction(e -> getChoice(choiceBox));
        


        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.getChildren().addAll(choiceBox, button);


        StackPane layout = new StackPane(); // will put button right in the middle
		layout.getChildren().add(vBox);
		return layout;
    }

    //To get the value of the selected item
    private void getChoice(ChoiceBox<String> choiceBox){
        String theme = choiceBox.getValue();
        System.out.println(theme);
        //gui.scene.getStylesheets().add("SkyTheme.css");
    }


}