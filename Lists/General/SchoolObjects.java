package General;

import java.util.ArrayList;

public class SchoolObjects {

	public static void main(String[] args) {
		CourseArray courseArray1 = new CourseArray("Advanced Arrays");
		courseArray1.addStudent("S1");
		courseArray1.addStudent("S2");
		courseArray1.addStudent("S3");

		CourseArray courseArray2 = (CourseArray) courseArray1.clone();
		courseArray2.addStudent("S4");
		courseArray2.addStudent("S5");
		courseArray2.addStudent("S6");

		courseArray2.dropStudent("S2");

		printCourseStats(courseArray1);
		printCourseStats(courseArray2);

		CourseList courseList1 = new CourseList("Introduction to Lists");
		courseList1.addStudent("S1");
		courseList1.addStudent("S2");
		courseList1.addStudent("S3");

		CourseList courseList2 = (CourseList) courseList1.clone();
		courseList2.addStudent("S4");
		courseList2.addStudent("S5");
		courseList2.addStudent("S6");

		courseList2.dropStudent("S2");

		printCourseStats(courseList1);
		printCourseStats(courseList2);
	}

	public static void printCourseStats(Course course){
		System.out.println("Course: " + course.getCourseName());
		System.out.println("Number of students in course: " 
				+ course.getNumberOfStudents());
		System.out.print("Students: ");
		String[] students = course.getStudents();
		for (int i = 0; i < course.getNumberOfStudents()-1; i++)
			System.out.print(students[i] + ", ");
		System.out.println(students[course.getNumberOfStudents()-1] + System.lineSeparator());
	}
}

class CourseArray implements Course, Cloneable {
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;

	public CourseArray(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public void addStudent(String student) {
		students[numberOfStudents] = student;
		numberOfStudents++;
	}

	@Override
	public String[] getStudents() {
		return students;
	}

	@Override
	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	@Override
	public String getCourseName() {
		return courseName;
	}

	@Override
	public void dropStudent(String student) {
		for (int i = 0; i < numberOfStudents; i++) {
			if (students[i].equals(student)) {
				// Move students[i + 1] to students[i], etc.
				for (int k = i + 1; k < numberOfStudents; k++) {
					students[k - 1] = students[k];
				}

				numberOfStudents--;
				break;
			}
		}
	}

	public Object clone() {
		try {
			CourseArray clone = (CourseArray) super.clone();
			clone.students = students.clone();
			return clone;
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}

class CourseList implements Course, Cloneable {
	private String courseName;
	private ArrayList<String> students = new ArrayList<String>();

	public CourseList(String courseName){
		this.courseName = courseName;
	}

	@Override
	public void addStudent(String student){
		students.add(student);
	}

	@Override
	public String[] getStudents(){
		return students.toArray(new String[0]);
	}

	@Override
	public int getNumberOfStudents(){
		return students.size();
	}

	@Override
	public String getCourseName(){
		return courseName;
	}

	@Override
	public void dropStudent(String student){
		students.remove(student);
	}

	public Object clone() {
		try {
			CourseList clone = (CourseList) super.clone();
			clone.students = (ArrayList<String>) students.clone();
			return clone;
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}

interface Course {

	void addStudent(String student);

	String[] getStudents();

	int getNumberOfStudents();

	String getCourseName();

	void dropStudent(String student);

}
