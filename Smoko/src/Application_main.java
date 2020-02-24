import java.awt.Color;

import javax.swing.JFrame;

public class Application_main {
	
	public static void main(String[] args) {
		JFrame windowFrame = new JFrame();
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setSize(800, 800);
		windowFrame.getContentPane().setBackground(Color.GREEN);
		windowFrame.add(new Snake_Pieces());
		windowFrame.setVisible(true);
	}

}
