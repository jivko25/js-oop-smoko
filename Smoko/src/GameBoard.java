import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener, ActionListener {

	private int[] SnakeXLength = new int[750];
	private int[] SnakeYLenght = new int[750];
	
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
	
	public GameBoard() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
//		timer = new Timer(delay, this);
//		timer.start();
	}
	
	public void paint(Graphics g)
	{
		//Draw Title
		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 55);
		
		//draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 75, 852, 577); 
		
		//draw background for the gameplay
		g.setColor(Color.GREEN);
		g.fillRect(25, 75, 850, 575);
		
		HeadDown = new ImageIcon("");
		HeadDown.paintIcon(this, g, SnakeXLength[0], SnakeYLenght[0]);
		
		HeadUp = new ImageIcon("");
		HeadUp.paintIcon(this, g, SnakeXLength[0], SnakeYLenght[0]);
		
		HeadRight = new ImageIcon("");
		HeadRight.paintIcon(this, g, SnakeXLength[0], SnakeYLenght[0]);
		
		HeadLeft = new ImageIcon("");
		HeadLeft.paintIcon(this, g, SnakeXLength[0], SnakeYLenght[0]);
		
		for(int i = 0; i<SnakeLenght;i++) {
			if(i == 0 && right)
			{
				HeadRight = new ImageIcon("");
				HeadRight.paintIcon(this, g, SnakeXLength[i], SnakeYLenght[i]);
			}
			
			if(i == 0 && left)
			{
				HeadLeft = new ImageIcon("");
				HeadLeft.paintIcon(this, g, SnakeXLength[i], SnakeYLenght[i]);
			}
			
			if(i == 0 && up)
			{
				HeadUp = new ImageIcon("");
				HeadUp.paintIcon(this, g, SnakeXLength[i], SnakeYLenght[i]);
			}
			
			if(i == 0 && down)
			{
				HeadDown = new ImageIcon("");
				HeadDown.paintIcon(this, g, SnakeXLength[i], SnakeYLenght[i]);
			}
			
			if(i != 0)
			{
				SnakeBody = new ImageIcon("");
				SnakeBody.paintIcon(this, g, SnakeXLength[i], SnakeYLenght[i]);
			}
		}
		
		g.dispose();
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

