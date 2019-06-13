package com.wizzard_gui.src;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoViewModule extends StackPane{

	private MediaPlayer player;
	private MediaView mediaView;
	private VBox vbox;

	public VideoViewModule() {
		vbox = new VBox();

		player = new MediaPlayer(new Media(getClass().getResource("fish.mp4").toExternalForm()));
		mediaView = new MediaView(player);
		// set the size

//    	DoubleProperty mvw = mediaView.fitWidthProperty();
//    	DoubleProperty mvh = mediaView.fitHeightProperty();
//    	mvw.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
//    	mvh.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
//    	mediaView.setPreserveRatio(true);

		Button playButton = new Button("Start");
		Button stopButton = new Button("Stop");

		playButton.setOnAction(e -> {
			player.play();
		});

		stopButton.setOnAction(e -> {
			player.stop();
		});

		vbox.getChildren().addAll(mediaView, playButton, stopButton);

		getChildren().add(vbox);

	}

	public Pane getPane() {

		return this;
	}

}
