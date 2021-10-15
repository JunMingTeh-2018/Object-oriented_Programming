import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class eFact {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title, lbl_select_option;
	private JComboBox<String> cmb_select_option;
	private JButton btn_enter, btn_back;
	
	public eFact(student currentStudent) {
		this.currentStudent = currentStudent;
		initialize();
	}

	public void eFact_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eFact");
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("eFact");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 47, 676, 32);
		frame.getContentPane().add(lbl_title);
		
		lbl_select_option = new JLabel("Please Select an Option");
		lbl_select_option.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_select_option.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_select_option.setBounds(61, 164, 223, 36);
		frame.getContentPane().add(lbl_select_option);
		
		cmb_select_option = new JComboBox<String>();
		cmb_select_option.setBounds(310, 167, 315, 36);
		cmb_select_option.addItem("Click Here");
		cmb_select_option.addItem("Report Loss of Room Key");
		cmb_select_option.addItem("Report Damage of Room Facilities");
		frame.getContentPane().add(cmb_select_option);
		
		btn_enter = new JButton("ENTER");
		btn_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected_Option = cmb_select_option.getSelectedItem().toString();
				if (selected_Option == "Report Loss of Room Key") {
					controller.eFact_LossKey(currentStudent);
					frame.dispose();
				} else if (selected_Option == "Report Damage of Room Facilities") {
					controller.eFact_DamageFacility(currentStudent);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Please select an issue to report !");
				}
			}
		});
		btn_enter.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_enter.setBounds(230, 276, 216, 36);
		frame.getContentPane().add(btn_enter);
		
		btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.mainMenu(currentStudent);
				frame.dispose();
			}
		});
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(289, 329, 112, 36);
		frame.getContentPane().add(btn_back);
	}
}