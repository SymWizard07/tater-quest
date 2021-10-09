package com.symmetrystudios.taterquest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyListener extends KeyAdapter {
	
	private ArrayList<String> keysPressed = new ArrayList<>();
	
	public void keyPressed(KeyEvent e) {
		if (keysPressed.contains(KeyEvent.getKeyText(e.getKeyCode()))) {
			return;
		}
		keysPressed.add(KeyEvent.getKeyText(e.getKeyCode()));
	}
	
	public void keyReleased(KeyEvent e) {
		keysPressed.remove(KeyEvent.getKeyText(e.getKeyCode()));
	}
	
	public boolean isKeyHeld(String key) {
		if (keysPressed.contains(key)) {
			return true;
		}
		return false;
	}

}
