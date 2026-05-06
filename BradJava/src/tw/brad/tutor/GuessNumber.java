package tw.brad.tutor;

import javax.swing.JFrame;

public class GuessNumber extends JFrame {
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}
}
