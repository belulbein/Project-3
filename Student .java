package studentManagement;
import java.util.Random;
class Student {

	String StudentFirstName;
    String StudentLastName;
    String StudentGradeLevel;
    boolean StudentStatus = true;
    int StudentID; // (int)(Math.random()*100);
    
    Student (String firstName, String lastName, String gradeLevel,
			boolean studentStatus,int studentID){
        this.StudentFirstName = firstName;
        this.StudentLastName = lastName;
        this.StudentGradeLevel = gradeLevel;
        this.StudentStatus = studentStatus;
        this.StudentID = studentID;
    }
	public String ReceiveName() {
        System.out.print(StudentFirstName + " " + StudentLastName);
        return StudentFirstName + StudentLastName;
    }
    public String returnFirstName () {
    	return StudentFirstName;
    }
    public String returnLastName () {
    	return StudentLastName;  
    }
    public String returnGradeLevel () {
    	return StudentGradeLevel;
    }
    public boolean returnStudentStatus () {
    	return StudentStatus;
    }
    public void ReceiveID() {
        System.out.print(StudentID);
    }
    public int ReturnID() {
        return StudentID;
    }
    public boolean Deactivate(){
    	StudentStatus = false;
        return StudentStatus;
    }
    public void AllStudents() {
        System.out.println(StudentFirstName + " " + StudentLastName);
        System.out.println("Level: " + StudentGradeLevel);
        System.out.println("ID: " + StudentID);
        if(StudentStatus= false)
            System.out.println("Status: Inactive");
        else if (StudentStatus=true)
            System.out.println("Status: Active");
        System.out.println("");
    }
}
  
   


