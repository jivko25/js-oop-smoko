import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JPanel implements KeyListener, ActionListener {

	private int[] SnakeXLength = new int[750];
	private int[] SnakeYLength = new int[750];
	
	private int SnakeLenght = 3;
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon HeadRight;
	private ImageIcon HeadLeft;
	private ImageIcon HeadUp;
	private ImageIcon HeadDown;
	private ImageIcon SnakeBody;
	private ImageIcon SnakeTile;
	
	private Timer timer;
	private int delay = 100;
	
	private int [] enemyXpos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
	private int [] enemyYpos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
	private ImageIcon enemyimage;
	
	private Random random = new Random();
	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);
	
	private int score = 0;
	private int moves = 0;
	private int pause = 0;
	
	public GameBoard() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		if(moves == 0)
		{
			SnakeXLength[2] = 50;
			SnakeXLength[1] = 75;
			SnakeXLength[0] = 100;
			
			SnakeYLength[2] = 100;
			SnakeYLength[1] = 100;
			SnakeYLength[0] = 100;
		}
		
		//Draw Title
		g.setColor(Color.BLACK);
		g.fillRect(24, 10, 851, 55);
		
		//draw border for gameplay
		g.setColor(Color.BLACK);
		g.drawRect(24, 74, 851, 576);
		
		
		//draw background for the gameplay
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
		
		// draw scores
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Scores: " +score, 780, 30);
		
		//draw length
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length: " +SnakeLenght, 780, 50);
		
		HeadRight = new ImageIcon("rightmouth.png");
		HeadRight.paintIcon(this, g, SnakeXLength[0], SnakeYLength[0]);
		
		HeadLeft = new ImageIcon("leftmouth.png");
		HeadLeft.paintIcon(this, g, SnakeXLength[0], SnakeYLength[0]);
		
		HeadDown = new ImageIcon("downmouth.png");
		HeadDown.paintIcon(this, g, SnakeXLength[0], SnakeYLength[0]);
		
		HeadUp = new ImageIcon("upmouth.png");
		HeadUp.paintIcon(this, g, SnakeXLength[0], SnakeYLength[0]);
		
		
		for(int i = 0; i<SnakeLenght;i++) {
			if(i == 0 && right)
			{
				HeadRight = new ImageIcon("rightmouth.png");
				HeadRight.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
			}
			
			if(i == 0 && left)
			{
				HeadLeft = new ImageIcon("leftmouth.png");
				HeadLeft.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
			}
			
			if(i == 0 && down)
			{
				HeadDown = new ImageIcon("downmouth.png");
				HeadDown.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
			}
			
			if(i == 0 && up)
			{
				HeadUp = new ImageIcon("upmouth.png");
				HeadUp.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
			}

			
			if(i != 0)
			{
				SnakeBody = new ImageIcon("snakeimage.png");
				SnakeBody.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
			}
		}
		
		enemyimage = new ImageIcon("enemy.png");
		
		if((enemyXpos[xpos] ==SnakeXLength[0] && enemyYpos[ypos] == SnakeYLength[0]))
		{
			score++;
			SnakeLenght++;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}
		
		enemyimage.paintIcon(this, g, enemyXpos[xpos], enemyYpos[ypos]);
		
		for(int c = 1; c< SnakeLenght; c++)
		{
			if(SnakeXLength[c] == SnakeXLength[0] && SnakeYLength[c] == SnakeYLength[0]) 
			{
				right = false;
				left = false;
				up = false;
				down = false;
				
				g.setColor(Color.WHITE);
				g.setFont(new Font ("arial", Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);
				
				g.setFont(new Font ("arial", Font.BOLD, 20));
				g.drawString("Space to RESTART", 350, 340);
			}
		}
		
		if(score == 50) 
		{
			right = false;
			left = false;
			up = false;
			down = false;
			
			g.setColor(Color.WHITE);
			g.setFont(new Font ("arial", Font.BOLD, 50));
			g.drawString("You win", 342, 300);
			
			g.setFont(new Font ("arial", Font.BOLD, 20));
			g.drawString("Space to RESTART", 350, 340);
		}
		
		g.dispose();
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			moves = 0;
			score = 0;
			SnakeLenght = 3;
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moves++;
			right = true;
			if(!left) {
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
			left = false;
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moves++;
			right = false;
			left = true;
			if(!right) {
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moves++;
			right = false;
			left = false;
			up = true;
			if(!up) {
				down = true;
			}
			else
			{
				down = false;
				up = true;
			}
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moves++;
			right = false;
			left = false;
			up = false;
			down = true;
			if(!down) {
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_P)
		{
			pause++;
			if(right == true && left == false && up == false && down == false)
			{
				if(pause%2 == 1) {
					right = false;
					left = false;
					up = false;
					down = false;
					repaint();
				}
				else
				{
					right = true;
					left = false;
					up = false;
					down = false;
					repaint();
				}
				repaint();
			}
			
			if(right == false && left == true && up == false && down == false)
			{
				if(pause%2 == 1) {
					right = false;
					left = false;
					up = false;
					down = false;
				}
				else
				{
					right = false;
					left = true;
					up = false;
					down = false;
				}
			}
			
			if(right == false && left == false && up == true && down == false)
			{
				if(pause%2 == 1) {
					right = false;
					left = false;
					up = false;
					down = false;
				}
				else
				{
					right = false;
					left = false;
					up = true;
					down = false;
				}
			}
			
			if(right == false && left == false && up == false && down == true)
			{
				if(pause%2 == 1) {
					right = false;
					left = false;
					up = false;
					down = false;
				}
				else
				{
					right = false;
					left = false;
					up = false;
					down = true;
				}
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(right)
		{
			for(int r = SnakeLenght-1;r>=0;r--) 
			{
				SnakeYLength[r+1] = SnakeYLength[r];
			}
			for(int r = SnakeLenght; r>=0;r--) 
			{
				if(r == 0)
				{
					SnakeXLength[r] = SnakeXLength[r] + 25;
				}
				else
				{
					SnakeXLength[r] = SnakeXLength[r-1];
				}
				if(SnakeXLength[r] > 850)
				{
					SnakeXLength[r] = 25;
				}
			}
			repaint();
		}
		
		if(left)
		{
			for(int r = SnakeLenght-1;r>=0;r--) 
			{
				SnakeYLength[r+1] = SnakeYLength[r];
			}
			for(int r = SnakeLenght; r>=0;r--) 
			{
				if(r == 0)
				{
					SnakeXLength[r] = SnakeXLength[r] - 25;
				}
				else
				{
					SnakeXLength[r] = SnakeXLength[r-1];
				}
				if(SnakeXLength[r] < 25)
				{
					SnakeXLength[r] = 850;
				}
			}
			repaint();
		}
		
		if(up)
		{
			for(int r = SnakeLenght-1;r>=0;r--) 
			{
				SnakeXLength[r+1] = SnakeXLength[r];
			}
			for(int r = SnakeLenght; r>=0;r--) 
			{
				if(r == 0)
				{
					SnakeYLength[r] = SnakeYLength[r] - 25;
				}
				else
				{
					SnakeYLength[r] = SnakeYLength[r-1];
				}
				if(SnakeYLength[r] < 75)
				{
					SnakeYLength[r] = 625;
				}
			}
			repaint();
		}
		
		if(down)
		{
			for(int r = SnakeLenght-1;r>=0;r--) 
			{
				SnakeXLength[r+1] = SnakeXLength[r];
			}
			for(int r = SnakeLenght; r>=0;r--) 
			{
				if(r == 0)
				{
					SnakeYLength[r] = SnakeYLength[r] + 25;
				}
				else
				{
					SnakeYLength[r] = SnakeYLength[r-1];
				}
				if(SnakeYLength[r] > 625)
				{
					SnakeYLength[r] = 75;
				}
			}
			repaint();
		}
	}

	
}
