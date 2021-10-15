public class controller {

	public controller() {
		
	}
	
	public String getCurrentStudentName(student currentStudent) {
		return currentStudent.getName();
	}
	
	public String getCurrentStudentMatricNumber(student currentStudent) {
		return currentStudent.getMatricNumber();
	}
	
	public String getCurrentStudentRegisteredDate(student currentStudent) {
		return currentStudent.getRegisteredDate();
	}
	
	public boolean checkStudent(String typed_Account_Id, String typed_Password) {
		student student = new student();
		return student.checkStudent(typed_Account_Id, typed_Password);
	}
	
	public student getCurrentStudent(String typed_Account_Id, String typed_Password) {
		student currentStudent = new student();
		return currentStudent.getCurrentStudent(typed_Account_Id, typed_Password);
	}
	
	public boolean checkRegisteredStudent(String typed_Name, String typed_Matric_Number) {
		student currentStudent = new student();
		return currentStudent.checkRegisteredStudent(typed_Name, typed_Matric_Number);
	}
	
	public boolean checkNotRegisterStudent(String typed_Name, String typed_Matric_Number) {
		student currentStudent = new student();
		return currentStudent.checkNotRegisterStudent(typed_Name, typed_Matric_Number);
	}
	
	public boolean checkStaff(String typed_Account_Id, String typed_Password) {
		staff staff = new staff();
		return staff.checkStaff(typed_Account_Id, typed_Password);
	}
	
	public void login() {
		login login = new login();
		login.login_setVisible();
	}
	
	public void mainMenu(student currentStudent) {
		mainMenu mainMenu = new mainMenu(currentStudent);
		mainMenu.mainMenu_setVisible();
	}
	
	public void checkIn_CheckOut(student currentStudent) {
		checkIn_CheckOut checkIn_CheckOut = new checkIn_CheckOut(currentStudent);
		checkIn_CheckOut.checkIn_CheckOut_setVisible();
	}
	
	public void checkIn(student currentStudent) {
		checkIn checkIn = new checkIn(currentStudent);
		checkIn.checkIn_setVisible();
	}
	
	public void checkOut(student currentStudent) {
		checkOut checkOut = new checkOut(currentStudent);
		checkOut.checkOut_setVisible();
	}
	
	public void eKewangan(student currentStudent) {
		eKewangan eKewangan = new eKewangan(currentStudent);
		eKewangan.eKewangan_setVisible();
	}
	
	public void eKewangan_Paid(student currentStudent) {
		eKewangan_Paid eKewangan_Paid = new eKewangan_Paid(currentStudent);
		eKewangan_Paid.eKewangan_Paid_setVisible();
	}
	
	public void eKewangan_Unpaid(student currentStudent) {
		eKewangan_Unpaid eKewangan_Unpaid = new eKewangan_Unpaid(currentStudent);
		eKewangan_Unpaid.eKewangan_Unpaid_setVisible();
	}
	
	public void eKewangan_Due(student currentStudent) {
		eKewangan_Due eKewangan_Due = new eKewangan_Due(currentStudent);
		eKewangan_Due.eKewangan_Due_setVisible();
	}
	
	public void eKewangan_MakePayment(student currentStudent, String type) {
		eKewangan_MakePayment eKewangan_MakePayment = new eKewangan_MakePayment(currentStudent,type);
		eKewangan_MakePayment.eKewanagn_MakePayment_setVisible();
	}
	
	public void item_Checklist(student currentStudent) {
		item_Checklist item_Checklist = new item_Checklist(currentStudent);
		item_Checklist.item_Cghecklist_setVisible();
	}
	
	public void eFact(student currentStudent) {
		eFact eFact = new eFact(currentStudent);
		eFact.eFact_setVisible();
	}
	
	public void eFact_LossKey(student currentStudent) {
		eFact_LossKey eFact_LossKey = new eFact_LossKey(currentStudent);
		eFact_LossKey.eFact_LossKey_setVisible();
	}
	
	public void eFact_DamageFacility(student currentStudent) {
		eFact_DamageFacility eFact_DamageFacility = new eFact_DamageFacility(currentStudent);
		eFact_DamageFacility.eFact_DamageFacility_setVisible();
	}
	
	public void staff_MainMenu() {
		staff_MainMenu staff_MainMenu = new staff_MainMenu();
		staff_MainMenu.staff_MainMenu_setVisible();
	}
	
	public void staff_CheckIn_CheckOut() {
		staff_CheckIn_CheckOut staff_CheckIn_CheckOut = new staff_CheckIn_CheckOut();
		staff_CheckIn_CheckOut.staff_CheckIn_CheckOut_setVisible();
	}
	
	public void staff_CheckIn() {
		staff_CheckIn staff_CheckIn = new staff_CheckIn();
		staff_CheckIn.staff_CheckIn_setVisible();
	}
	
	public void staff_CheckOut() {
		staff_CheckOut staff_CheckOut = new staff_CheckOut();
		staff_CheckOut.staff_CheckOut_setVisible();
	}
	
	public void staff_eKewangan() {
		staff_eKewangan staff_eKewangan = new staff_eKewangan();
		staff_eKewangan.staff_eKewangan_setVisible();
	}
	
	public void staff_eKewangan_Status(String matricNumber) {
		staff_eKewangan_Status staff_eKewangan_Status = new staff_eKewangan_Status(matricNumber);
		staff_eKewangan_Status.staff_eKewangan_Status_setVisible();
	}
	
	public void staff_Item_Checklist() {
		staff_Item_Checklist staff_Item_Checklist = new staff_Item_Checklist();
		staff_Item_Checklist.staff_Item_Checklist_setVisible();
	}
	
	public void staff_Item_Checklist_Status(String matricNumber) {
		staff_Item_Checklist_Status staff_Item_Checklist_Status = new staff_Item_Checklist_Status(matricNumber);
		staff_Item_Checklist_Status.staff_Item_Checklist_Status_setVisible();
	}
	
	public void staff_eFact() {
		staff_eFact staff_eFact = new staff_eFact();
		staff_eFact.staff_eFact_setVisible();
	}
	
	public void staff_eFact_LossKey() {
		staff_eFact_LossKey staff_eFact_LossKey = new staff_eFact_LossKey();
		staff_eFact_LossKey.staff_eFact_LossKey_setVisible();
	}
	
	public void staff_eFact_DamageFacility() {
		staff_eFact_DamageFacility staff_eFact_DamageFacility = new staff_eFact_DamageFacility();
		staff_eFact_DamageFacility.staff_eFact_DamageFacility_setVisible();
	}
}