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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TeacherDetails extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherDetails frame = new TeacherDetails();
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
	public TeacherDetails() {
		setTitle("Teacher Details");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 setSize(1050,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon4.jpg"));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 1006, 282);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBounds(0, 235, 794, -232);
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "First Name", "Last Name", "Age","Phone Number","DOB", "Address","Department"
			}
		));
		
		JLabel l1 = new JLabel("Enter ID to delete Teacher :");
		l1.setBounds(10, 410, 238, 14);
		l1.setFont(new Font("Arial",Font.BOLD,15));
		contentPane.add(l1);
		
		textField = new JTextField();
		textField.setBounds(231, 404, 86, 20);
		textField.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(352, 401, 89, 23);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateFields()) {
				try {
					Connection connection= null;
					Class.forName("oracle.jdbc.driver.OracleDriver");
						connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
						Double a=Double.parseDouble(textField.getText());
						PreparedStatement psdeleteteacher = connection.prepareStatement("delete from teacher where teacherid = '"+a+"' ");
						psdeleteteacher.executeUpdate();
								JOptionPane.showMessageDialog(null,"Teacher Deleted");
								textField.setText("");
								DefaultTableModel model = (DefaultTableModel)table_1.getModel();
								model.setRowCount(0);
								show_data1();
								
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				}
			}
		
		});
		
		JLabel lblNewLabel = new JLabel("Add New Teahcer");
		lblNewLabel.setBounds(10, 479, 162, 14);
		lblNewLabel.setFont(new Font("Arial",Font.BOLD,15));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update Teahcer Details");
		lblNewLabel_1.setBounds(10, 515, 207, 14);
		lblNewLabel_1.setFont(new Font("Arial",Font.BOLD,15));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(231, 470, 89, 23);
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setBounds(231, 512, 89, 23);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(this);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("Teacher Details");
		lblNewLabel.setBounds(401, 22, 377, 35);
		lblNewLabel.setFont(new Font("serif",Font.ITALIC,30));
		lblNewLabel.setForeground(Color.BLUE);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.setBounds(927, 375, 89, 23);
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setForeground(Color.WHITE);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					int rows=table_1.getRowCount();
					Connection connection= null;
					Class.forName("oracle.jdbc.driver.OracleDriver");
						connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
						PreparedStatement psrefresh;
						for(int row = 0; row<rows; row++)
						{
							
							String id = table_1.getValueAt(row, 0).toString();
							String s = table_1.getValueAt(row, 1).toString();
							String s1 = table_1.getValueAt(row, 2).toString();
							String age = table_1.getValueAt(row, 3).toString();
							String s2 = table_1.getValueAt(row, 4).toString();
							String s3 = table_1.getValueAt(row, 5).toString();
							String s4 = table_1.getValueAt(row, 6).toString();
							String s5 = table_1.getValueAt(row, 7).toString();
							
							psrefresh = connection.prepareStatement("update teacher set  first_name='"+s+"',last_name='"+s1+"',age='"+age+"', phone_number='"+s2+"',dob='"+s3+"',address='"+s4+"',department='"+s5+"'where teacherid='"+id+"'  ");
							psrefresh.executeUpdate();
						
						}
						
						JOptionPane.showMessageDialog(null, "Successfully Saved");
		
						
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
				}
			
		
		});
		
		
		
		
		
		show_data1();
	}
	
	private boolean validateFields() {
		
		if( textField.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Enter ID");
			return false;
		}
			return true;
	
	}

	public void show_data1()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			try {
				Connection connection;
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
				PreparedStatement pst = connection.prepareStatement("select * from TEACHER");
				  ResultSet rs=pst.executeQuery();
				DefaultTableModel mm = (DefaultTableModel) table_1.getModel();
			 Object[] row = new Object[8];
			 while(rs.next()) {
				 row[0]=rs.getString("TEACHERID");
				 row[1]=rs.getString("FIRST_NAME");
				 row[2]=rs.getString("LAST_NAME");
				 row[3]=rs.getString("AGE");
				 row[4]=rs.getString("PHONE_NUMBER");
				 row[5]=rs.getString("DOB");
				 row[6]=rs.getString("ADDRESS");
				 row[7]=rs.getString("DEPARTMENT");
				 mm.addRow(row);
			 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	 String msg = e.getActionCommand();		
		 
		 if(msg.equals("Add"))
	            new AddTeacher().setVisible(true);
		 if(msg.equals("Update"))
	            new UpdateTeacher().setVisible(true);
	}
}
