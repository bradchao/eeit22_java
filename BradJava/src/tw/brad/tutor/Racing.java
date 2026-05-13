package tw.brad.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame implements ActionListener{
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	
	public Racing() {
		super("Racing");
		
		setLayout(new GridLayout(9, 1));
		go = new JButton("Go!");
		add(go); go.addActionListener(this);
		
		lanes = new JLabel[8];
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + ". ");
			add(lanes[i]);
		}
		
		setSize(1024, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class Car extends Thread {
		int lane;
		StringBuffer data;
		Car(int lane){
			this.lane = lane;
			data = new StringBuffer((lane+1) + ". ");
		}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				data.append(">");
				lanes[lane].setText(data.toString());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Racing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cars = new Car[8];
		for (int i=0; i< cars.length; i++) {
			cars[i] = new Car(i);
			cars[i].start();
		}
	}

}
