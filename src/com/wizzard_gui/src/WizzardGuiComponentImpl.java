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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WizzardGuiComponentImpl {
	
	private ControllerParams params;
	
	public WizzardGuiComponentImpl() {

		//reader = new ConfigReader();
	}
	
	public static void main(String[] args){
        WizzardGuiComponentImpl gui = new WizzardGuiComponentImpl();
        gui.init();
		
        System.out.println("after application thread started");
        
        
    }
	
	public void init() {
		new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(ControlerGridPane.class);
            }
        }.start();
        params = ControllerParams.getInstance();
	}
	
	

	
}
