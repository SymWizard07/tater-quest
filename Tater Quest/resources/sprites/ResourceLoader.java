package sprites;

import java.awt.Image;
import java.awt.Toolkit;

public class ResourceLoader {
	
	private static ResourceLoader rl = new ResourceLoader();
	
	public static Image loadSprite(String spriteName) {
		return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource("sprite/" + spriteName));
	}
}
