package tw.brad.tutor;

public class Brad31 {
	public static void main(String[] args) {

	}
}
class Brad311 {
	Brad311(){System.out.println("Brad311()");}
	void m1() {System.out.println("Brad311:m1()");}
}
class Brad312 extends Brad311{
	Brad312(){System.out.println("Brad312()");}
	void m1() {System.out.println("Brad312:m1()");}
	void m2() {System.out.println("Brad312:m2()");}
}
class Brad313 extends Brad311{
	Brad313(){System.out.println("Brad313()");}
	void m1() {System.out.println("Brad313:m1()");}
	void m2() {System.out.println("Brad313:m2()");}
	void m3() {System.out.println("Brad313:m3()");}
}

