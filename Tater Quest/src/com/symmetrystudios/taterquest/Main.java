package com.symmetrystudios.taterquest;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.symmetrystudios.taterquest.gameobjects.*;

public class Main {

	public static void main(String[] args) {
	    JFrame f = new JFrame();
	    f.setTitle ("Tater Quest");
	    f.setResizable(true);
	    f.setSize(500, 300);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Handler handler = new Handler();
	    
	    GameGraphics g = new GameGraphics(handler);
	    handler.add(new TaterTot(100, 100));
	    
	    
	    
	    f.getContentPane().add(g);
	    f.setVisible(true);
	}
	
	public static Image loadImage(File file) {
		Image loadedImage = null;
		try {
			loadedImage = ImageIO.read(file);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return loadedImage;
	}

}
