package 新功能.lambda;

import java.util.Arrays;
import java.util.List;

class Person2 {
	String name;
	int age;

	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}

	public static List<Person2> persons() {
		return Arrays.asList(new Person2("Max", 18), new Person2("Peter", 23), new Person2("Pamela", 23), new Person2(
				"David", 12));
	}
}
