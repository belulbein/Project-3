package studentManagement;
import java.util.Scanner;
import java.util.Random;

public class Driver {
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);

	System.out.println("Welcome to Course and Student Management System!\n"
			+ "This system will allow you to manage students and courses. Let’s start with the number of students this system will have: \n");

	int size = input.nextInt();
	Student[] obj = new Student[size]; // Creates a student array of whatever size
	Student_employee[] obj2 = new Student_employee[size];
	Course[] catalog = new Course[10];
	int courseCounter = 0;
	boolean menuLoop = true;
	int menu;
	int counter = -1;
	int EmploymentArrayOrder = 0;
	// int StudentID = (int) (Math.random() * 100);
	int managementOption;

	while(true) {
		System.out.println("***Welcome to Student and Course Management System***\n"
				+ "Press ‘1’ for Student Management System (SMS)\n" + "Press ‘2’ for Course Management System (CMS)\n" + "Press ‘0’ to exit\n");

		managementOption = input.nextInt();

		if (managementOption == 1) { // STUDENT MANAGEMENT SYSTEM OPTION
			menuLoop = true;
			while (menuLoop) {
				System.out.println("***Welcome to SMS***\n" + "Press '1' to add a student\n" + "Press '2' to deactivate a student\n"
						+ "Press '3' to display all students\n" + "Press '4' to search for a student by ID\n" + "Press '5' to assign on-campus job\n"
						+ "Press '6' to display all students with on-campus jobs\n" + "Press '0' to exit SMS\n");

				menu = input.nextInt();
				switch (menu) {
					
					// Adding a new student
					case 1:
						counter++;
						System.out.print("Enter the first name: ");
						String firstName = input.next();

						System.out.print("Enter the last name: ");
						String lastName = input.next();

						System.out.print("Enter the level of this student: ");
						String level = input.next();

						boolean active = true;

						
						Student newStudent = new Student(firstName, lastName, level, active, (int)(Math.random()*100));
						/*newStudent.StudentFirstName = firstName;
						newStudent.StudentLastName = lastName;
						newStudent.StudentGradeLevel = level;
						newStudent.StudentStatus = active;*/

						obj[counter] = newStudent;

						// Summary of adding a new student (First name, Last name, Grade level, and ID number)
						System.out.println("");
						System.out.print(newStudent.StudentFirstName + " " + newStudent.StudentLastName + " has been added as a " + newStudent.StudentGradeLevel
								+ " with ID " + newStudent.ReturnID());
						System.out.println("");
						break;

					//Deactivating a student
					case 2:
						System.out.print("Enter the ID for the student you want to deactivate: ");
						int Deactivate = input.nextInt();
						for (int a = 0; a < counter + 1; a++) {
							if (obj[a].ReturnID() == Deactivate) {
								obj[a].Deactivate();
								obj[a].ReceiveName();
								System.out.print(" Has been deactivated \n");
							}
						}
						break;

					//Displaying all students
					case 3:
						for (int b = 0; b < counter + 1; b++) {
							obj[b].AllStudents();
						}
						break;

					//Searching for a student by ID number
					case 4:
						System.out.print("Enter the student ID: ");
						int search = input.nextInt();
						for (int c = 0; c < counter + 1; c++) {
							if (obj[c].ReturnID() == search) {
								obj[c].AllStudents();
							}
						}
						break;

					//Assigning on-campus job
					case 5:
						System.out.print("Enter the student ID: ");
						search = input.nextInt();
						input.nextLine();

						System.out.print("Enter job: ");
						String Job = input.nextLine();

						System.out.print("Enter job type: ");
						String JobType = input.nextLine();

						for (int a = 0; a < obj.length; a++) {
							if (obj[a].ReturnID() == search) {
								obj[a].ReceiveName();
								System.out.print(" has been assigned " + JobType + " " + Job + "job");
								obj2[EmploymentArrayOrder] = new Student_employee(obj[a].ReturnID(),
										obj[a].returnFirstName(), obj[a].returnLastName(),
										obj[a].returnGradeLevel(), obj[a].returnStudentStatus(), JobType, Job);
								break;
							}
							else {
								// System.out.println("That student has not been found.");
							}
						}
						EmploymentArrayOrder++;
						break;

					//Displaying all students with on-campus job
					case 6:
						for (int a = 0; a < obj2.length; a++) {
							if(obj2[a] != null) {
								obj2[a].AllStudents();
							}
							else {
							}
						}
						break;
					//Exiting the SMS
					case 0:
						menuLoop = false;
						break;

				}
			}
		} else if (managementOption == 2) { // COURSE MANAGEMENT SYSTEM
			menuLoop = true;
			while (menuLoop) {
				System.out.println("***Welcome to CMS***\n" + "Press '1'to add a new course\n" + "Press '2'to assign student a new course\n"
						+ "Press '3' to display student with assigned courses\n" + "Press '0' to exit CMS\n");
				menu = input.nextInt();
				switch (menu) {
					
					//Adding a new course
					case 1:
						System.out.println("Enter Course ID: ");
						int courseID = input.nextInt();
						input.nextLine();
						System.out.println("Enter Course Name: ");
						String courseName = input.nextLine();

						Course newCourse = new Course(courseID, courseName);
						catalog[courseCounter] = newCourse;

						System.out.println("Confirmation: New course " + newCourse.CourseID + " has been added.");
						break;
					
					//Assigning student a new course
					case 2:
						System.out.println("Enter Student ID: ");
						int studentID = input.nextInt();
						System.out.println("Enter Course ID: ");
						int courseSearchID = input.nextInt();

						for(int a = 0; a < catalog.length; a++) {
							if (catalog[a].CourseID == courseSearchID) {
								catalog[a].registeredStudents[catalog[a].counter] = studentID;
								System.out.println("Confirmation: ");
								for (int b = 0; b < obj.length; b++) {
									if (obj[a].ReturnID() == studentID) {
										obj[a].ReceiveName();
										break;
									}
									else {
										// System.out.println("That student has not been found.");
									}
								}
								System.out.println(" has been assigned course " + courseSearchID);
								break;
							}
						}
						break;
					
					//Displaying all students with assigned course
					case 3:
						for (int a = 0; a < obj.length; a++) {
							if(obj[a] != null) {
								obj[a].AllStudents();
							}
							else {
							}
						}
						break;
					
					//Exiting the CMS
					case 0:
						menuLoop = false;
						break;

				}
			}

		} else if (managementOption == 0) {
			break;
		}
		else {
			System.out.println("Option not recognized. Please pick 0, 1 or 2.");
		}
	}
}
}