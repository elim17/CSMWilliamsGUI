package com.wizzard_gui.src;
import javax.swing.SwingUtilities;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javafx.embed.swing.SwingNode;
import javafx.scene.layout.StackPane;

public class CameraViewModule {
	private static CameraViewModule single_instance = getInstance(); // singleton object
	private CameraViewModule(){} // singleton private constructor
	public ObservableBoolean obsBoolean = new ObservableBoolean();
	public Webcam webcam;
	public WebcamPanel panel;
	
	public StackPane getPane()
	{
		final SwingNode swingNode = new SwingNode();

        createSwingContent(swingNode);
		 
		StackPane layout = new StackPane(); // will put button right in the middle
		layout.getChildren().add(swingNode);
		return layout;
	}
	
	
    private void createSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	
                swingNode.setContent(getCamPanel());
            }
            
            
        });
    }
    
   public WebcamPanel getCamPanel ()
   {
	
	 
	System.out.print(webcam.getWebcams());
	
	if(webcam.getWebcams().size()>1) {
		webcam = webcam.getWebcams().get(1);
	}else {
		webcam = webcam.getDefault();
	}
	webcam.setViewSize(WebcamResolution.VGA.getSize());
	
	panel = new WebcamPanel(webcam);
	panel.setFPSDisplayed(true);
	panel.setDisplayDebugInfo(true);
	panel.setImageSizeDisplayed(true);
	panel.setMirrored(true);
	
	

	obsBoolean.setOnWindowClosedListener(new OnWindowClosedListener()
	{
	    @Override
	    public void onWindowClosed(Boolean newValue)
	    {
	        //Do something here
	    	//webcam.close(); // this doesn't work. 
			webcam.removeWebcamListener(panel); // ADD THIS LINE
			panel.stop();
			
			
			System.out.println("made it to the close listener");
	    }
	});
		   
		   
	   
	
	return panel;
   }
   
   ////---------------------------------------- Custom change listener for closing the window. 
   public interface OnWindowClosedListener
   {
       public void onWindowClosed(Boolean newValue);
   }

   public class ObservableBoolean
   {
       private OnWindowClosedListener listener;

       private Boolean windowClosed = false;

       public void setOnWindowClosedListener(OnWindowClosedListener listener)
       {
           this.listener = listener;
       }

       public Boolean get()
       {
           return windowClosed;
       }

       public void set(Boolean windowClosed)
       {
           this.windowClosed = windowClosed;

           if(listener != null)
           {
               listener.onWindowClosed(windowClosed);
           }
       }
   }
   

   
   
   
   //-----------------------------------------Singleton stuff
   public static CameraViewModule getInstance() 
   { 
       if (single_instance == null) 
           single_instance = new CameraViewModule(); 
 
       return single_instance; 
   } 
}
