package com.symmetrystudios.taterquest.gameobjects;

import com.symmetrystudios.taterquest.RectObject;

public class TerrainTile extends RectObject {

	public TerrainTile(int x, int y, int width, int height) {
		super(x, y, width, height);
		id = "TerrainTile";
		
		loadSprites("tiles/terrain/grass.png");
		resizeAllSprites(width, height);
	}

	@Override
	protected void update() {
		
	}

}
