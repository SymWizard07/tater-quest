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

	protected Image getSprite() {
		return sprite;
	}

	protected abstract void update();
}
