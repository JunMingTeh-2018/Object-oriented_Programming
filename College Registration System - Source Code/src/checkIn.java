import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class checkIn {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title, lbl_name, lbl_matric_number;
	private JTextField txt_name, txt_matric_number;
	private JButton btn_check_in, btn_back;
	
	public checkIn(student currentStudent) {
		this.currentStudent = currentStudent;
		initialize();
	}
	
	public void checkIn_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("Check In");
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("CHECK IN");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setBounds(10, 39, 676, 43);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		frame.getContentPane().add(lbl_title);
		
		lbl_name = new JLabel("Name");
		lbl_name.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_name.setBounds(91, 129, 166, 37);
		lbl_name.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		frame.getContentPane().add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setBounds(274, 138, 355, 25);
		txt_name.setColumns(10);
		txt_name.setText(controller.getCurrentStudentName(currentStudent));
		frame.getContentPane().add(txt_name);
		
		lbl_matric_number = new JLabel("Matric Number");
		lbl_matric_number.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_matric_number.setBounds(91, 183, 166, 37);
		lbl_matric_number.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		frame.getContentPane().add(lbl_matric_number);
		
		txt_matric_number = new JTextField();
		txt_matric_number.setBounds(274, 192, 355, 25);
		txt_matric_number.setColumns(10);
		txt_matric_number.setText(controller.getCurrentStudentMatricNumber(currentStudent));
		frame.getContentPane().add(txt_matric_number);
		
		btn_check_in = new JButton("CHECK IN");
		btn_check_in.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_check_in.setBounds(229, 271, 244, 37);
		btn_check_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!(txt_matric_number.getText().equals(""))) && (!(txt_name.getText().equals("")))) {
					String typed_Name = txt_name.getText();
					String typed_Matric_Number = txt_matric_number.getText();
					if(controller.checkRegisteredStudent(typed_Name, typed_Matric_Number) == true) {
						JOptionPane.showMessageDialog(null, "You Have Successfully Check-in College");
						controller.checkIn_CheckOut(currentStudent);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Error : Invalid Matric Number / Staff Number or Password OR You Had Checked-in College");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please Complete the Details !");
				}
			}
		});
		frame.getContentPane().add(btn_check_in);
		
		btn_back = new JButton("BACK");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(295, 337, 111, 37);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.checkIn_CheckOut(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}