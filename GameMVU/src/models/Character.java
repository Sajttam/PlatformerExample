package models;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import controller.GameController;
import view.Animation;
import view.TileSet;

public class Character extends GraphicalObjAbstract {
	private double hSpeed=0;
	private double vSpeed=0;
	private double gravity=0;
	private double jumpSpeed=0;
	private double gravityConstant=0.005;
	private boolean inAir=false;
	private Animation walkRight;
	private Animation jumping;
	
	public Character(GameController gameController) {
		super(100, 100, 21, TileSet.getTile(19, 0), gameController);
		walkRight = new Animation(20, 0, 50, 2);
		jumping = new Animation(26, 0, 26, 2);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		if ((int)vSpeed !=0) {
			g2d.drawImage(jumping.getImage(), null, x, y);
		}
		else if (hSpeed != 0) {
			g2d.drawImage(walkRight.getImage(), null, x, y);
		}
		else
			drawSelf(g2d);
	}

	@Override
	public void step() {
		gravity += gravityConstant;
		vSpeed = vSpeed + gravity;
		x+=hSpeed;
		y+=vSpeed;
		
		//System.out.println("gravity:" + gravity + "vSpeed:" + vSpeed);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	hSpeed = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
        	hSpeed = 0;
        }

        if (key == KeyEvent.VK_UP) {
        	//hSpeed = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
        	//hSpeed = 0;
        }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyCode();		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	hSpeed = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
        	hSpeed = 1;
        }

        if (key == KeyEvent.VK_UP) {
        	if (!inAir) {
        		vSpeed = -2;
        		gravity = 0;
        		inAir = true;
        	}
        }

        if (key == KeyEvent.VK_DOWN) {
        	//hSpeed = 4;
        }
	}

	@Override
	public void Collision(GraphicalObj other) {
		if (other instanceof Coin) {
			other.instanceDestroy();
		}
		if (other instanceof Ground) {
			//int depthX = (getX() - other.getX());
			//int depthY =  getSize() - (other.getY() - getY());
			int preX = (int) (getX() - hSpeed);
			int preY = (int) (getY() - vSpeed - gravity);
			
			if (preY + getSize() <= other.getY()) { //NORTH
				vSpeed=0;
				y = other.getY()-getSize();
				gravity=0;
				inAir=false;
			}
			else if (preY >= other.getY()+other.getSize()) { //SOUTH
				vSpeed=0;
				gravity=0;
				y = other.getY()+other.getSize();
			}
			else if (preX + getSize() <= other.getX()) { //WEST 
				x = other.getX()-getSize();
			}
			else { //EAST
				x = other.getX()+other.getSize();
			}			
		}
	}
}
