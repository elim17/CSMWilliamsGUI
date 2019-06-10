import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;

public class randomPane extends Application{
	private static randomPane single_instance = getInstance();
    public Stage window;
    private ControllerParams p = ControllerParams.getInstance();
    public Scene scene;
    Boolean skyTheme  = false;
	public randomPane() {
		super();
	}

	public static void main(String[] args) {
		launch(args);
		randomPane r = new randomPane();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
        window.setTitle(p.windowTitle);
        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(p.grid_wall_padding)); // puts padding in-between the layout and the window.
        grid.setVgap(p.vertical_grid_padding); // puts padding in-between each vertical column
        grid.setHgap(p.horizontal_grid_padding); // puts padding in-between each horizontal row.
        
        //get objects off of module list
        ArrayList<StackPane> modules = p.getModules();
        
        int rowCounter = -1; // start at -1 to account for the first time the col is 0;
        for(int i=0; i < modules.size(); ++i)
        {
        	StackPane module = modules.get(i);
        	int col = i%p.grid_number_of_columns;
        	if (col ==0) // when the column gets back to 0 it will increment the row Counter
        	{
        		rowCounter ++;
        	}
        		
        	GridPane.setConstraints(module,col,rowCounter); //column, row
        		
            
        }
        
        
        for(StackPane module : modules)
        {
        	grid.getChildren().add(module);
        	
        }
        
        
        //make the scene
        scene = new Scene(grid, p.window_width, p.window_hight);
        //scene.getStylesheets().add("SkyTheme.css");
        window.setScene(scene);
        window.show();
		
	}
	
	public static randomPane getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new randomPane(); 
  
        return single_instance; 
    } 

}
