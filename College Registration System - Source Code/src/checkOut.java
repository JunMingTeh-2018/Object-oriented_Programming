import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class checkOut extends login {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title, lbl_name, lbl_matric_number, lbl_checkin_date;
	private JTextField txt_name, txt_matric_number, txt_checkin_date;
	private JButton btn_check_out, btn_back;

	public checkOut(student student) {
		currentStudent = student;
		initialize();
	}
	
	public void checkOut_setVisible() {
		frame.setVisible(true);
	}
	
	public void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("Check Out");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 700, 450);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("CHECK OUT");
		lbl_title.setBounds(10, 38, 676, 48);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		frame.getContentPane().add(lbl_title);
		
		lbl_name = new JLabel("Name");
		lbl_name.setBounds(73, 122, 165, 21);
		lbl_name.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_name.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		frame.getContentPane().add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setBounds(264, 122, 361, 23);
		txt_name.setHorizontalAlignment(SwingConstants.LEFT);
		txt_name.setColumns(10);
		txt_name.setText(controller.getCurrentStudentName(currentStudent));
		frame.getContentPane().add(txt_name);
		
		lbl_matric_number = new JLabel("Matric Number");
		lbl_matric_number.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_matric_number.setBounds(73, 167, 165, 27);
		lbl_matric_number.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		frame.getContentPane().add(lbl_matric_number);
		
		txt_matric_number = new JTextField();
		txt_matric_number.setBounds(264, 167, 361, 24);
		txt_matric_number.setHorizontalAlignment(SwingConstants.LEFT);
		txt_matric_number.setColumns(10);
		txt_matric_number.setText(controller.getCurrentStudentMatricNumber(currentStudent));
		frame.getContentPane().add(txt_matric_number);
		
		lbl_checkin_date = new JLabel("Check In Date");
		lbl_checkin_date.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_checkin_date.setFont(new Font("Microsoft Tai Le", Font.BOLD, 18));
		lbl_checkin_date.setBounds(73, 214, 165, 27);
		frame.getContentPane().add(lbl_checkin_date);
		
		txt_checkin_date = new JTextField();
		txt_checkin_date.setHorizontalAlignment(SwingConstants.LEFT);
		txt_checkin_date.setColumns(10);
		txt_checkin_date.setBounds(264, 214, 361, 24);
		txt_checkin_date.setText(controller.getCurrentStudentRegisteredDate(currentStudent));
		frame.getContentPane().add(txt_checkin_date);
		
		btn_check_out = new JButton("CHECK OUT");
		btn_check_out.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_check_out.setBounds(242, 278, 223, 37);
		btn_check_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!(txt_matric_number.getText().equals(""))) && (!(txt_name.getText().equals(""))) && (!(txt_checkin_date.getText().equals("")))) {
					int result = JOptionPane.showConfirmDialog(null,"Do you want to check out from college ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						String typed_Name = txt_name.getText();
						String typed_Matric_Number = txt_matric_number.getText();
						if(controller.checkNotRegisterStudent(typed_Name, typed_Matric_Number) == false) {
							JOptionPane.showMessageDialog(null, "You Have Successfully Check Out from College");
							controller.checkIn_CheckOut(currentStudent);
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Error : Invalid Matric Number / Staff Number or Password OR You Had Checked Out from College");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please Complete the Details !");
				}
			}
		});
		frame.getContentPane().add(btn_check_out);
		
		btn_back = new JButton("BACK");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(306, 336, 102, 29);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.checkIn_CheckOut(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}