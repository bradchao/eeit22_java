package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GamePanelV2  extends JPanel {
	private int viewW, viewH;
	private Timer timer;
	private BufferedImage[] ballImgs = new BufferedImage[4];
	private int[] ballW = new int[4];
	private int[] ballH = new int[4];
	private String[] source = {"dir1/ball0.png","dir1/ball1.png",
						"dir1/ball2.png","dir1/ball3.png"};
	
	public GamePanelV2() {
		setBackground(new Color(250,247,240));
		
		try {
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		}, 0, 16);	// 60 fps
	}
	
	private class BallTask extends TimerTask {
		int ballW, ballH;
		int ballX, ballY;
		int dx, dy;
		
		BallTask(){
			
		}
		@Override
		public void run() {
			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
	}
}
