import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class eFact_LossKey {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title, lbl_matric_number, lbl_name, lbl_phone_number, lbl_room_number, lbl_when_loss;
	private JTextField txt_matric_number, txt_name, txt_phone_number, txt_room_number, txt_when_loss;
	private JButton btn_submit, btn_back;
	
	public eFact_LossKey(student currentStudent) {
		this.currentStudent = currentStudent;
		initialize();
	}
	
	public void eFact_LossKey_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eFact Report Loss of Room Key");
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Report Loss of Room Key");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 32, 676, 38);
		frame.getContentPane().add(lbl_title);
		
		lbl_matric_number = new JLabel("Matric Number");
		lbl_matric_number.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_matric_number.setBounds(55, 93, 161, 24);
		frame.getContentPane().add(lbl_matric_number);
		
		txt_matric_number = new JTextField();
		txt_matric_number.setToolTipText("");
		txt_matric_number.setBounds(226, 97, 410, 20);
		txt_matric_number.setColumns(10);
		txt_matric_number.setText(controller.getCurrentStudentMatricNumber(currentStudent));
		frame.getContentPane().add(txt_matric_number);
		
		lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_name.setBounds(55, 137, 161, 24);
		frame.getContentPane().add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(226, 141, 410, 20);
		txt_name.setText(controller.getCurrentStudentName(currentStudent));
		frame.getContentPane().add(txt_name);
		
		lbl_phone_number = new JLabel("Phone Number");
		lbl_phone_number.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_phone_number.setBounds(55, 184, 161, 24);
		frame.getContentPane().add(lbl_phone_number);
		
		txt_phone_number = new JTextField();
		txt_phone_number.setColumns(10);
		txt_phone_number.setBounds(226, 188, 410, 20);
		frame.getContentPane().add(txt_phone_number);
		
		lbl_room_number = new JLabel("Room Number");
		lbl_room_number.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_room_number.setBounds(55, 231, 166, 24);
		frame.getContentPane().add(lbl_room_number);
		
		txt_room_number = new JTextField();
		txt_room_number.setColumns(10);
		txt_room_number.setBounds(226, 235, 410, 20);
		frame.getContentPane().add(txt_room_number);
		
		lbl_when_loss = new JLabel("When the Key Lost");
		lbl_when_loss.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_when_loss.setBounds(55, 275, 166, 24);
		frame.getContentPane().add(lbl_when_loss);
		
		txt_when_loss = new JTextField();
		txt_when_loss.setColumns(10);
		txt_when_loss.setBounds(226, 280, 410, 20);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E dd/MM/yyyy");
		txt_when_loss.setText(sdf.format(date));
		frame.getContentPane().add(txt_when_loss);
		
		btn_submit = new JButton("SUBMIT");
		btn_submit.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_submit.setBounds(248, 321, 212, 38);
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!(txt_matric_number.getText().equals(""))) && (!(txt_name.getText().equals(""))) && (!(txt_phone_number.getText().equals(""))) && (!(txt_room_number.getText().equals(""))) && (!(txt_when_loss.getText().equals("")))) {
					JOptionPane.showMessageDialog(null, "You have successfully reported your issue and we will help you as soon as possible");
					try {
						File file = new File("loss_of_room_key_report.txt");
						PrintWriter mywriter = new PrintWriter (new FileWriter(file,true));
						mywriter.write("- Matric Number: " + txt_matric_number.getText() + ", " + "Name: " + txt_name.getText() + ", " + "Phone Number: " + txt_phone_number.getText() + "\n");
						mywriter.write("  Room Number: " + txt_room_number.getText() + ", " + "When the Key Lost: " + txt_when_loss.getText() + "\n\n");
						mywriter.close();
					    controller.eFact(currentStudent);
						frame.dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please Complete the Details !");
				}
			}
		});
		frame.getContentPane().add(btn_submit);
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(298, 369, 112, 29);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eFact(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}