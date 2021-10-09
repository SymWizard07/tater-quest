package com.symmetrystudios.taterquest;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class GameObject {
	
	private int currentFrame = 0;
	
	protected String id = "";
	protected int slowdown;
	protected int x;
	protected int y;
	protected Image[] sprites;
	protected int currentSprite = 0;
	protected ArrayList<SlowDelivery> slowDeliveries = new ArrayList<>();
	
	public GameObject(int x, int y) {
		this.id = "Generic";
		this.slowdown = 10;
		this.x = x;
		this.y = y;
		sprites = null;
	}
	
	public int getSlowdown() {
		return slowdown;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getId() {
		return id;
	}
	
	public void setSlowdown(int slowdown) {
		this.slowdown = slowdown;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void loadSprites(String... url) {
		sprites = new Image[url.length];
		for (int i = 0; i < url.length; i++) {
			sprites[i] = Main.loadSprite(url[i]);
		}
	}

	public Image getSprite(int i) {
		return sprites[i];
	}
	
	public Image getCurrentSprite() {
		return sprites[currentSprite];
	}
	
	public void setCurrentSprite(int i) {
		currentSprite = i;
	}
	
	public void resizeSprite(int i, int width, int height) {
		sprites[i] = sprites[i].getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}
	
	public void resizeAllSprites(int width, int height) {
		for (int i = 0; i < sprites.length; i++) {
			sprites[i] = sprites[i].getScaledInstance(width, height, Image.SCALE_DEFAULT);
		}
	}
	
	public void resizeSprite(int i, int proportion) {
		sprites[i] = sprites[i].getScaledInstance(sprites[i].getWidth(null) * proportion, sprites[i].getHeight(null) * proportion, Image.SCALE_DEFAULT);
	}
	
	public void resizeAllSprites(int proportion) {
		for (int i = 0; i < sprites.length; i++) {
			sprites[i] = sprites[i].getScaledInstance(sprites[i].getWidth(null) * proportion, sprites[i].getHeight(null) * proportion, Image.SCALE_DEFAULT);
		}
	}
	
	public ArrayList<RectObject> toRectObject(ArrayList<GameObject> gameObjects) {
		ArrayList<RectObject> result = new ArrayList<>();
		for (int i = 0; i < gameObjects.size(); i++) {
			result.add((RectObject)gameObjects.get(i));
		}
		
		return result;
	}
	
	public void addSlowDelivery(SlowDelivery slowDelivery) {
		slowDeliveries.add(slowDelivery);
	}
	
	public boolean slowDeliveriesContains(String name) {
		for (int i = 0; i < slowDeliveries.size(); i++) {
			if (slowDeliveries.get(i).name.equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public SlowDelivery getSlowDelivery(String name) {
		for (int i = 0; i < slowDeliveries.size(); i++) {
			if (slowDeliveries.get(i).name.equals(name)) {
				return slowDeliveries.get(i);
			}
		}
		
		return null;
	}

	public void superUpdate() {
		currentFrame++;
		
		if (slowdown != currentFrame) {
			return;
		}
		
		for (int i = 0; i < slowDeliveries.size(); i++) {
			if (slowDeliveries.get(i).frames <= 0) {
				if (slowDeliveries.get(i).repeat) {
					slowDeliveries.get(i).reset();
				}
				else {
					slowDeliveries.remove(i);
					continue;
				}
			}
			slowDeliveries.get(i).frames--;
		}
		
		currentFrame = 0;
		update();
	}
	
	protected abstract void update();
}
