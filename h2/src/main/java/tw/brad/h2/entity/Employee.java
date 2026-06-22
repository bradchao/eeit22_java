package tw.brad.h2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@Column(name = "EmployeeID")
	private int employeeId;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "Title")
	private String title;

	// Brad05 的 multiselect 順序
//	public Employee(int employeeId, String firstName, String lastName, String title) {
//		this.employeeId = employeeId;
//		this.lastName = lastName;
//		this.firstName = firstName;
//		this.title = title;
//	}
	
	
}
