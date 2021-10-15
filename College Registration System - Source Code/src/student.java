import java.util.*;
import java.io.*;
import java.text.*;

public class student {
	private String name, matricNumber, password, registeredDate;
	private boolean registration;
	private ArrayList<student> studentList = new ArrayList<student>();
	
	public student() {
		
	}
	
	public student(String name,String matricNumber,String password, boolean registration, String registeredDate) {
		this.name = name;
		this. matricNumber = matricNumber;
		this.password = password;
		this.registration = registration;
		this.registeredDate = registeredDate;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMatricNumber() {
		return matricNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getRegistration() {
		return registration;
	}
	
	public String getRegisteredDate() {
		return registeredDate;
	}
	
	public void getStudentList() {
		try {
			File file = new File("student_list.txt");
			Scanner scanner = new Scanner(file);
    	    while (scanner.hasNextLine()) {
    	        name = scanner.nextLine();
    	        matricNumber = scanner.nextLine();
    	        password = scanner.nextLine();
    	        String registration = scanner.nextLine();
    	        if (registration.equals("true")) {
    	        	registeredDate = scanner.nextLine();
    	        	student student = new student(name,matricNumber,password,Boolean.parseBoolean(registration),registeredDate);
        	        studentList.add(student);
    	        } else {
    	        	student student = new student(name,matricNumber,password,Boolean.parseBoolean(registration),null);
        	        studentList.add(student);
    	        }
    	    }
    	    scanner.close();
    	} catch (Exception e) { 
    		e.printStackTrace();
    	}
	}
	
	public boolean checkStudent(String typed_Account_Id, String typed_Password) {
		getStudentList();
		for (student student : studentList) {
			if(typed_Account_Id.equalsIgnoreCase(student.matricNumber) && typed_Password.equals(student.password)) {
				return true;
			}
		}
		return false;
	}
	
	public student getCurrentStudent(String typed_Account_Id, String typed_Password) {
		getStudentList();
		for (student student : studentList) {
			if(typed_Account_Id.equalsIgnoreCase(student.matricNumber) && typed_Password.equals(student.password)) {
				if (student.registration == true) {
					student currentStudent = new student(student.name,student.matricNumber,student.password,student.registration,student.registeredDate);
					return currentStudent;
				} else {
					student currentStudent = new student(student.name,student.matricNumber,student.password,student.registration,null);
					return currentStudent;
				}
			}
		}
		return null;
	}
	
	public boolean checkRegisteredStudent(String typed_Name, String typed_Matric_Number) {
		getStudentList();
		for (student student : studentList) {
			if(typed_Name.equalsIgnoreCase(student.name) && typed_Matric_Number.equalsIgnoreCase(student.matricNumber)) {
				if (student.registration == false) {
					student.registration = true;
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					student.registeredDate = sdf.format(date);
					SimpleDateFormat sdf2 = new SimpleDateFormat("E dd/MM/yyyy");
					try {
						File file = new File("students_check_in_list.txt");
						PrintWriter mywriter = new PrintWriter (new FileWriter(file,true));
						mywriter.write("- " + student.name + ", " + student.matricNumber + ", " + sdf2.format(date) + "\n");
						mywriter.close();
					} catch(Exception e) {
						e.printStackTrace();
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkNotRegisterStudent(String typed_Name, String typed_Matric_Number) {
		getStudentList();
		for (student student : studentList) {
			if(typed_Name.equalsIgnoreCase(student.name) && typed_Matric_Number.equalsIgnoreCase(student.matricNumber)) {
				if (student.registration == true) {
					student.registration = false;
					student.registeredDate = null;
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("E dd/MM/yyyy");
					try {
						File file = new File("students_check_out_list.txt");
						PrintWriter mywriter = new PrintWriter (new FileWriter(file,true));
						mywriter.write("- " + student.name + ", " + student.matricNumber + ", " + sdf.format(date) + "\n");
						mywriter.close();
					} catch(Exception e) {
						e.printStackTrace();
					}
					return false;
				}
			}
		}
		return true;
	}
}