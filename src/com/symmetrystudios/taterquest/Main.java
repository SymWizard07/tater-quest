package com.symmetrystudios.taterquest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import com.symmetrystudios.taterquest.gameobjects.*;
import com.symmetrystudios.taterquest.resources.*;

public class Main {
	
	public static int FRAME_WIDTH, FRAME_HEIGHT;
	public static Handler handler;
	public static KeyListener keyListener;

	public static void main(String[] args) {
		JFrame f = new JFrame();
	    f.setTitle("Tater Quest");
	    f.setResizable(true);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    f.setSize(screenSize.width, screenSize.height);
	    f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
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
	    
	    keyListener = new KeyListener();
	    f.addKeyListener(keyListener);
	    
	    handler.add(new FastKnight(100, 100));
	    handler.add(new TerrainTile(100, 300, 100, 100));
	    
	    boolean running = true;
	    long currentTime = System.currentTimeMillis();
	    long nextTime = currentTime;
	    long tickSpeed = 1;
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
	
	public static boolean isKeyHeld(String key) {
		return keyListener.isKeyHeld(key);
	}

}
