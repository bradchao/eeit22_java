package tw.brad.tutor;

import tw.brad.apis.Bike;
import tw.brad.apis.Scooter;

public class Brad21 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Scooter s1 = new Scooter();
		s1.upSpeed();s1.upSpeed();s1.upSpeed();
		s1.upSpeed();s1.upSpeed();s1.upSpeed();
		s1.downSpeed();
		System.out.println(s1.getSpeed());
	}

}
