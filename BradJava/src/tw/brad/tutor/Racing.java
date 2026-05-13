package tw.brad.tutor;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Racing extends JFrame implements ActionListener{
	private JButton go, init;
	private JLabel[] lanes;
	private Car[] cars;
	private int rank;
	
	public Racing() {
		super("Racing");
		
		setLayout(new GridLayout(9, 1));
		JPanel top = new JPanel(new FlowLayout());
		go = new JButton("Go!");
		top.add(go); go.addActionListener(this);
		init = new JButton("Init");
		top.add(init); init.addActionListener(this);
		add(top);
		
		
		
		lanes = new JLabel[8];
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel();
			add(lanes[i]);
		}
		
		setSize(1024, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//initGame();
	}
	
	private class Car extends Thread {
		int lane;
		StringBuffer data;
		Car(int lane){
			this.lane = lane;
			data = new StringBuffer((lane+1) + ". ");
			lanes[lane].setText(data.toString());
		}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				if (i== 99) {
					data.append("> WINNER");
					lanes[lane].setText(data.toString());
					stopGame();
				}else {
					data.append(">");
					lanes[lane].setText(data.toString());
				}
				try {
					Thread.sleep(10 + (int)(Math.random()*200));
				} catch (InterruptedException e) {
					break;
				}
			}
			
			
//			data.append(++rank); 
//			lanes[lane].setText(data.toString());
			
		}
	}
	
	private void stopGame() {
		for (int i=0; i<cars.length; i++) {
			cars[i].interrupt();
		}
	}
	
	public static void main(String[] args) {
		new Racing();
	}

	private void initGame() {
		rank = 0;
		cars = new Car[8];
		for (int i=0; i< cars.length; i++) {
			cars[i] = new Car(i);
		}	
	}
	private void go() {
		for (int i=0; i< cars.length; i++) {
			cars[i].start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == go) {
			go();
		}else if (e.getSource() == init) {
			initGame();
		}
	}

}
