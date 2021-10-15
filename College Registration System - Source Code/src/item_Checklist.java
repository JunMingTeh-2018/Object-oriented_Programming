import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class item_Checklist {
	private controller controller;
	private student currentStudent;
	private JFrame frame;
	private JLabel lbl_title;
	private JPanel panel;
	private JButton btn_tshirt, btn_room_key, btn_lanyard, btn_back;
	private JCheckBox ckb_tshirt, ckb_room_key, ckb_lanyard;
	private MouseListener[] a, b, c;

	public item_Checklist(student currentStudent) {
		this.currentStudent = currentStudent;
		initialize();
	}

	public void item_Cghecklist_setVisible() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		controller = new controller();
		
		frame = new JFrame();
		frame.setTitle("College Item Checklist");
		frame.setResizable(false);
		frame.getContentPane().setSize(new Dimension(80, 80));
		frame.setSize(new Dimension(180, 180));
		frame.setPreferredSize(new Dimension(80, 80));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_title = new JLabel("College Item Checklist");
		lbl_title.setBounds(10, 24, 476, 31);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 28));
		frame.getContentPane().add(lbl_title);
		
		panel = new JPanel();
		panel.setBounds(37, 78, 420, 320);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btn_tshirt = new JButton("College T-Shirt");
		btn_tshirt.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_tshirt.setBackground(new Color(176, 196, 222));
		btn_tshirt.setHorizontalAlignment(SwingConstants.LEFT);
		btn_tshirt.setBounds(20, 23, 305, 76);
		panel.add(btn_tshirt);
		
		ckb_tshirt = new JCheckBox("");
		ckb_tshirt.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_tshirt.setBounds(354, 53, 31, 21);
		panel.add(ckb_tshirt);
		
		btn_room_key = new JButton("College Room Key");
		btn_room_key.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_room_key.setBackground(new Color(176, 196, 222));
		btn_room_key.setHorizontalAlignment(SwingConstants.LEFT);
		btn_room_key.setBounds(20, 121, 305, 76);
		panel.add(btn_room_key);
		
		ckb_room_key = new JCheckBox("");
		ckb_room_key.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_room_key.setBounds(354, 149, 31, 21);
		panel.add(ckb_room_key);
		
		btn_lanyard = new JButton("College Lanyard");
		btn_lanyard.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_lanyard.setBackground(new Color(176, 196, 222));
		btn_lanyard.setHorizontalAlignment(SwingConstants.LEFT);
		btn_lanyard.setBounds(20, 219, 305, 76);
		panel.add(btn_lanyard);
		
		ckb_lanyard = new JCheckBox("");
		ckb_lanyard.setHorizontalAlignment(SwingConstants.CENTER);
		ckb_lanyard.setBounds(354, 248, 31, 21);
		panel.add(ckb_lanyard);
		
		a = (MouseListener[])btn_tshirt.getListeners(MouseListener.class);
		b = (MouseListener[])btn_room_key.getListeners(MouseListener.class);
		c = (MouseListener[])btn_lanyard.getListeners(MouseListener.class);
		for (int i = 0; i < a.length; i++) {
		    btn_tshirt.removeMouseListener(a[i]);
		    btn_room_key.removeMouseListener(b[i]);
		    btn_lanyard.removeMouseListener(c[i]);
		}
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		btn_back.setBounds(196, 418, 103, 29);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        controller.mainMenu(currentStudent);
		        frame.dispose();
			}
		});
		frame.getContentPane().add(btn_back);
	}
}