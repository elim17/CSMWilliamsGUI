package com.wizzard_gui.src;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WizzardGuiComponentImpl {

	public static void main(String[] args){
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(ControlerGridPane.class);
            }
        }.start();
        
        
    }
}
