package com.symmetrystudios.taterquest;

import java.awt.Image;

public abstract class GameObject {
	
	protected int x;
	protected int y;
	protected Image sprite;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = null;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public Image getSprite() {
		return sprite;
	}
	
	public void resizeSprite(int width, int height) {
		sprite = sprite.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	protected abstract void update();
}
