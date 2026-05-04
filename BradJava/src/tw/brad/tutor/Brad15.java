package tw.brad.tutor;

public class Brad15 {
	public static void main(String[] args) {
		int[] p = new int[7];
		
		for (int i=0; i<10000000; i++) {
			int point = (int)(Math.random() * 6) + 1;	// 1 ~ 6
			
			if (point >= 1 && point <=6) p[point]++;
			else p[0]++;
		}
		
		if (p[0] == 0) {
			for (int i=1; i<= 6; i++) {
				System.out.printf("%d點出現%d次\n",i, p[i]);
			}
		}else {
			System.out.println("ERROR");
		}
		
		
		
		
	}
}
