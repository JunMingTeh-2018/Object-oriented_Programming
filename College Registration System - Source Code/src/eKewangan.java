import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class eKewangan {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title;
	private JPanel panel;
	private JButton btn_paid, btn_unpaid, btn_due, btn_back;
	
	public eKewangan(student currentStudent) {
		this.currentStudent = currentStudent;
		initialize();
	}

	public void eKewangan_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eKewangan");
		frame.setResizable(false);
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(180, 180));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("eKewangan");
		lbl_title.setBounds(10, 31, 476, 31);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		frame.getContentPane().add(lbl_title);
		
		panel = new JPanel();
		panel.setBounds(39, 80, 415, 314);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		btn_paid = new JButton("<html>Student Fees for Semester 2018/2019<br>Total : RM 400.00<br>Due Date : 19/11/2018<br>Status : Paid</span></html>");
		btn_paid.setHorizontalAlignment(SwingConstants.LEADING);
		btn_paid.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_paid.setBackground(new Color(144, 238, 144));
		btn_paid.setBounds(31, 22, 357, 76);
		btn_paid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 controller.eKewangan_Paid(currentStudent);
			     frame.dispose();
			}
		});
		panel.add(btn_paid);
		
		btn_unpaid = new JButton("<html>Student Fees for Semester 2019/2020<br>Total : RM 400.00<br>Due Date : 18/12/2019<br>Status : Unpaid</span></html>");
		btn_unpaid.setHorizontalAlignment(SwingConstants.LEADING);
		btn_unpaid.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_unpaid.setBackground(new Color(245, 255, 250));
		btn_unpaid.setBounds(31, 118, 357, 76);
		btn_unpaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eKewangan_Unpaid(currentStudent);
				frame.dispose();
			}
		});
		panel.add(btn_unpaid);
		
		btn_due = new JButton("<html>Uniform Fees<br>Total : RM 70.00<br>Due Date : 19/11/2019<br>Status : Due</span></html>");
		btn_due.setHorizontalAlignment(SwingConstants.LEADING);
		btn_due.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_due.setBackground(new Color(255, 102, 102));
		btn_due.setBounds(31, 216, 357, 76);
		btn_due.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eKewangan_Due(currentStudent);
			    frame.dispose();
			}
		});
		panel.add(btn_due);
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(185, 412, 117, 31);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mainMenu(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}