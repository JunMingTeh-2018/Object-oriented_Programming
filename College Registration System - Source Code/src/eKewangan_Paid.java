import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class eKewangan_Paid {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title, lbl_total, lbl_facility, lbl_ict_utility_service, lbl_managemant, lbl_library;
	private JPanel panel;
	private JButton btn_back;
	
	public eKewangan_Paid(student student) {
		currentStudent = student;
		initialize();	
	}

	public void eKewangan_Paid_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eKewangan Paid Payment Details");
		frame.setResizable(false);
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(180, 180));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Student Fees for Semester 2018/2019");
		lbl_title.setBounds(10, 25, 476, 31);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
		frame.getContentPane().add(lbl_title);
		
		lbl_total = new JLabel("Total  :  RM 400.00");
		lbl_total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_total.setBounds(10, 73, 476, 31);
		frame.getContentPane().add(lbl_total);
		
		panel = new JPanel();
		panel.setBounds(40, 127, 422, 252);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		lbl_facility = new JLabel("<html>&nbsp;Facility Fees<br>&nbsp;Total  :  RM 60.00</span></html>");
		lbl_facility.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbl_facility.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl_facility.setForeground(Color.BLACK);
		lbl_facility.setBackground(new Color(204, 255, 153));
		lbl_facility.setOpaque(true);
		lbl_facility.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_facility.setBounds(31, 26, 363, 43);
		panel.add(lbl_facility);
		
		lbl_ict_utility_service = new JLabel("<html>&nbsp;ICT & Utility Service Fees<br>&nbsp;Total  :  RM 80.00</span></html>");
		lbl_ict_utility_service.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbl_ict_utility_service.setOpaque(true);
		lbl_ict_utility_service.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ict_utility_service.setForeground(Color.BLACK);
		lbl_ict_utility_service.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl_ict_utility_service.setBackground(new Color(204, 255, 153));
		lbl_ict_utility_service.setBounds(31, 79, 363, 43);
		panel.add(lbl_ict_utility_service);
		
		lbl_managemant = new JLabel("<html>&nbsp;Management Fees<br>&nbsp;Total  :  RM 100.00</span></html>");
		lbl_managemant.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbl_managemant.setOpaque(true);
		lbl_managemant.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_managemant.setForeground(Color.BLACK);
		lbl_managemant.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl_managemant.setBackground(new Color(204, 255, 153));
		lbl_managemant.setBounds(31, 132, 363, 43);
		panel.add(lbl_managemant);
		
		lbl_library = new JLabel("<html>&nbsp;Library Fees<br>&nbsp;Total  :  RM 60.00</span></html>");
		lbl_library.setOpaque(true);
		lbl_library.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_library.setForeground(Color.BLACK);
		lbl_library.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbl_library.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl_library.setBackground(new Color(204, 255, 153));
		lbl_library.setBounds(31, 185, 363, 43);
		panel.add(lbl_library);
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(197, 409, 110, 31);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eKewangan(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}