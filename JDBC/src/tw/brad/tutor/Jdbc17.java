package tw.brad.tutor;

import java.util.Properties;
import java.util.Scanner;

public class Jdbc17 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "brad";
	private static final String PASSWDS = "root";
	private static final String SQL_REG = """
			INSERT INTO member
				(account, passwd)
			VALUES
				(?,?)
			""";
	private static final String SQL_CHECK1 = """
			SELECT account
			FROM member
			WHERE account = ?
			""";
	private static final String SQL_CHECK2 = """
			SELECT COUNT(account) count
			FROM member
			WHERE account = ?
			""";
	private static Properties prop = new Properties();

	public static void main(String[] args) {
		System.out.println("Member Register");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.nextLine();
		System.out.print("Password: ");
		String passwd = scanner.nextLine();
		
		prop.put("user", USER);prop.put("password", PASSWDS);
		
		if (!isAccountExist(account)) {
			if (regMember(account, passwd)) {
				System.out.println("Register Success");
			}else {
				System.out.println("Register Failure");
			}
		}else {
			System.out.println("Account EXIST!");
		}
	}
	
	private static boolean isAccountExist(String account) {
		return true;
	}
	
	private static boolean regMember(String account, String passwd) {
		return true;
	}

}
