import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class eFact_DamageFacility {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title, lbl_room_number, lbl_facility_damage, lbl_description;
	private JTextField txt_room_number, txt_facility_damage, txt_description;
	private JButton btn_submit, btn_back;

	public eFact_DamageFacility(student currentStudent) {
		this.currentStudent = currentStudent;
		initialize();
	}

	public void eFact_DamageFacility_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eFact Report Damage of Room Facilities");
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Report Damage of Room Facilities");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 27, 676, 47);
		frame.getContentPane().add(lbl_title);
		
		lbl_room_number = new JLabel("Room Number");
		lbl_room_number.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_room_number.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_room_number.setBounds(64, 103, 172, 24);
		frame.getContentPane().add(lbl_room_number);
		
		txt_room_number = new JTextField();
		txt_room_number.setColumns(10);
		txt_room_number.setBounds(246, 108, 379, 20);
		frame.getContentPane().add(txt_room_number);		
		
		lbl_facility_damage = new JLabel("Facility Damage");
		lbl_facility_damage.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_facility_damage.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_facility_damage.setBounds(64, 149, 172, 24);
		frame.getContentPane().add(lbl_facility_damage);
		
		txt_facility_damage = new JTextField();
		txt_facility_damage.setBounds(246, 154, 379, 20);
		txt_facility_damage.setColumns(10);
		frame.getContentPane().add(txt_facility_damage);
		
		lbl_description = new JLabel("Description of the Facility Damage");
		lbl_description.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_description.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_description.setBounds(10, 199, 676, 24);
		frame.getContentPane().add(lbl_description);
		
		txt_description = new JTextField();
		txt_description.setColumns(10);
		txt_description.setBounds(64, 234, 561, 63);
		frame.getContentPane().add(txt_description);
		
		btn_submit = new JButton("SUBMIT");
		btn_submit.setBackground(UIManager.getColor("Button.background"));
		btn_submit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_submit.setBounds(255, 318, 205, 41);
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!(txt_room_number.getText().equals(""))) && (!(txt_facility_damage.getText().equals(""))) && (!(txt_description.getText().equals("")))) {
					JOptionPane.showMessageDialog(null, "You have successfully reported your issue and we will help you within 3 working days");
					try {
						File file = new File("damage_of_room_facilities_report.txt");
						PrintWriter mywriter = new PrintWriter (new FileWriter(file,true));
						mywriter.write("- Room Number: " + txt_room_number.getText() + ", " + "Facility Damage: " + txt_facility_damage.getText() + ", " + "Description of the Facility Damage: " + txt_description.getText() + "\n\n");
					    mywriter.close();
					    controller.eFact(currentStudent);
						frame.dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Complete the Details !");
				}
			}
		});
		frame.getContentPane().add(btn_submit);
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(306, 372, 105, 29);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eFact(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}