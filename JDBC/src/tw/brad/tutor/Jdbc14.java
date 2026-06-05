package tw.brad.tutor;

import tw.brad.apis.BCrypt;

public class Jdbc14 {
	public static void main(String[] args) {
		String passwd= "123456";
		String hash_passwd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hash_passwd);
	}
}
