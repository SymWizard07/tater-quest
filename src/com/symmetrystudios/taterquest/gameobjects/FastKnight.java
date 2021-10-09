package com.symmetrystudios.taterquest.gameobjects;

import java.util.ArrayList;

import com.symmetrystudios.taterquest.GameConstants;
import com.symmetrystudios.taterquest.Main;
import com.symmetrystudios.taterquest.RectObject;
import com.symmetrystudios.taterquest.SlowDelivery;

public class FastKnight extends RectObject {
	
	private int velX;
	private int velY;
	private int speed;
	private boolean onGround = false;
	private ArrayList<RectObject> terrainColliders = new ArrayList<>();

	public FastKnight(int x, int y) {
		super(x, y, 24 * 4, 30 * 4);
		id = "FastKnight";
		velX = 0;
		velY = 0;
		speed = 5;
		
		loadSprites("fastknight/idle.png");
		resizeAllSprites(24 * 4, 30 * 4);
	}

	@Override
	protected void update() {
		x += velX;
		y += velY;
		
		if (Main.isKeyHeld("Right") && !Main.isKeyHeld("Left")) {
			velX = speed;
		}
		if (Main.isKeyHeld("Left") && !Main.isKeyHeld("Right")) {
			velX = -speed;
		}
		if (Main.isKeyHeld("Right") && Main.isKeyHeld("Left") || !Main.isKeyHeld("Right") && !Main.isKeyHeld("Left")) {
			velX = 0;
		}
		
		terrainColliders = colliders(toRectObject(Main.handler.getOfId("TerrainTile")));
		
		onGround = false;
		for (int i = 0; i < terrainColliders.size(); i++) {
			if (terrainColliders.get(i).getY() <= y + height - velY) {
				if (!onGround) {
					y = terrainColliders.get(i).getY() - height + 1;
					velY = 0;
				}
				onGround = true;
			}
		}
		
		if (!onGround) {
			if (!slowDeliveriesContains("Gravity")) {
				addSlowDelivery(new SlowDelivery("Gravity", 5, GameConstants.GRAVITY));
				velY += GameConstants.GRAVITY;
			}
			if (getSlowDelivery("Gravity").frames == 1) {
				velY += getSlowDelivery("Gravity").value;
			}
		}
	}

}
