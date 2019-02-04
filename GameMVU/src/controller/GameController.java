package controller;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.Timer;

import models.*;
import models.Character;
import view.*;

public class GameController implements ActionListener {
	private JFrame gameFrame;
	private GamePanel gamePanel;
	private List<GraphicalObj> graphicalObjects;
	private List<GraphicalObj> removeObjects;
	private Timer timer;
    private final int DELAY = 10;
    private GraphicalObj player;
    
    public static final int WIDTH = 231;
    public static final int HEIGHT = 189;
    public static final int GRID_SIZE=21;
    public static final double SCALING = 4;
    
	public GameController() {
		//Initialize list
		graphicalObjects = new ArrayList<GraphicalObj>();
		removeObjects = new ArrayList<GraphicalObj>();
		
		//Create game view and game panel
		gameFrame = new JFrame();	
		gameFrame.addKeyListener(new TAdapter());
		gameFrame.setLayout(new BorderLayout());
		
		Container contentPane = gameFrame.getContentPane();
		gamePanel = new GamePanel(WIDTH, HEIGHT, graphicalObjects);
		contentPane.add(gamePanel, BorderLayout.CENTER);
		
		gameFrame.setTitle("Platform game");
		gameFrame.setIconImage(TileSet.getTile(19, 3));
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.pack();
		gameFrame.setVisible(true);
		
		//Create timer that updates logic and graphic
		timer = new Timer(DELAY, this);
        timer.start();
        
        //Create the game level
        initGame();
	}
	
	public void initGame() {
		graphicalObjects.add(new Coin(GRID_SIZE*1, GRID_SIZE*1, this));
		graphicalObjects.add(new Coin(GRID_SIZE*13, GRID_SIZE*4, this));
		graphicalObjects.add(new Coin(GRID_SIZE*5, GRID_SIZE*4, this));
		graphicalObjects.add(new Coin(GRID_SIZE*2, GRID_SIZE*7, this));
		graphicalObjects.add(new Coin(GRID_SIZE*7, GRID_SIZE*2, this));
		
		player = new Character(this);
		graphicalObjects.add(player);
		gamePanel.setViewFollow(player);
		
		for (int i = 0; i <=40; i++) {
			graphicalObjects.add(new Ground(GRID_SIZE*i, GRID_SIZE*8, this));
		}
		
		for (int i = 4; i <= 6; i++) {
			graphicalObjects.add(new Ground(GRID_SIZE*i, GRID_SIZE*5, this));
		}
		graphicalObjects.add(new Ground(GRID_SIZE*1, GRID_SIZE*2, this));
		graphicalObjects.add(new Ground(GRID_SIZE*1, GRID_SIZE*3, this));
		graphicalObjects.add(new Ground(GRID_SIZE*2, GRID_SIZE*3, this));
		
		for (int i = 9; i <= 14; i++) {
			graphicalObjects.add(new Ground(GRID_SIZE*i, GRID_SIZE*7, this));
		}
		for (int i = 10; i <= 14; i++) {
			graphicalObjects.add(new Ground(GRID_SIZE*i, GRID_SIZE*6, this));
		}
		for (int i = 11; i <= 13; i++) {
			graphicalObjects.add(new Ground(GRID_SIZE*i, GRID_SIZE*5, this));
		}
		
		graphicalObjects.add(new VictoryFlag(GRID_SIZE*2, GRID_SIZE*7, this));
	}
	
	public void removeInstance(GraphicalObj gObject) {
		removeObjects.add(gObject);
	}
	
	private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
        	for (GraphicalObj gObject: graphicalObjects) {
        		gObject.keyReleased(e);
    		}
        }

        @Override
        public void keyPressed(KeyEvent e) {
        	for (GraphicalObj gObject: graphicalObjects) {
        		gObject.keyPressed(e);
    		}
        }
        
        @Override
    	public void keyTyped(KeyEvent e) {
    		for (GraphicalObj gObject: graphicalObjects) {
    			gObject.keyTyped(e);
    		}
    	}
    }
	
	public void collisionChecking(GraphicalObj gObject) {
		for (GraphicalObj other: graphicalObjects) {
			if (gObject != other) {
				if (gObject.getX() < other.getX() + other.getSize() && gObject.getX() + gObject.getSize() > other.getX()
						&& gObject.getY() < other.getY() + other.getSize() && gObject.getY() + gObject.getSize() > other.getY()) {
					gObject.Collision(other);
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (GraphicalObj gObject: removeObjects) { //Remove unwanted instances
			graphicalObjects.remove(gObject);
		}
		removeObjects.clear();

		for (GraphicalObj gObject: graphicalObjects) {
			gObject.step();
			collisionChecking(gObject);
		}
		
		gamePanel.repaint();
	}
}
