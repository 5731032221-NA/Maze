package render;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resource {
	
	public static BufferedImage mapSprite;
	public static BufferedImage mineSprite;
	static{
		try {
			mapSprite = ImageIO.read(new File("Mapz.jpg"));
			mineSprite = ImageIO.read(new File("Player.png"));
			/*
			ClassLoader loader = RenderableHolder.class.getClassLoader();
			mapSprite = ImageIO.read(loader.getResource("Map.png"));
			mineSprite = ImageIO.read(loader.getResource("Mine.png"));
			*/
		} catch (IOException e) {
			mapSprite = null;
			mineSprite = null;
		}
	}
}
