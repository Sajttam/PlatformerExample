package models;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import controller.GameController;
import java.awt.image.*;

public abstract class GraphicalObjAbstract implements GraphicalObj {
	int x;
	int y;
	int size;
	private GameController gameController;
	private BufferedImage sprite;
	
	public GraphicalObjAbstract(int x, int y, int size, BufferedImage sprite, GameController gameController) {
		this.gameController = gameController;
		this.x = x;
		this.y = y;
		this.size = size;
		this.sprite = sprite;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		drawSelf(g2d);
	}
	
	@Override
	public void drawSelf(Graphics2D g2d) {
		g2d.drawImage(sprite, null, x, y);
	}
	
	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public void instanceDestroy() {
		gameController.removeInstance(this);
	}
}
