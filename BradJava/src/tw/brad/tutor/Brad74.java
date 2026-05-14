package tw.brad.tutor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Brad74 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(numbers);
		List<Integer> evens = numbers.stream()
									.filter(n -> n % 2 == 0)
									.collect(Collectors.toList());
		System.out.println(evens);
		//--------------------------
		List<Integer> nums = Arrays.asList(2, 1, 3, 3, 4, 1, 2, 5);
		List<Integer> result = nums.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(result);
		//--------------------------
		List<String> names = Arrays.asList("Brad","Andy","Eric","Andy", "Tony","Mark");
		names.stream().forEach(System.out::println);
		boolean isAndy = names.stream().anyMatch(n -> n.equals("Andy"));
		System.out.println(isAndy);
		
		
		
		
	}

}
