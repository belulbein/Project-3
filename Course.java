package studentManagement;

public class Course extends Driver{

	int CourseID;
	String CourseName;
	int registeredStudents[] = new int[10];
	int counter = 0;

	Course (int courseID, String courseName) {
		this.CourseID = courseID;
		this.CourseName = courseName;
	}

	public void assignStudent(int studentID) {
		registeredStudents[counter] = studentID;
	}

	public void ReceiveCourse() {
	System.out.print(CourseName);
	}

	public void AllStudents(Student s) {
		System.out.println(s.StudentFirstName + " " + s.StudentLastName);
        System.out.println("ID: " + s.StudentID);
        System.out.println("ID: " + CourseID);
	}
}