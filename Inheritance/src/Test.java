
public class Test {

	public static void main(String[] args) {
		Person aPerson = new Person("Elliot", "Lyons", "Naas", 123456);
		aPerson.display();
		
		Student aStudent = new Student("Elliot", "Lyons", "Naas", 123456, 4.0);
		aStudent.display();
		
		Employee anEmployee = new Employee("Elliot", "Lyons", "Naas", 123456, "Manager");
		anEmployee.display();
	}

}
