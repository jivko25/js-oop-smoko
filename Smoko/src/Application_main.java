import java.awt.Color;

import javax.swing.JFrame;

public class Application_main {
	
	public static void main(String[] args) {
		JFrame windowFrame = new JFrame();
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setSize(915, 715);
		windowFrame.getContentPane().setBackground(Color.GREEN);
		windowFrame.add(new GameBoard());
		windowFrame.setVisible(true);
		windowFrame.setResizable(false);
	}

}
