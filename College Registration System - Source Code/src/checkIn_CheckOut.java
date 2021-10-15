import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class checkIn_CheckOut {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title, lbl_select_option;
	private JComboBox<String> cmb_select_option;
	private JButton btn_enter, btn_back;

	public checkIn_CheckOut(student currentStudent) {
		this.currentStudent = currentStudent;
		initialize();
	}
	
	public void checkIn_CheckOut_setVisible() {
		frame.setVisible(true);
	}

	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Check In and Check Out");
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Check In & Check Out");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 39, 676, 58);
		frame.getContentPane().add(lbl_title);
		
		lbl_select_option = new JLabel("Please Select an Option");
		lbl_select_option.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_select_option.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_select_option.setBounds(63, 173, 228, 36);
		frame.getContentPane().add(lbl_select_option);
		
		cmb_select_option = new JComboBox<String>();
		cmb_select_option.setMaximumRowCount(18);
		cmb_select_option.setBounds(311, 173, 316, 36);
		cmb_select_option.addItem("Click Here");
		cmb_select_option.addItem("Check In");
		cmb_select_option.addItem("Check Out");
		frame.getContentPane().add(cmb_select_option);
		
		btn_enter = new JButton("ENTER");
		btn_enter.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected_Option = cmb_select_option.getSelectedItem().toString();
				if (selected_Option == "Check In") {
					controller.checkIn(currentStudent);
					frame.dispose();
				} else if (selected_Option == "Check Out") {
					controller.checkOut(currentStudent);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Please select an Option !");
				}
			}
		});
		btn_enter.setBounds(233, 276, 228, 36);
		frame.getContentPane().add(btn_enter);
		
		btn_back = new JButton("BACK");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mainMenu(currentStudent);
				frame.dispose();
			}
		});
		btn_back.setBounds(290, 339, 115, 36);
		frame.getContentPane().add(btn_back);
	}	
}