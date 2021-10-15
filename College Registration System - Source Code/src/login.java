import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class login {
	private controller controller;
	private JFrame frame;
	private JLabel lbl_title, lbl_account_id, lbl_password;
	private JTextField txt_account_id;
	private JPasswordField txt_password;
	private JButton btn_login;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		initialize();
	}
	
	public void login_setVisible() {
		frame.setVisible(true);
	}

	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("College Registration System");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("COLLEGE REGISTRATION SYSTEM");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 39, 666, 56);
		frame.getContentPane().add(lbl_title);
		
		lbl_account_id = new JLabel("ACCOUNT ID");
		lbl_account_id.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_account_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_account_id.setBounds(54, 143, 182, 46);
		frame.getContentPane().add(lbl_account_id);
		
		txt_account_id = new JTextField();
		txt_account_id.setBounds(298, 154, 316, 25);
		txt_account_id.setColumns(10);
		frame.getContentPane().add(txt_account_id);
		
		lbl_password = new JLabel("PASSWORD");
		lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_password.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_password.setBounds(54, 226, 182, 46);
		frame.getContentPane().add(lbl_password);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(298, 237, 316, 25);
		frame.getContentPane().add(txt_password);
		
		btn_login = new JButton("LOGIN");
		btn_login.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_login.setBounds(275, 330, 145, 38);
		btn_login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String typed_Account_Id = txt_account_id.getText();
				String typed_Password = txt_password.getText();
				if(controller.checkStudent(typed_Account_Id, typed_Password) == true) {
					student currentStudent = controller.getCurrentStudent(typed_Account_Id, typed_Password);
					JOptionPane.showMessageDialog(null, "Successfully Login the System");
					controller.mainMenu(currentStudent);
					frame.dispose();
				} else if (controller.checkStaff(typed_Account_Id, typed_Password) == true) {
					JOptionPane.showMessageDialog(null, "Successfully Login the System");
					controller.staff_MainMenu();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Error : Invalid Matric Number / Staff Number or Password");
				}
			}
		});
		frame.getContentPane().add(btn_login);
	}
}