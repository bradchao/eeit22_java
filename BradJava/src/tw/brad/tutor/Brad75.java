package tw.brad.tutor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Brad75 {
	public static void main(String[] args) {
		List<Integer> numbers = 
			IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
		//System.out.println(numbers);
		
		List<Integer> primes = numbers.stream()
								.filter(Brad75::isPrime)
								.collect(Collectors.toList());
		
		System.out.println(primes);
		
	}
	
	public static boolean isPrime(int n) {
		if (n == 1) return false;
		
		return IntStream.rangeClosed(2, (int)Math.sqrt(n))
						.noneMatch(i -> n % i == 0);
	}
	
}
