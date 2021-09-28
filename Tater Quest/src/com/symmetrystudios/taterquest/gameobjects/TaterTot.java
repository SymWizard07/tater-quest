package com.symmetrystudios.taterquest.gameobjects;

import java.io.File;

import com.symmetrystudios.taterquest.GameObject;
import com.symmetrystudios.taterquest.Main;

public class TaterTot extends GameObject {

	public TaterTot(int x, int y) {
		super(x, y);
		
		sprite = Main.loadImage(new File("assets/tot.png"));
	}

	@Override
	protected void update() {
		
	}

}
