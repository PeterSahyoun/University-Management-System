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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class StudentAttendance extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JButton b1;
	private JButton b2;
	private JLabel l1;
	private JTextField t1;
	private  ButtonGroup group;
	private  ButtonGroup group1;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAttendance frame = new StudentAttendance();
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
	public StudentAttendance() {
		setTitle("Student Attendance");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon14.jpg"));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		 title = new JLabel("Student Attendance");
			title.setBounds(109, 11, 261, 35);
			title.setFont(new Font("serif",Font.ITALIC,30));
		        title.setForeground(Color.BLUE);
			contentPane.add(title);
		
			        
			        l1 = new JLabel("ID");
					l1.setBounds(28, 100, 46, 14);
					l1.setFont(new Font("Arial",Font.BOLD,18));
					contentPane.add(l1);
					
					t1 = new JTextField();
					t1.setBounds(84, 99, 86, 20);
					t1.setHorizontalAlignment(JTextField.CENTER);
					contentPane.add(t1);
					t1.setColumns(10);
					
					JLabel l2 = new JLabel("First Session");
					l2.setBounds(6, 157, 74, 14);
					contentPane.add(l2);
					
					JLabel l3 = new JLabel("Second Session");
					l3.setBounds(266, 157, 102, 14);
					contentPane.add(l3);
					
					group = new ButtonGroup();
					
					JRadioButton r = new JRadioButton("Present");
					r.setBounds(28, 189, 109, 23);
					contentPane.add(r);
					
					JRadioButton r1 = new JRadioButton("Absent");
					r1.setBounds(28, 229, 109, 23);
					contentPane.add(r1);
					
					group.add(r);
					group.add(r1);
					
					group1 = new ButtonGroup();
					
					JRadioButton r2 = new JRadioButton("Present");
					r2.setBounds(305, 189, 109, 23);
					contentPane.add(r2);
					
					JRadioButton r3 = new JRadioButton("Absent");
					r3.setBounds(305, 229, 109, 23);
					contentPane.add(r3);
					
					group1.add(r2);
					group1.add(r3);
					
					JLabel lblNewLabel = new JLabel("Date");
					lblNewLabel.setBounds(247, 100, 46, 14);
					lblNewLabel.setFont(new Font("Arial",Font.BOLD,18));
					contentPane.add(lblNewLabel);
					
					 Date d = Calendar.getInstance().getTime();  
			           DateFormat dateFormat = new SimpleDateFormat();  
			           String strDate = dateFormat.format(d); 
					textField = new JTextField();
					textField.setBounds(305, 99, 109, 20);
					contentPane.add(textField);
					textField.setColumns(10);
					textField.setText(strDate); 
					textField.setHorizontalAlignment(JTextField.CENTER);
					textField.setEditable(false);
					
					 b1 = new JButton("Submit");
						b1.setBounds(64, 331, 107, 35);
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
										
											Double t=Double.parseDouble(t1.getText());
											String s,s1;
											if(r.isSelected())
												s="Present";
											else s="Absent";
											
											if(r2.isSelected())
												s1="Present";
											else s1="Absent";
	
											String dt = new java.util.Date().toString();
													
											PreparedStatement psInsertStudentattendance = connection.prepareStatement("insert into student_attendance values("+ t +",'"+dt+"','"+s+"','"+s1+"')");
											 psInsertStudentattendance.executeUpdate();
			
											  JOptionPane.showMessageDialog(null,"Attendance confirmed");
											  
												t1.setText("");
												group.clearSelection();
												group1.clearSelection();
												
									}catch(Exception e1) {
										JOptionPane.showMessageDialog(null, e1);
									}
								}
							}
							});
					        
					   	 b2 = new JButton("Reset");
							b2.setBounds(266, 331, 107, 35);
							  b2.setFont(new Font("serif",Font.BOLD,20));
						        b2.setBackground(Color.BLUE);
						        b2.setForeground(Color.WHITE);
					
						        contentPane.add(b2);
						        b2.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										t1.setText("");
										group.clearSelection();
										group1.clearSelection();
									
									}
								});
	}
	
private boolean validateFields() {
	int x=1;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		try {
			Double a=Double.parseDouble(t1.getText());
			
			Connection connection;
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
			PreparedStatement pst = connection.prepareStatement("select * from student where studentid = '"+a+"' ");
			  ResultSet rs=pst.executeQuery();

		 if(rs.next()) {
			 x=0;
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	ButtonModel buttonModel = group.getSelection();
	ButtonModel buttonModel1 = group1.getSelection();
	
		if(t1.getText().isEmpty() || buttonModel==null || buttonModel1==null ) {
			JOptionPane.showMessageDialog(null, "You have to fill all the fields!");
			t1.setText("");
			group.clearSelection();
			group1.clearSelection();
			return false;
		}
		
		else if(x==1)
			
		{
			JOptionPane.showMessageDialog(null, "ID Doesn't Exist!");
			t1.setText("");
			group.clearSelection();
			group1.clearSelection();
			return false;
			
		}
			
		return true;
	
	}

}
