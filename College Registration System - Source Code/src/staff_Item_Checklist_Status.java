import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class staff_Item_Checklist_Status {
	private controller controller;
	private String matricNumber;
	private JFrame frame;
	private JLabel lbl_title;
	private JPanel panel;
	private JButton btn_tshirt, btn_room_key, btn_lanyard, btn_back;
	private JCheckBox chk_tshirt, chk_room_key, chk_lanyard;
	private MouseListener[] a, b, c, d, e ,f;

	public staff_Item_Checklist_Status(String matricNumber) {
		this.matricNumber = matricNumber;
		initialize();
	}

	public void staff_Item_Checklist_Status_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("College Item Checklist for Staff");
		frame.setResizable(false);
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(180, 180));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("Matric Number  :  " + matricNumber);
		lbl_title.setBounds(10, 30, 476, 31);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		frame.getContentPane().add(lbl_title);
		
		panel = new JPanel();
		panel.setBounds(28, 78, 440, 318);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		btn_tshirt = new JButton("College T-Shirt");
		btn_tshirt.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_tshirt.setBackground(new Color(176, 196, 222));
		btn_tshirt.setHorizontalAlignment(SwingConstants.LEFT);
		btn_tshirt.setBounds(20, 23, 316, 76);
		panel.add(btn_tshirt);
		
		chk_tshirt = new JCheckBox("");
		chk_tshirt.setHorizontalAlignment(SwingConstants.CENTER);
		chk_tshirt.setBounds(367, 53, 31, 21);
		panel.add(chk_tshirt);
		
		btn_room_key = new JButton("College Room Key");
		btn_room_key.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_room_key.setBackground(new Color(176, 196, 222));
		btn_room_key.setHorizontalAlignment(SwingConstants.LEFT);
		btn_room_key.setBounds(20, 119, 316, 76);
		panel.add(btn_room_key);
		
		chk_room_key = new JCheckBox("");
		chk_room_key.setHorizontalAlignment(SwingConstants.CENTER);
		chk_room_key.setBounds(367, 149, 31, 21);
		panel.add(chk_room_key);
		
		btn_lanyard = new JButton("College Lanyard");
		btn_lanyard.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btn_lanyard.setBackground(new Color(176, 196, 222));
		btn_lanyard.setHorizontalAlignment(SwingConstants.LEFT);
		btn_lanyard.setBounds(20, 217, 316, 76);
		panel.add(btn_lanyard);
		
		chk_lanyard = new JCheckBox("");
		chk_lanyard.setHorizontalAlignment(SwingConstants.CENTER);
		chk_lanyard.setBounds(367, 247, 31, 21);
		panel.add(chk_lanyard);
		
		try {
    		File file = new File("students_item_checklist.txt");
    	    Scanner scanner = new Scanner(file);
    	    while (scanner.hasNextLine()) {
    	        String matricNumberInFile = scanner.nextLine();
    	        if(matricNumber.contentEquals(matricNumberInFile)) {
    	            String tshirt = scanner.nextLine();
    	            String roomkey = scanner.nextLine();
    	            String lanyard = scanner.nextLine();
    	            if(tshirt.contentEquals("1")){
    	            	chk_tshirt.setSelected(true);
    	            } 
    	            if(roomkey.contentEquals("a")){
    	            	chk_room_key.setSelected(true);
    	            }
    	            if(lanyard.contentEquals("!")){
    	            	chk_lanyard.setSelected(true);
    	            }
    	            scanner.close();
    	            break;
    	        }
    	    }
    	} catch (Exception e) { 
    		e.printStackTrace();
    	}

		a = (MouseListener[])btn_tshirt.getListeners(MouseListener.class);
		b = (MouseListener[])chk_tshirt.getListeners(MouseListener.class);
		c = (MouseListener[])btn_room_key.getListeners(MouseListener.class);
		d = (MouseListener[])chk_room_key.getListeners(MouseListener.class);
		e = (MouseListener[])btn_lanyard.getListeners(MouseListener.class);
		f = (MouseListener[])chk_lanyard.getListeners(MouseListener.class);
		for (int i = 0; i < a.length; i++) {
		    btn_tshirt.removeMouseListener(a[i]);
			chk_tshirt.removeMouseListener(b[i]);
		    btn_room_key.removeMouseListener(c[i]);
		    chk_room_key.removeMouseListener(d[i]);
		    btn_lanyard.removeMouseListener(e[i]);
			chk_lanyard.removeMouseListener(f[i]);
		}
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(184, 417, 118, 31);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        controller.staff_Item_Checklist();
		        frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);	
	}
}