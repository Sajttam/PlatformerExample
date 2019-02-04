package models;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public interface GraphicalObj {
	public void draw(Graphics2D g2d);
	public void step();
	public void keyReleased(KeyEvent e);
	public void keyTyped(KeyEvent e);
	public void keyPressed(KeyEvent e);
	public void Collision(GraphicalObj go);
	public int getX();
	public int getY();
	public int getSize();
	public void instanceDestroy();
	public void drawSelf(Graphics2D g2d);
}
