package tw.brad.tutor;

public class Brad73 {

	public static void main(String[] args) {
		MathOperation add1 = new MathOperation() {
			@Override
			public int operate(int a, int b) {
				return a + b;
			}
		};
		System.out.println(add1.operate(10, 3));
		
		System.out.println("-----");
		
		MathOperation add2 = (a, b) -> a + b; 
		
		System.out.println(add2.operate(10, 3));
		
		
	}

}
//@FunctionalInterface
interface MathOperation {
	int operate(int a, int b);
}