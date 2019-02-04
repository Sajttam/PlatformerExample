package models;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import controller.GameController;
import view.Animation;
import view.TileSet;

public class VictoryFlag extends GraphicalObjAbstract {
	private Animation flag;
	
	public VictoryFlag(int x, int y, GameController gameController) {
		super(x, y, 21, TileSet.getTile(10, 10), gameController);
		//flag = new Animation(10, 10, 50, 2);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		drawSelf(g2d);
		//g2d.drawImage(flag.getImage(), null, x, y);
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
