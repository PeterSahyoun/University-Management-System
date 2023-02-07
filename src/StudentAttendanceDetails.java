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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;

public class StudentAttendanceDetails extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAttendanceDetails frame = new StudentAttendanceDetails();
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
	public StudentAttendanceDetails() {
		setTitle("Student Attendance Details");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		 setSize(800,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon14.jpg"));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 93, 794, 291);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBounds(0, 235, 794, -232);
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Date", "First Session", "Second Session"
			}
		));
		
		lblNewLabel = new JLabel("Student Attendance Details");
		lblNewLabel.setBounds(248, 21, 377, 35);
		lblNewLabel.setFont(new Font("serif",Font.ITALIC,30));
		lblNewLabel.setForeground(Color.BLUE);
		contentPane.add(lblNewLabel);
		
		show_data2();
		
	
	}
	
	public void show_data2()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			try {
				Connection connection;
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
				PreparedStatement pst = connection.prepareStatement("select * from STUDENT_ATTENDANCE");
				  ResultSet rs=pst.executeQuery();
				DefaultTableModel mm = (DefaultTableModel) table_1.getModel();
			 Object[] row = new Object[4];
			 while(rs.next()) {
				 row[0]=rs.getString("STUDENTID");
				 row[1]=rs.getString("DATE_ATTENDANCE");
				 row[2]=rs.getString("FIRST_SESSION");
				 row[3]=rs.getString("SECOND_SESSION");
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
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
        try{
          
        }catch(Exception e){
        	System.out.println("error");
        }
		
	}

}
