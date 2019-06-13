package com.wizzard_gui.src;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ThemeChangeMenu extends StackPane {

	// ControlerGridPane gui = ControlerGridPane.getInstance();

	private Button button;
	private ChoiceBox<String> choiceBox;
	private VBox vBox;

	public ThemeChangeMenu() {
		button = new Button("Set Theme");

		choiceBox = new ChoiceBox<>();

		// getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().add("Normal");
		choiceBox.getItems().add("Sky");

		// Set a default value
		choiceBox.setValue("Normal");

		button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				getChoice(choiceBox);
			}
		});

		vBox = new VBox(10);
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.getChildren().addAll(choiceBox, button);

		getChildren().add(vBox);
	}

	public Pane getPane() {

		return this;
	}

	// To get the value of the selected item
	private void getChoice(ChoiceBox<String> choiceBox) {
		String theme = choiceBox.getValue();
		System.out.println(theme);
		// gui.scene.getStylesheets().add("SkyTheme.css");
	}

}