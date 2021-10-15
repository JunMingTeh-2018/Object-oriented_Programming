import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class staff_CheckIn_CheckOut {
	private controller controller;
	private JFrame frame;
	private JLabel lbl_title, lbl_select_option;
	private JComboBox<String> cmb_select_option;
	private JButton btn_enter, btn_back;

	public staff_CheckIn_CheckOut() {
		initialize();
	}

	public void staff_CheckIn_CheckOut_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Check In and Check Out for Staff");
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(450, 429));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("View Students Registration Status");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 49, 676, 31);
		frame.getContentPane().add(lbl_title);
		
		lbl_select_option = new JLabel("Please Select an Option");
		lbl_select_option.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_select_option.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_select_option.setBounds(47, 165, 234, 31);
		frame.getContentPane().add(lbl_select_option);
		
		cmb_select_option = new JComboBox<String>();
		cmb_select_option.setMaximumRowCount(18);
		cmb_select_option.setBounds(300, 165, 333, 31);
		cmb_select_option.addItem("Click Here");
		cmb_select_option.addItem("Check In Record");
		cmb_select_option.addItem("Check Out Record");
		frame.getContentPane().add(cmb_select_option);
		
		btn_enter = new JButton("ENTER");
		btn_enter.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_enter.setBounds(220, 275, 242, 41);
		btn_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected_Option = cmb_select_option.getSelectedItem().toString();
				if (selected_Option == "Check In Record") {
					controller.staff_CheckIn();
					frame.dispose();
				} else if (selected_Option == "Check Out Record") {
					controller.staff_CheckOut();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Please select an option !");
				}
			}
		});
		frame.getContentPane().add(btn_enter);
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(281, 343, 113, 36);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.staff_MainMenu();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}	
}