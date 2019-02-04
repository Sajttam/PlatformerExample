package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class TileSet {
	private String location = "/graphics/spritesheet.png";
	private BufferedImage BufferedTileSet;
	
	private int xOffset = 2;
	private int yOffset = 2;
	private int tileSize = 21;
	
	private static TileSet tileSet;
	
	public static BufferedImage getTile(int x, int y) {
		if (tileSet == null)
			tileSet = new TileSet();
		BufferedImage temp = tileSet.getTileThis(x, y);
		return temp;
	}
	
	private TileSet() {
		try {
			BufferedTileSet = getImage(location);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage getTileThis(int x, int y) {
		return BufferedTileSet.getSubimage(3+(tileSize+xOffset)*x, 3+(tileSize+yOffset)*y, tileSize, tileSize);
	}
	
	private BufferedImage getImage(String filename) throws Exception {
		// Grab the InputStream for the image.
		InputStream in = getClass().getResourceAsStream(filename);
		if (in == null)
			throw new Exception("");
		// Then read it in.
		return ImageIO.read(in);
	}
}
