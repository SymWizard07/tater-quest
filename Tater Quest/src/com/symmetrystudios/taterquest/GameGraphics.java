package com.symmetrystudios.taterquest;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameGraphics extends JPanel {
	
	private static final long serialVersionUID = 6772700268613103262L;
	
	private Handler handler;
	
	public GameGraphics(Handler handler) {
	    this.setBackground(Color.black);
	    this.handler = handler;
	}

	public void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  
	  for (int i = 0; i < handler.size(); i++) {
		  GameObject gameObject = handler.get(i);
		  g.drawImage(gameObject.getSprite(), gameObject.getX(), gameObject.getY(), null);
		  System.out.println("test");
	  }
	}
}
