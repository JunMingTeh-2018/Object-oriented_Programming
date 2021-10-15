import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class eKewangan_MakePayment {
	private controller controller;
	private student currentStudent;
	private String type;
	private JFrame frame;
	private JLabel lbl_title, lbl_name, lbl_card_number, lbl_date, lbl_dash, lbl_cvv, lbl_statement;
	private JPanel panel;
	private JTextField txt_name, txt_card_number, txt_month, txt_year;
	private JPasswordField pwf_cvv;
	private JButton btn_make_payment, btn_back;

	public eKewangan_MakePayment(student student, String type) {
		currentStudent = student;
		this.type = type;
		initialize();
	}

	public void eKewanagn_MakePayment_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eKewangan MakePayment");
		frame.setResizable(false);
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(180, 180));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Payment Info");
		lbl_title.setBounds(10, 28, 476, 31);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		frame.getContentPane().add(lbl_title);
		
		panel = new JPanel();
		panel.setBounds(32, 77, 433, 268);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		lbl_name = new JLabel("Card Holder Name");
		lbl_name.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_name.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lbl_name.setBounds(35, 34, 136, 13);
		panel.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setHorizontalAlignment(SwingConstants.LEFT);
		txt_name.setBounds(185, 31, 211, 19);
		txt_name.setColumns(10);
		panel.add(txt_name);
		
		lbl_card_number = new JLabel("Card Number");
		lbl_card_number.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_card_number.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lbl_card_number.setBounds(35, 76, 136, 13);
		panel.add(lbl_card_number);
		
		txt_card_number = new JTextField();
		txt_card_number.setHorizontalAlignment(SwingConstants.LEFT);
		txt_card_number.setColumns(10);
		txt_card_number.setBounds(185, 72, 211, 19);
		panel.add(txt_card_number);
		
		lbl_date = new JLabel("Expiration Date");
		lbl_date.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_date.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lbl_date.setBounds(35, 119, 136, 13);
		panel.add(lbl_date);
		
		txt_month = new JTextField(5);
		txt_month.setHorizontalAlignment(SwingConstants.CENTER);
		txt_month.setText("MM");
		txt_month.setColumns(10);
		txt_month.setBounds(186, 116, 38, 19);
		panel.add(txt_month);
		
		lbl_dash = new JLabel("/");
		lbl_dash.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_dash.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lbl_dash.setBounds(233, 121, 12, 13);
		panel.add(lbl_dash);
		
		txt_year = new JTextField(10);
		txt_year.setHorizontalAlignment(SwingConstants.CENTER);
		txt_year.setText("YY");
		txt_year.setBounds(251, 117, 38, 19);
		panel.add(txt_year);
		
		lbl_cvv = new JLabel("CVV");
		lbl_cvv.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_cvv.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lbl_cvv.setBounds(35, 161, 136, 13);
		panel.add(lbl_cvv);
		
		pwf_cvv = new JPasswordField();
		pwf_cvv.setHorizontalAlignment(SwingConstants.LEFT);
		pwf_cvv.setBounds(186, 156, 104, 19);
		panel.add(pwf_cvv);
		
		lbl_statement = new JLabel("By clicking the the button you confirm to have accepted our Terms of Service");
		lbl_statement.setBounds(0, 214, 426, 13);
		lbl_statement.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_statement.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		panel.add(lbl_statement);
		
		btn_make_payment = new JButton("MAKE PAYMENT");
		btn_make_payment.setBounds(132, 362, 230, 39);
		btn_make_payment.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_make_payment.addActionListener(new ActionListener() {
			  @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				 String a = txt_card_number.getText().trim();
			     String b = txt_month.getText().trim();
			     String c = pwf_cvv.getText().trim();
			     String d = txt_year.getText().trim();      
			     if((a.length() == 0 || b.length() == 0) || (c.length() == 0 || d.length() == 0)) {
			    	 JOptionPane.showMessageDialog(null,"INFORMATION MISSING","ERROR",JOptionPane.WARNING_MESSAGE);
			     } else {
			    	 if(!a.matches(".*\\d.*") || a.length()!= 16) { 
			    		 JOptionPane.showMessageDialog(null,"INVALID INPUT ON CARD NUMBER","ERROR",JOptionPane.WARNING_MESSAGE);
			    	 } else {
			    		 if((b.matches(".*[a-zA-Z]+.*") || d.matches(".*[a-zA-Z]+.*")) || (b.length() > 2 || d.length() >2 )) { 
			    			 JOptionPane.showMessageDialog(null,"INVALID INPUT ON EXPIRATION DATE","ERROR",JOptionPane.WARNING_MESSAGE);				    	            			    	            
				    	 } else {
				    		 if(!c.matches(".*\\d.*")) {
				    			 JOptionPane.showMessageDialog(null,"INVALID INPUT ON CVV","ERROR",JOptionPane.WARNING_MESSAGE);				    	            			    	            
					    	 } else {
					    		 JOptionPane.showMessageDialog (null, "Payment successfull", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					    		 controller.eKewangan(currentStudent);
					    		 frame.dispose();
			    	         }
			    	     }
			    	 }
			     }	    
			  }
		});
		frame.getContentPane().add(btn_make_payment);
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(193, 411, 105, 31);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type.equals("Unpaid")) {
					controller.eKewangan_Unpaid(currentStudent);
			        frame.dispose();
			    } else if(type.equals("Due")) {
					controller.eKewangan_Due(currentStudent);
					frame.dispose();
				}
			}
		});
		frame.getContentPane().add(btn_back);
	}
}