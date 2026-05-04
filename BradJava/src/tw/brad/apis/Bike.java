package tw.brad.apis;

public class Bike {
	// has-a
	protected double speed;
	/*
	 * private :  本類別
	 * 沒寫 : 相同 package
	 * protected : 子類別 + 相同 package
	 * public: 全世界
	 */
	
	public void upSpeed() {
		speed = speed < 1? 1: speed * 1.4;
	}
	
	public void downSpeed() {
		speed = speed < 1? 0 : speed * 0.7;
	}
	
	public double getSpeed() {
		return speed;
	}
}
