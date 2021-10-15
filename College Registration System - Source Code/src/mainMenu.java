import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mainMenu {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_main_menu;
	private JButton btn_checkin_checkout, btn_ekewangan, btn_item_checklist, btn_efact, btn_log_out;

	public mainMenu(student currentStudent) {
		this.currentStudent = currentStudent;
		initialize();
	}
	public void mainMenu_setVisible() {
		frame.setVisible(true);
	}

	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Main Menu");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_main_menu = new JLabel("MAIN MENU");
		lbl_main_menu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_main_menu.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_main_menu.setBounds(10, 32, 676, 52);
		frame.getContentPane().add(lbl_main_menu);
		
		btn_checkin_checkout = new JButton("CHECK IN & CHECK OUT");
		btn_checkin_checkout.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_checkin_checkout.setBounds(177, 109, 346, 41);
		btn_checkin_checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.checkIn_CheckOut(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_checkin_checkout);
		
		btn_ekewangan = new JButton("eKEWANGAN");
		btn_ekewangan.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_ekewangan.setBounds(177, 160, 346, 41);
		btn_ekewangan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eKewangan(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_ekewangan);
		
		btn_item_checklist = new JButton("COLLEGE ITEM CHECKLIST");
		btn_item_checklist.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_item_checklist.setBounds(177, 211, 346, 41);
		btn_item_checklist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.item_Checklist(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_item_checklist);
		
		btn_efact = new JButton("eFACT");
		btn_efact.setBounds(177, 263, 346, 41);
		btn_efact.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_efact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eFact(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_efact);
		
		btn_log_out = new JButton("LOG OUT ");
		btn_log_out.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_log_out.setBounds(177, 346, 346, 29);
		btn_log_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"Do you want to log out ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Successfully Log Out");
					controller.login();
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btn_log_out);
	}
}