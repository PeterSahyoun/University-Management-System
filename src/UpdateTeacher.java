import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UpdateTeacher extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JLabel img;
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JLabel age;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t7;
	private JTextField t5;
	private JTextField t1;
	private JTextField t6;
	private JButton b1;
	private JButton b2;
	private JComboBox c1;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateTeacher frame = new UpdateTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateTeacher() {
		setTitle("Update Student");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon6.png"));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		 title = new JLabel("Update Teacher Details");
		title.setBounds(163, 11, 341, 35);
		title.setFont(new Font("serif",Font.ITALIC,30));
	        title.setForeground(Color.BLUE);
		contentPane.add(title);
		
		 l1 = new JLabel("Enter Teacher ID :");
		l1.setBounds(10, 76, 196, 14);
		l1.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(l1);
		
		 l2 = new JLabel("First Name");
		l2.setBounds(10, 141, 61, 14);
		contentPane.add(l2);
		
		 l3 = new JLabel("Last Name");
		l3.setBounds(10, 192, 61, 14);
		contentPane.add(l3);
		
		l4 = new JLabel("Phone Number");
		l4.setBounds(301, 141, 86, 14);
		contentPane.add(l4);
		
		 l5 = new JLabel("Address");
		l5.setBounds(301, 244, 86, 14);
		contentPane.add(l5);
		
		 l6 = new JLabel("Department");
		l6.setBounds(10, 326, 124, 14);
		l6.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(l6);
		
		 l7 = new JLabel("DOB(dd/mm/yyyy)");
		l7.setBounds(301, 192, 107, 14);
		contentPane.add(l7);
		
		t2 = new JTextField();
		t2.setBounds(81, 138, 147, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(81, 189, 147, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		
		String []majors= {"Software Engineering","Telecommunication Engineering","Mechanical Engineering","Electrical Engineering","Computer Science","Networking"};
		c1 = new JComboBox(majors);
		c1.setBounds(144, 324, 219, 22);
		contentPane.add(c1);
		
		t4 = new JTextField();
		t4.setBounds(420, 138, 147, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t7 = new JTextField();
		t7.setBounds(420, 189, 147, 20);
		contentPane.add(t7);
		t7.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(420, 241, 147, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		t1 = new JTextField();
		t1.setBounds(207, 75, 86, 20);
		t1.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(t1);
		t1.setColumns(10);
		
		 age = new JLabel("Age");
		age.setBounds(10, 244, 46, 14);
		contentPane.add(age);
		
		t6 = new JTextField();
		t6.setBounds(81, 241, 147, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		   btnNewButton = new JButton("Details");
	        btnNewButton.setBounds(356, 74, 89, 23);
	        btnNewButton.setBackground(Color.ORANGE);
	        btnNewButton.setForeground(Color.WHITE);
	        contentPane.add(btnNewButton);
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
		
					try {
						Connection connection= null;
						Class.forName("oracle.jdbc.driver.OracleDriver");
							connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
						
							Double t=Double.parseDouble(t1.getText());
							
							PreparedStatement psgetstudent = connection.prepareStatement("select first_name,last_name,age,phone_number,dob,address,department from TEACHER where teacherid='"+t+"' ");
							  ResultSet rs=psgetstudent.executeQuery();

							  if(rs.next()){

				                    t2.setText(rs.getString(1));
				                    t3.setText(rs.getString(2));
				                    t4.setText(rs.getString(4));
									t5.setText(rs.getString(6));
									t6.setText(rs.getString(3));
									t7.setText(rs.getString(5));
									c1.setSelectedItem(rs.getString(7));
							  }
							  
							  else 
							  {   JOptionPane.showMessageDialog(null, "Not Found!");
								t1.setText("");
							  }
								
							
								
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				
			}
			});
	 	        
	        
	        
			
			 b1 = new JButton("Update");
			b1.setBounds(121, 432, 107, 35);
			  b1.setFont(new Font("serif",Font.BOLD,20));
		        b1.setBackground(Color.ORANGE);
		        b1.setForeground(Color.WHITE);
		        contentPane.add(b1);
		        b1.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
			
						try {
							Connection connection= null;
							Class.forName("oracle.jdbc.driver.OracleDriver");
								connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
							
								Double t=Double.parseDouble(t1.getText());
								String c;
								c=c1.getSelectedItem().toString();
								
								PreparedStatement psgetstudent = connection.prepareStatement("update teacher set first_name='"+t2.getText()+"',last_name='"+t3.getText()+"',age='"+t6.getText()+"', phone_number='"+t4.getText()+"',dob='"+t7.getText()+"',address='"+t5.getText()+"',department='"+c+"' where teacherid='"+t+"' ");
								psgetstudent.executeUpdate();

								 JOptionPane.showMessageDialog(null,"Data Updated");
									t1.setText("");
									t2.setText("");
									t3.setText("");
									t4.setText("");
									t5.setText("");
									t6.setText("");
									t7.setText("");
									c1.setSelectedIndex(0);
									
								
									
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
					
				}
				});
		        
		        
			
			 b2 = new JButton("Reset");
			b2.setBounds(359, 432, 107, 35);
			  b2.setFont(new Font("serif",Font.BOLD,20));
		        b2.setBackground(Color.ORANGE);
		        b2.setForeground(Color.WHITE);
		        contentPane.add(b2);
		        b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t7.setText("");
						c1.setSelectedIndex(0);
					}
				});
		
	}

	private boolean validateFields() {
		
		if(t1.getText().isEmpty() || t2.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() || t5.getText().isEmpty() || t7.getText().isEmpty()  ) {
			JOptionPane.showMessageDialog(null, "You have to fill all the fields!");
			return false;
		}
			return true;
	
	}


	


}

