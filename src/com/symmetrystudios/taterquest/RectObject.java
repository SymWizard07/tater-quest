package com.symmetrystudios.taterquest;

import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class RectObject extends GameObject {
	
	protected Rectangle collision;
	protected int width, height;

	public RectObject(int x, int y, int width, int height) {
		super(x, y);
		collision = new Rectangle(x, y, width, height);
	}
	
	public void setWidth(int width) {
		collision.setRect((double)x, (double)y, (double)width, collision.getHeight());
		this.width = width;
	}
	
	public void setHeight(int height) {
		collision.setRect((double)x, (double)y, collision.getWidth(), (double)height);
		this.height = height;
	}
	
	public int getWidth() {
		return (int)collision.getWidth();
	}
	
	public int getHeight() {
		return (int)collision.getHeight();
	}
	
	public Rectangle getCollision() {
		return collision;
	}
	
	public ArrayList<RectObject> colliders(ArrayList<RectObject> potentialColliders) {
		ArrayList<RectObject> colliders = new ArrayList<>();
		for (int i = 0; i < potentialColliders.size(); i++) {
			if (potentialColliders.get(i).getCollision().intersects(collision) || potentialColliders.get(i).getCollision().contains(collision)) {
				colliders.add(potentialColliders.get(i));
			}
		}
		
		return colliders;
	}
	
	public void superUpdate() {
		collision.setRect((double)x, (double)y, getWidth(), getHeight());
		width = (int)collision.getWidth();
		height = (int)collision.getHeight();
		super.superUpdate();
	}
}
