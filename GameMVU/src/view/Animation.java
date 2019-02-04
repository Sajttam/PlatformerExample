package view;

import java.awt.image.*;
import java.util.*;

public class Animation {
	private List<BufferedImage> imageList;
	private int updateFrequency;
	private int steps;
	
	public Animation(int imageStartX, int imageStartY, int updateFrequency, int size) {
		imageList = new ArrayList<BufferedImage>();
		steps = 0;
		this.updateFrequency = updateFrequency;
		
		for (int i=0; i < size; i++) {
			imageList.add(TileSet.getTile(imageStartX+i, imageStartY));
		}
	}
	
	public BufferedImage getImage() {
		steps++;
		if (steps >= updateFrequency)
			steps = 0;
		int temp = steps / (updateFrequency / imageList.size());
		return imageList.get(temp);
	}
}
