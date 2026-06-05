package tw.brad.tutor;

import tw.brad.apis.BCrypt;

public class Jdbc15 {

	public static void main(String[] args) {
		String input = "123456";
		String passwd = "$2a$10$0bfZqeCNGL.uCh1aep15ruKCxelEzOyCxfSRQBd7RWkVFu/Q/nxDO";
		if (BCrypt.checkpw(input, passwd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
