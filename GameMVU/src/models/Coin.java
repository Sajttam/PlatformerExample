package models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import controller.GameController;
import view.TileSet;

public class Coin extends GraphicalObjAbstract {	
	public Coin(int x, int y,  GameController gameController) {
		super(x, y, 16, TileSet.getTile(18, 2), gameController);
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Collision(GraphicalObj go) {
		// TODO Auto-generated method stub
		
	}
}
