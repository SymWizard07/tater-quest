package com.symmetrystudios.taterquest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.symmetrystudios.taterquest.gameobjects.*;

import sprites.ResourceLoader;

public class Main {
	
	public static int FRAME_WIDTH, FRAME_HEIGHT;
	public static Handler handler;

	public static void main(String[] args) {
		JFrame f = new JFrame();
	    f.setTitle ("Tater Quest");
	    f.setResizable(true);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setSize(screenSize.width, screenSize.height);
	    f.setExtendedState(f.getExtendedState() | f.MAXIMIZED_BOTH);
	    f.setUndecorated(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    FRAME_WIDTH = f.getWidth();
	    FRAME_HEIGHT = f.getHeight();
	    
	    handler = new Handler();
	    GameGraphics g = new GameGraphics();
	    
	    f.getContentPane().add(g);
	    f.setVisible(true);
	    
	    f.createBufferStrategy(4);
	    BufferStrategy bs = f.getBufferStrategy();
	    
	    handler.add(new TaterTot(100, 100));
	    for (int i = 0; i < 400; i++) {
	    	handler.add(new TaterTot((int)(Math.random() * f.getWidth()), (int)(Math.random() * f.getHeight())));
	    }
	    
	    boolean running = true;
	    long currentTime = System.currentTimeMillis();
	    long nextTime = currentTime;
	    long tickSpeed = 50;
	    while(running) {
	    	if (currentTime >= nextTime) {
	    		
	    		for (long delta = currentTime - nextTime; delta >= 0; delta -= tickSpeed) {
	    			handler.update();
	    		}
	    		
	    		do {
	    			do {
	    				g.paintComponent(bs.getDrawGraphics());
	    				bs.getDrawGraphics().dispose();
	    			} while (bs.contentsRestored());
	    		
	    			bs.show();
	    		} while (bs.contentsLost());
	    		nextTime = currentTime + tickSpeed;
	    	}
	    	currentTime = System.currentTimeMillis();
	    }
	    
	    f.setVisible(false);
	    f.dispose();
	}
	
	public static Image loadSprite(String spriteName) {
		
		Image loadedImage = null;
		loadedImage = ResourceLoader.loadSprite(spriteName);
		
		return loadedImage;
	}

}
