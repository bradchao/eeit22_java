package tw.brad.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;
import tw.brad.apis.Member;

public class Jdbc18 {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWDS = "root";
	private static final String SQL_LOGIN = """
			SELECT id, account, passwd
			FROM member
			WHERE account = ?
			""";
	private static final String SQL_CHPASSWD = """
			""";
	private static Properties prop = new Properties();

	public static void main(String[] args) {
		System.out.println("Member Login");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.nextLine();
		System.out.print("Password: ");
		String passwd = scanner.nextLine();
		
		prop.put("user", USER);
		prop.put("password", PASSWDS);
		prop.put("useSSL", false);
		
		try {
			Member member = login(account,passwd);
			if (member != null) {
				System.out.printf("Welcome, %s (%d)", member.getAccount(), member.getId());
			}else {
				System.out.println("Login Failure");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

	private static Member login(String account, String passwd) throws Exception {
		try(Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN)){
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(passwd, rs.getString("passwd"))) {
					return new Member(
							rs.getLong("id"), 
							rs.getString("account"), 
							rs.getString("passwd"));
				}else {
					return null;
				}
			}else {
				return null;
			}
		}
	}
	
}
