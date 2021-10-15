import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class staff_eKewangan {
	private controller controller;
	private JFrame frame;
	private JLabel lbl_title, lbl_select_matric_number;
	private JComboBox<String> cmb_matric_number;
	private JButton btn_view, btn_back;

	public staff_eKewangan() {
		initialize();
	}

	public void staff_eKewangan_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("eKewangan for Staff");
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(450, 429));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("eKewangan");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		lbl_title.setBounds(10, 40, 676, 31);
		frame.getContentPane().add(lbl_title);
		
		lbl_select_matric_number = new JLabel("Please Select a Matric Number");
		lbl_select_matric_number.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_select_matric_number.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_select_matric_number.setBounds(45, 168, 266, 31);
		frame.getContentPane().add(lbl_select_matric_number);
		
		cmb_matric_number = new JComboBox<String>();
		cmb_matric_number.setMaximumRowCount(18);
		cmb_matric_number.setBounds(348, 168, 310, 31);
		cmb_matric_number.addItem("Click Here");
		for(int matricNumber = 176810; matricNumber <= 176830; matricNumber++) {
            cmb_matric_number.addItem("A" + matricNumber);
        }
		frame.getContentPane().add(cmb_matric_number);
		
		btn_view = new JButton("VIEW");
		btn_view.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_view.setBounds(244, 284, 205, 39);
		btn_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected_Matric_Number = cmb_matric_number.getSelectedItem().toString();
				if (selected_Matric_Number == "Click Here") {
					JOptionPane.showMessageDialog(null, "Please select a matric number !");
				} else {
					controller.staff_eKewangan_Status(selected_Matric_Number);
			        frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btn_view);
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(289, 350, 117, 31);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.staff_MainMenu();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}