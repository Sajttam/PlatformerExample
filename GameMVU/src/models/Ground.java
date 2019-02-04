package models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import controller.GameController;
import view.TileSet;

public class Ground extends GraphicalObjAbstract {
	
	public Ground(int x, int y, GameController gameController) {
		super(x, y, 21, TileSet.getTile(2, 4), gameController);
		// TODO Auto-generated constructor stub
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
