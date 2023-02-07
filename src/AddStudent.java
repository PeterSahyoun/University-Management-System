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
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddStudent extends JFrame{

	private JPanel contentPane;
	private JLabel title;
	private JLabel img;
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
	private JTextField t6;
	private JButton b1;
	private JButton b2;
	private JComboBox c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setTitle("Add Student");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon.png"));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		 title = new JLabel("Student");
		title.setBounds(240, 11, 147, 35);
		title.setFont(new Font("serif",Font.ITALIC,30));
	        title.setForeground(Color.BLUE);
		contentPane.add(title);
		
		 l2 = new JLabel("First Name");
		l2.setBounds(10, 129, 61, 14);
		contentPane.add(l2);
		
		 l3 = new JLabel("Last Name");
		l3.setBounds(10, 186, 61, 14);
		contentPane.add(l3);
		
		l4 = new JLabel("Phone Number");
		l4.setBounds(301, 129, 86, 14);
		contentPane.add(l4);
		
		 l5 = new JLabel("Address");
		l5.setBounds(301, 244, 86, 14);
		contentPane.add(l5);
		
		 l6 = new JLabel("Branch");
		l6.setBounds(10, 326, 80, 14);
		l6.setFont(new Font("Arial",Font.BOLD,18));
		contentPane.add(l6);
		
		 l7 = new JLabel("DOB(dd/mm/yyyy)");
		l7.setBounds(301, 186, 107, 14);
		contentPane.add(l7);
		
		t2 = new JTextField();
		t2.setBounds(81, 126, 147, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(81, 183, 147, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		
		String []majors= {"Software Engineering","Telecommunication Engineering","Mechanical Engineering","Electrical Engineering","Computer Science","Networking"};
		c1 = new JComboBox(majors);
		c1.setBounds(100, 324, 219, 22);
		contentPane.add(c1);
		
		t4 = new JTextField();
		t4.setBounds(420, 126, 147, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		t7 = new JTextField();
		t7.setBounds(420, 183, 147, 20);
		contentPane.add(t7);
		t7.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(420, 241, 147, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		 age = new JLabel("Age");
		age.setBounds(10, 244, 46, 14);
		contentPane.add(age);
		
		t6 = new JTextField();
		t6.setBounds(81, 241, 147, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		
		 b1 = new JButton("Submit");
		b1.setBounds(121, 432, 107, 35);
		  b1.setFont(new Font("serif",Font.BOLD,20));
	        b1.setBackground(Color.BLUE);
	        b1.setForeground(Color.WHITE);
	        contentPane.add(b1);
	        b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(validateFields()) {
					try {
						Connection connection= null;
						Class.forName("oracle.jdbc.driver.OracleDriver");
							connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
							 PreparedStatement psInsertStudent = connection.prepareStatement("insert into student (FIRST_NAME,LAST_NAME,AGE,PHONE_NUMBER,DOB,ADDRESS,BRANCH) values(?,?,?,?,?,?,?)");
							Double t=Double.parseDouble(t6.getText());
							    
								psInsertStudent.setString(1, t2.getText());
								psInsertStudent.setString(2, t3.getText());
								psInsertStudent.setDouble(3, t);
								psInsertStudent.setString(4, t4.getText());
								psInsertStudent.setString(5, t7.getText());
								psInsertStudent.setString(6, t5.getText());
								
								String c;
								c=c1.getSelectedItem().toString();
								psInsertStudent.setString(7, c);
								
								JOptionPane.showMessageDialog(null,"Data Inserted");
								psInsertStudent.executeUpdate();
								
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
			}
			});
		
		 b2 = new JButton("Reset");
		b2.setBounds(359, 432, 107, 35);
		  b2.setFont(new Font("serif",Font.BOLD,20));
	        b2.setBackground(Color.BLUE);
	        b2.setForeground(Color.WHITE);
	        contentPane.add(b2);
	        b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
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
		
		if( t2.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() || t5.getText().isEmpty() || t7.getText().isEmpty()  ) {
			JOptionPane.showMessageDialog(null, "You have to fill all the fields!");
			return false;
		}
			return true;
	
	}

			
				
					
					
				
				
		
		
	
		
	}
		
	
	

	

