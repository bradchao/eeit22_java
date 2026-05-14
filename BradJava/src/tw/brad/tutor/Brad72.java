package tw.brad.tutor;

public class Brad72 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("OK");
			}
		}).start();
		System.out.println("----");
		// Lambda
		new Thread(() -> System.out.println("OK2")).start();
		
		
	}
}
