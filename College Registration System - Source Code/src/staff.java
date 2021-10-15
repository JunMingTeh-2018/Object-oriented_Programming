import java.util.*;
import java.io.*;

public class staff {
	private String name, staffNumber, password;
	private ArrayList<staff> staffList = new ArrayList<staff>();
	
	public staff() {
		
	}
	
	public staff(String name,String staffNumber,String password) {
		this.name = name;
		this.staffNumber = staffNumber;
		this.password = password;
	}
	
	public void getStaffList() {
		try {
			File file = new File("staff_list.txt");
    	    Scanner scanner = new Scanner(file);
    	    while (scanner.hasNextLine()) {
    	        name = scanner.nextLine();
    	        staffNumber = scanner.nextLine();
    	        password = scanner.nextLine();
    	        staff staff = new staff(name,staffNumber,password);
    	        staffList.add(staff);
    	    }
    	    scanner.close();
    	} catch (Exception e) { 
    		e.printStackTrace();
    	}
	}
	
	public boolean checkStaff(String typed_Account_Id, String typed_Password) {
		getStaffList();
		for (staff staff : staffList) {
			if(typed_Account_Id.equalsIgnoreCase(staff.staffNumber) && typed_Password.equals(staff.password)) {
				return true;
			}
		}
		return false;
	}
}