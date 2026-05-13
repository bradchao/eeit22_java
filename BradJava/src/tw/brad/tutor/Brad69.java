package tw.brad.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad69 {
	public static void main(String[] args) {
		Timer timer = new Timer(true);
		timer.schedule(new Brad691(), 0, 1000);
		System.out.println("start");
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
		}
		System.out.println("end");
	}
}
class Brad691 extends TimerTask {
	int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}
