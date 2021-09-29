package com.symmetrystudios.taterquest;

import java.util.ArrayList;

public class Handler {
	
	private ArrayList<GameObject> handler = new ArrayList<>();
	
	public Handler() {
		
	}
	
	public GameObject get(int i) {
		return handler.get(i);
	}
	
	public int size() {
		return handler.size();
	}
	
	public void add(GameObject gameObject) {
		handler.add(gameObject);
	}
	
	public void remove(GameObject gameObject) {
		handler.remove(gameObject);
	}
	
	public void update() {
		for (int i = 0; i < handler.size(); i++) {
			handler.get(i).update();
		}
	}
}
