package com.symmetrystudios.taterquest;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameGraphics extends JPanel {
	
	private static final long serialVersionUID = 6772700268613103262L;
	
	public GameGraphics() {
	    this.setBackground(Color.black);
	}

	public void paintComponent(Graphics g) {
	  super.paintComponent(g);
	  
	  for (int i = 0; i < Main.handler.size(); i++) {
		  GameObject gameObject = Main.handler.get(i);
		  g.drawImage(gameObject.getSprite(), gameObject.getX(), gameObject.getY(), null);
	  }
	}
}
