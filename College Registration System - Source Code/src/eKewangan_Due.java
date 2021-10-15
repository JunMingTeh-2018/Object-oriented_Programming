import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class eKewangan_Due {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title, lbl_total, lbl_uniform;
	private JPanel panel;
	private JButton btn_make_payment, btn_back;
	
	public eKewangan_Due(student student) {
		currentStudent = student;
		initialize();	
	}

	public void eKewangan_Due_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eKewangan Due Payment Details");
		frame.setResizable(false);
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(180, 180));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Uniform Fees");
		lbl_title.setBounds(10, 30, 476, 31);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
		frame.getContentPane().add(lbl_title);
		
		lbl_total = new JLabel("Total  :  RM 70.00");
		lbl_total.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_total.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lbl_total.setBounds(10, 71, 476, 31);
		frame.getContentPane().add(lbl_total);
		
		panel = new JPanel();
		panel.setBounds(38, 112, 421, 235);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		lbl_uniform = new JLabel("<html>&nbsp;Uniform Fees<br>&nbsp;Total  :  RM 70.00</span></html>");
		lbl_uniform.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lbl_uniform.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lbl_uniform.setForeground(Color.BLACK);
		lbl_uniform.setBackground(new Color(204, 255, 153));
		lbl_uniform.setOpaque(true);
		lbl_uniform.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_uniform.setBounds(31, 22, 352, 43);
		panel.add(lbl_uniform);
		
		btn_make_payment = new JButton("MAKE PAYMENT");
		btn_make_payment.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_make_payment.setBounds(125, 364, 236, 37);
		btn_make_payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eKewangan_MakePayment(currentStudent,"Due");
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_make_payment);
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(198, 411, 102, 31);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.eKewangan(currentStudent);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}