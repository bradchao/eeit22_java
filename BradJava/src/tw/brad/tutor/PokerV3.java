package tw.brad.tutor;

public class PokerV3 {
	public static void main(String[] args) {
		final int nums = 6;
		int[] poker = new int[nums];
		for (int i=0; i<poker.length; i++) poker[i] = i;
		
		for (int i = nums - 1; i > 0; i--) {
			int r = (int)(Math.random()*(i+1));
			// poker[i] <-> poker[r]
			int temp = poker[i];
			poker[i] = poker[r];
			poker[r] = temp;
		}
		
		for (int card : poker) {
			System.out.println(card);
		}	
		System.out.println("---------");
		
		int[][] players = new int[4][13];
		
		
		
		
		
	}
}
