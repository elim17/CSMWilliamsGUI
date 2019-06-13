package com.wizzard_gui.src;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
	private ImageArrowKeys keys;
	
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
        
        ArrayList<Pane> modules = params.getModules();
        
        for(Pane module: modules) {
        	if(module instanceof ImageArrowKeys) {
        		keys = (ImageArrowKeys)module;
        	}
        }
        
        while(params.getArrowKeysExists()) {
        	boolean[] dirs = keys.getDirections();
        	//System.out.println("for: "+ dirs[0]+ " back: "+ dirs[1] + " left: " + dirs[2] + " right: " + dirs[3]);
        }
        
	}
	
	

	
}
