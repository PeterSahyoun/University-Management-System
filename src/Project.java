import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Project extends JFrame implements ActionListener{
	
	private BufferedImage image;
	
	 Project(){
		 super("University Management System - Admin");
		 setSize(1960,1030);
		
			JLabel l1 = new JLabel("New label");
			l1.setIcon(new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\university.jpg"));
			l1.setBounds(0, 0, 434, 261);
			add(l1);
		
		  JMenuBar mb  = new JMenuBar();
		 
	
		  JMenu master = new JMenu("Registration");
		  JMenuItem m1 = new JMenuItem("Add Student");
	      JMenuItem m2 = new JMenuItem("Add Teacher");
	      m1.setBackground(Color.WHITE);
	      m2.setBackground(Color.WHITE);
	      ImageIcon icon1 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon1.png");
	        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        m1.setIcon(new ImageIcon(image1));
	        ImageIcon icon2 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon2.png");
	        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	        m2.setIcon(new ImageIcon(image2));
	      m1.addActionListener(this);
	      m2.addActionListener(this);
	        master.add(m1);
	        master.add(m2);
	        mb.add(master);
	        
	    
	        
	        JMenu attendance = new JMenu("Attendance");
	        JMenuItem a1 = new JMenuItem("Student Attendance");
	        JMenuItem a2 = new JMenuItem("Teacher Attendance");
	        a1.setBackground(Color.WHITE);
	        a2.setBackground(Color.WHITE);
	        ImageIcon icon5 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon14.jpg");
	        Image image5 = icon5.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        a1.setIcon(new ImageIcon(image5));
	        ImageIcon icon6 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon15.png");
	        Image image6 = icon6.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        a2.setIcon(new ImageIcon(image6));
	        a1.addActionListener(this);
	        a2.addActionListener(this);
	        attendance.add(a1);
	        attendance.add(a2);
	        mb.add(attendance);
	        
	 
	        
	        JMenu report = new JMenu("Edit");
	        JMenuItem r1 = new JMenuItem("Update Student");
	        JMenuItem r2 = new JMenuItem("Update Teacher");
	        r1.setBackground(Color.WHITE);
	        r2.setBackground(Color.WHITE);
	        ImageIcon icon13 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon5.png");
	        Image image13 = icon13.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        r1.setIcon(new ImageIcon(image13));
	        ImageIcon icon12 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon6.png");
	        Image image12 = icon12.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        r2.setIcon(new ImageIcon(image12));
	        r1.addActionListener(this);
	        r2.addActionListener(this);
	        report.add(r1);
	        report.add(r2);
	        mb.add(report);
		  
		  
	        
	        JMenu user = new JMenu("Details");
	        JMenuItem u1 = new JMenuItem("Student Details");
	        JMenuItem u2 = new JMenuItem("Teacher Details");
	        JMenuItem u3 = new JMenuItem("Student Attendance Details");
	        JMenuItem u4 = new JMenuItem("Teacher Attendance Details");
	        ImageIcon icon3 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon3.png");
	        Image image3 = icon3.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        u1.setIcon(new ImageIcon(image3));
	        ImageIcon icon4 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon4.jpg");
	        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
	        u2.setIcon(new ImageIcon(image4));
	        ImageIcon icon7 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon14.jpg");
	        Image image7 = icon7.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        u3.setIcon(new ImageIcon(image7));
	        ImageIcon icon8 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon15.png");
	        Image image8 = icon8.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        u4.setIcon(new ImageIcon(image8));
	       
	        u1.setBackground(Color.WHITE);
	        u2.setBackground(Color.WHITE);
	        u3.setBackground(Color.WHITE);
	        u4.setBackground(Color.WHITE);
	    
	        u1.addActionListener(this);
	        u2.addActionListener(this);
	        u3.addActionListener(this);
	        u4.addActionListener(this);
	
	        user.add(u1);
	        user.add(u2);
	        user.add(u3);
	        user.add(u4);
	        mb.add(user);
	        
	        JMenu exit = new JMenu("Exit");
	        JMenuItem ex = new JMenuItem("Exit");
	        ex.setBackground(Color.WHITE);
	        ex.addActionListener(this);
	        ImageIcon icon11 = new ImageIcon("C:\\Users\\toshiba\\Desktop\\Courses\\OOP2\\University Management System\\src\\icons\\icon12.png");
	        Image image11 = icon11.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
	        ex.setIcon(new ImageIcon(image11));
	        exit.add(ex);
	        exit.setForeground(Color.RED);
	        mb.add(exit);
	 
	        
	        setJMenuBar(mb);   
	 }
	 
	 @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		 String msg = e.getActionCommand();		
		 
		 if(msg.equals("Add Student"))
	            new AddStudent().setVisible(true);
		  if(msg.equals("Add Teacher"))
	            new AddTeacher().setVisible(true);  
		  if(msg.equals("Student Attendance"))
	            new StudentAttendance().setVisible(true);
		  if(msg.equals("Teacher Attendance"))
	            new TeacherAttendance().setVisible(true);
		  
		  if(msg.equals("Update Student"))
	            new UpdateStudent().setVisible(true);
		  if(msg.equals("Update Teacher"))
	            new UpdateTeacher().setVisible(true);
		  
		  if(msg.equals("Student Details"))
	            new StudentDetails().setVisible(true);
		  if(msg.equals("Teacher Details"))
	            new TeacherDetails().setVisible(true);
		  if(msg.equals("Student Attendance Details"))
	            new StudentAttendanceDetails().setVisible(true);
		  if(msg.equals("Teacher Attendance Details"))
	            new TeacherAttendanceDetails().setVisible(true);
		  if(msg.equals("Exit"))
	            System.exit(0);
	 
	 }
	 
	 
	 
	  public static void main(String[] args){
	        new Project().setVisible(true);
	    }

	
}
