import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class staff_eKewangan_Status {
	private controller controller;
	private String matric_Number;
	private JFrame frame;
	private JLabel lbl_title;
	private JPanel panel;
	private JButton btn_fees_2018, btn_fees_2019, btn_uniform_fees, btn_back;
	private JCheckBox ckb_fees_2018, chk_fees_2019, chk_uniform_fees;
	private MouseListener[] a, b, c, d, e, f;

	public staff_eKewangan_Status(String matric_Number) {
		this.matric_Number = matric_Number;
		initialize();
	}
	
	public void staff_eKewangan_Status_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("eKewangan Payment Status for Staff");
		frame.setResizable(false);
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(180, 180));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Matric Number  :  " + matric_Number);
		lbl_title.setBounds(10, 31, 476, 31);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		frame.getContentPane().add(lbl_title);
		
		panel = new JPanel();
		panel.setBounds(32, 84, 433, 312);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btn_fees_2018 = new JButton("<html>Student Fees for Semester 2018/2019<br>Total : RM 400.00<br>Due Date : 19/11/2018</span></html>");
		btn_fees_2018.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_fees_2018.setBackground(new Color(176, 196, 222));
		btn_fees_2018.setHorizontalAlignment(SwingConstants.LEFT);
		btn_fees_2018.setBounds(20, 20, 316, 76);
		panel.add(btn_fees_2018);
		
		ckb_fees_2018 = new JCheckBox("");
		ckb_fees_2018.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_fees_2018.setBounds(366, 50, 31, 21);
		panel.add(ckb_fees_2018);
		
		btn_fees_2019 = new JButton("<html>Student Fees for Semester 2019/2020<br>Total : RM 400.00<br>Due Date : 18/12/2019</span></html>");
		btn_fees_2019.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_fees_2019.setBackground(new Color(176, 196, 222));
		btn_fees_2019.setHorizontalAlignment(SwingConstants.LEFT);
		btn_fees_2019.setBounds(20, 116, 316, 76);
		panel.add(btn_fees_2019);
		
		chk_fees_2019 = new JCheckBox("");
		chk_fees_2019.setHorizontalAlignment(SwingConstants.CENTER);
		chk_fees_2019.setBounds(366, 141, 31, 21);
		panel.add(chk_fees_2019);
		
		btn_uniform_fees = new JButton("<html>Uniform Fees<br>Total : RM 70.00<br>Due Date : 19/11/2019</span></html>");
		btn_uniform_fees.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_uniform_fees.setBackground(new Color(176, 196, 222));
		btn_uniform_fees.setHorizontalAlignment(SwingConstants.LEFT);
		btn_uniform_fees.setBounds(20, 214, 316, 76);
		panel.add(btn_uniform_fees);
		
		chk_uniform_fees = new JCheckBox("");
		chk_uniform_fees.setHorizontalAlignment(SwingConstants.CENTER);
		chk_uniform_fees.setBounds(366, 240, 31, 21);
		panel.add(chk_uniform_fees);

		try {
    		File file = new File("students_payment_status.txt");
    	    Scanner scanner = new Scanner(file);
    	    while (scanner.hasNextLine()) {
    	        String matricNumberInFile = scanner.nextLine();
    	        if(matric_Number.contentEquals(matricNumberInFile)) {
    	            String fees_2018 = scanner.nextLine();
    	            String fees_2019 = scanner.nextLine();
    	            String uniform_fees = scanner.nextLine();
    	            if(fees_2018.contentEquals("1")){
    	            	ckb_fees_2018.setSelected(true);
    	            } 
    	            if(fees_2019.contentEquals("a")){
    	            	chk_fees_2019.setSelected(true);
    	            }
    	            if(uniform_fees.contentEquals("!")){
    	            	chk_uniform_fees.setSelected(true);
    	            }
    	            scanner.close();
    	            break;
    	        }
    	    }
    	} catch (Exception e) { 
    		e.printStackTrace();
    	}
		
		a = (MouseListener[])btn_fees_2018.getListeners(MouseListener.class);
		b = (MouseListener[])ckb_fees_2018.getListeners(MouseListener.class);
		c = (MouseListener[])btn_fees_2019.getListeners(MouseListener.class);
		d = (MouseListener[])chk_fees_2019.getListeners(MouseListener.class);
		e = (MouseListener[])btn_uniform_fees.getListeners(MouseListener.class);
		f = (MouseListener[])chk_uniform_fees.getListeners(MouseListener.class);
		for (int i = 0; i < a.length; i++) {
		    btn_fees_2018.removeMouseListener(a[i]);
			ckb_fees_2018.removeMouseListener(b[i]);
		    btn_fees_2019.removeMouseListener(c[i]);
		    chk_fees_2019.removeMouseListener(d[i]);
		    btn_uniform_fees.removeMouseListener(e[i]);
			chk_uniform_fees.removeMouseListener(f[i]);
		}
    	
    	btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(189, 419, 128, 31);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        controller.staff_eKewangan();
		        frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}