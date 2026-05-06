package tw.brad.tutor;

public class Brad32 {
	public static void main(String[] args) {
		//Brad321 obj1 = new Brad321();
		Brad321 obj1 = new Brad322();
		obj1.m1();
		obj1.m2();
		
	}
}
abstract class Brad321 {
	Brad321(){System.out.println("Brad321()");}
	void m1() {System.out.println("Brad321:m1()");}
	abstract void m2();
}
class Brad322 extends Brad321 {
	void m2() {System.out.println("Brad322:m2()");}
}
