import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class staff_MainMenu {
	private controller controller;
	private JFrame frame;
	private JLabel lbl_title; 
	private JButton btn_staff_checkin_checkout, btn_staff_eKewangan, btn_staff_item_checkist, btn_staff_efact, btn_logout;

	public staff_MainMenu() {
		initialize();
	}

	public void staff_MainMenu_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Main Menu for Staff");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("MAIN MENU");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 33, 676, 45);
		frame.getContentPane().add(lbl_title);
		
		btn_staff_checkin_checkout = new JButton("STUDENT REGISTRATION STATUS");
		btn_staff_checkin_checkout.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_staff_checkin_checkout.setBounds(162, 108, 369, 35);
		btn_staff_checkin_checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.staff_CheckIn_CheckOut();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_staff_checkin_checkout);
		
		btn_staff_eKewangan = new JButton("STUDENT PAYMENT STATUS");
		btn_staff_eKewangan.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_staff_eKewangan.setBounds(162, 163, 369, 35);
		btn_staff_eKewangan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.staff_eKewangan();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_staff_eKewangan);
		
		btn_staff_item_checkist = new JButton("STUDENT ITEM CHECKLIST");
		btn_staff_item_checkist.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_staff_item_checkist.setBounds(162, 218, 369, 35);
		btn_staff_item_checkist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.staff_Item_Checklist();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_staff_item_checkist);
		
		btn_staff_efact = new JButton("STUDENT REPORT");
		btn_staff_efact.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_staff_efact.setBounds(162, 273, 369, 35);
		btn_staff_efact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.staff_eFact();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_staff_efact);
		
		btn_logout = new JButton("LOG OUT ");
		btn_logout.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_logout.setBounds(224, 346, 257, 35);
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"Do you want to log out ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Successfully Log Out");
					controller.login();
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btn_logout);
	}
}