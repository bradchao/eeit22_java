package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class MemberDaoImpl implements MemberDao{
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	
	private static final String SQL_ADD = """
			INSERT INTO member
			(account, passwd)
			VALUES
			(?,?)
			""";	
	@Override
	public boolean addMember(Member member) throws Exception {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_ADD)){

			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
			return pstmt.executeUpdate() > 0;
		}
	}

	private static final String SQL_UPDATE = """
			UPDATE member
			SET passwd = ?
			WHERE id = ?
			""";	
	@Override
	public boolean updateMember(Member member) throws Exception {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE)){

			pstmt.setString(1, BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
			pstmt.setLong(2, member.getId());
			return pstmt.executeUpdate() > 0;
		}
	}

	private static final String SQL_DELETE = """
			DELETE FROM member
			WHERE id = ?
			""";	
	@Override
	public boolean delMember(Member member) throws Exception {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE)){

			pstmt.setLong(1, member.getId());
			return pstmt.executeUpdate() > 0;
		}
	}

	@Override
	public Member findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member login(String account, String passwd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
