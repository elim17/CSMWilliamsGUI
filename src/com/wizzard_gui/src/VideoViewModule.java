package com.wizzard_gui.src;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoViewModule {

	public Pane getPane()
	{	
        
		VBox vbox = new VBox();
		
        MediaPlayer player = new MediaPlayer( new Media(getClass().getResource("fish.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(player);
        //set the size 
        
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
    	
    	
        vbox.getChildren().addAll( mediaView, playButton, stopButton);

        
       
        StackPane root = new StackPane();
        root.getChildren().add(vbox);
        
       
        
        
        return root;
	}

}
