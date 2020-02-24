import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Snake_Pieces extends JPanel{
	
	public void paint(Graphics m) {
		m.setColor(Color.RED);
		m.fillOval(250, 100, 50, 50);
	}

}
