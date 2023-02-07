import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passField;
	private JButton b1,b2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\user.png"));
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(40, 30, 100, 30);
		l1.setFont(new Font("Arial",Font.BOLD,18));
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Password");
		l2.setBounds(40, 80, 100, 30);
		l2.setFont(new Font("Arial",Font.BOLD,18));
		frame.getContentPane().add(l2);
		
		textField = new JTextField();
		textField.setBounds(150, 30, 150, 30);
		frame.getContentPane().add(textField);
	
		
		passField = new JPasswordField();
		passField.setBounds(150, 80, 150, 30);
		frame.getContentPane().add(passField);
		
		b1 = new JButton("Login");
        b1.setBounds(40,160,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        frame.getContentPane().add(b1);
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateFields()) {
				try {
					Connection connection= null;
					Class.forName("oracle.jdbc.driver.OracleDriver");
						connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","SYSTEM");
						PreparedStatement pst = connection.prepareStatement("select * from LOGINAPP where username='"+textField.getText()+"' and password='"+passField.getText()+"' ");
						ResultSet rs = pst.executeQuery();
			
						if(rs.next()){
	
								new Project().setVisible(true);
								
								frame.setVisible(false);
				            }else{
				                JOptionPane.showMessageDialog(null, "Invalid login");
								textField.setText("");
								passField.setText("");
				            }
						
							
				
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		}
		});
        
        

        b2 = new JButton("Reset");
        b2.setBounds(180,160,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        frame.getContentPane().add(b2);
        
     
        
        b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				passField.setText("");
			
			}
		});
        
    
        
  	
		
	}
	
	


	private boolean validateFields() {
		
		if( textField.getText().isEmpty() || passField.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "You have to fill the 2 fields!");
			return false;
		}
			return true;
	
	}
}
