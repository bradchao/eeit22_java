package tw.brad.tutor;

public class Brad67 {
	public static void main(String[] args) {
		System.out.println("start");
		Brad671 t1 = new Brad671("A");
		Brad671 t2 = new Brad671("B");
		Thread t3 = new Thread(new Brad672("C"));
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		}catch(Exception e) {
			
		}
		
		System.out.println("end");
	}
}

class Brad671 extends Thread{
	String name;
	Brad671(String name){this.name = name;}
	@Override
	public void run() {
		for (int i= 0; i<20; i++) {
			System.out.println(name + " " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Brad672 implements Runnable {
	String name;
	Brad672(String name){this.name = name;}

	@Override
	public void run() {
		for (int i= 0; i<20; i++) {
			System.out.println(name + " " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		
	}
	
}
