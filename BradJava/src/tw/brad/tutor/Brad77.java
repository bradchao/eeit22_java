package tw.brad.tutor;

import tw.brad.apis.Member;

public class Brad77 {
	public static void main(String[] args) {
		Member member = new Member.Builder()
							.age(18)
							.email("brad@brad.tw")
							.id(1)
							.name("Brad")
							.build();
		System.out.println(member.getEmail());
		System.out.println(member.getPasswd());
		
	}
}
