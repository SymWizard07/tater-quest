package com.symmetrystudios.taterquest.gameobjects;

import java.io.File;

import com.symmetrystudios.taterquest.GameObject;
import com.symmetrystudios.taterquest.Main;

public class TaterTot extends GameObject {
	
	int xVel = 1;
	int yVel = 1;
	int frame = 0;

	public TaterTot(int x, int y) {
		super(x, y);
		
		sprite = Main.loadImage(new File("assets/tot.png"));
	}

	@Override
	protected void update() {
		x += xVel;
		y += yVel;
		if (x > Main.FRAME_WIDTH) {
			x = 0;
		}
		if (y > Main.FRAME_HEIGHT) {
			Main.handler.add(new TaterTot((int)(Math.random() * Main.FRAME_WIDTH), (int)(Math.random() * Main.FRAME_HEIGHT) - Main.FRAME_HEIGHT));
			Main.handler.remove(this);
		}
		
		if (frame >= 10) {
			yVel++;
			frame = 0;
		}
		
		frame++;
	}

}
