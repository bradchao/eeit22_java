package tw.brad.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.brad.apis.Bike;

public class Brad55 {
	public static void main(String[] args) {
		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed().upSpeed();
		System.out.println(b1);
		
		try(ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream("dir1/b1.bike"));){
			oout.writeObject(b1);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
}
