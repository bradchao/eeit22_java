package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.brad.apis.Bike;

public class Brad56 {
	public static void main(String[] args) {
		try(ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream("dir1/b1.bike"));){
			Object obj = oin.readObject();
			Bike b1 = (Bike)obj;
			System.out.println(b1);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
