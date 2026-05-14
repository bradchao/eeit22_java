package tw.brad.tutor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import tw.brad.apis.Employee;

public class Brad76 {

	public static void main(String[] args) {
		Employee em1 = new Employee("Brad", 30000);
		Employee em2 = new Employee("Eric", 40000);
		Employee em3 = new Employee("Mark", 45000);
		Employee em4 = new Employee("Tony", 70000);
		Employee em5 = new Employee("Kevin", 60000);
		Employee em6 = new Employee("John", 55000);
		Employee em7 = new Employee("Mary", 32000);
		
		List<Employee> employees = List.of(em1, em2, em3, em4,em5, em6, em7);
		
		List<String> mgrs = employees.stream()
									.filter(e -> e.getSalary() >= 50000)
									.map(Employee::getName)
									.sorted()
									.limit(2)
									.collect(Collectors.toList());
		System.out.println(mgrs);
		
		employees.stream().filter(e -> e.getSalary() >= 50000)
							.forEach(e -> System.out.printf("%s : %d\n", e.getName(), e.getSalary()));
		
		
		
		

	}

}
