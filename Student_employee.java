package studentManagement;

public class Student_employee extends Student{
	
	String EmploymentType;
	String JobType;

Student_employee (int StudentID, String StudentFirstName, String StudentLastName, String StudentGradeLevel, 
		boolean StudentStatus, String EmploymentType, String JobType){
	super( StudentFirstName,  StudentLastName,  StudentGradeLevel,
			StudentStatus, StudentID);
	this.EmploymentType = EmploymentType;
	this.JobType = JobType;
}

public void Students() {
	System.out.println(StudentFirstName + " " + StudentLastName);
	System.out.println("ID: " + StudentID);
	System.out.println(JobType + " " + EmploymentType);
	System.out.println("");
}
}