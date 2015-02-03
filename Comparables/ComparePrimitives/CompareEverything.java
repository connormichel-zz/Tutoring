package ComparePrimitives;

import java.util.Date;
import java.util.GregorianCalendar;

public class CompareEverything {

	public static void main(String[] args) {
		Integer[] numbers = {1, 2, 3};
		System.out.println(max(numbers));

		String[] words = {"red", "green", "blue"};
		System.out.println(max(words));

		Person[] people = {new Person(30), new Person(29), new Person(59)};
		System.out.println(max(people));

		Date[] dates = {
				new GregorianCalendar(2014,0,13).getTime(), 
				new GregorianCalendar(2021,11,31).getTime(), 
				new GregorianCalendar(2021,11,31,10,30,0).getTime(), 
				new GregorianCalendar(1995,2,31).getTime()};
		System.out.println(max(dates));
	}

	// define max method here
	public static <E extends Comparable<E>> E max (E[] list){
		E max = list[0];

		for (int i = 1; i < list.length; i++) {

			if (max.compareTo(list[i]) < 0) {
				max = list[i];
			}
		}

		return max;
	}
}

class Person implements Comparable<Person> {
	double age;

	public Person(double radius) {
		this.age = radius;
	}

	@Override
	public int compareTo(Person p) {
		if (age < p.age) 
			return -1;
		else if (age == p.age)
			return 0;
		else
			return 1;
	}

	@Override
	public String toString() {
		return "Person age: " + age;
	}
}
