package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.GameController;
import models.GraphicalObj;

public class GamePanel extends JPanel {
	private List<GraphicalObj> drawObjs;
	private BufferedImage background;
	private GraphicalObj viewFollow;
	private int width;
	private int height;
	private int xOffset;
	
	public GamePanel(int width, int height, List<GraphicalObj> drawObjs) {
		super();
		setPreferredSize(new Dimension((int)(width*GameController.SCALING), (int)(height*GameController.SCALING)));
		setDoubleBuffered(true);
		
		this.width = width;
		this.height = height;
		this.drawObjs = drawObjs;
		
		//Load background
		InputStream in = getClass().getResourceAsStream("/graphics/backgrounds.png");
		try {
			background = ImageIO.read(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setViewFollow(GraphicalObj viewFollow) {
		this.viewFollow = viewFollow;
	}
	
	private int calculateXOffset() {
		if (viewFollow == null) return 0;
		
		int startEast = 150; //The most amount of pixels that should always exist between the character and the panels west side
		int startWest = 81; //The least amount of pixels that should always exist between the character and the panels west side
		int charRealX = viewFollow.getX() + xOffset; // The characters x position in the panel
		
		if (charRealX > startEast) {
			xOffset = startEast - viewFollow.getX();
		}
		else if (charRealX < startWest) { //TODO: The view also needs to stop moving when it hits the end x position of the room.
			if (viewFollow.getX() < startWest) {
				//Do nothing
			}
			else {
				xOffset = startWest - viewFollow.getX();
			}
		}
		
		return xOffset;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.scale(GameController.SCALING,GameController.SCALING);
		g2d.translate(calculateXOffset(), 0);
		super.paintComponent(g);
		
		for (int i=0; i < 10; i++) //TODO: The background should only be drawn as many times as it fits in the room.
			g2d.drawImage(background, null, width*i, 0);
		
		
		for (GraphicalObj gObj : drawObjs) {
			gObj.draw(g2d);
		}
		
		g2d.dispose();
		g.dispose();
	}
}

