package Autherizations;						//Current package

import passwordmainpack.PasswordMangr;		// imported user defined package

import javax.swing.*;						//imported system packages
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class AccessPhase {

	    
	    public static void main(String args[]){

	        JFrame frame = new JFrame("Authentication");
	        frame.setSize(800,680);
	        frame.setLayout(null);
	        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

	        //Sign In part


	        JPanel p = new JPanel();							// This os the sigh in panel
	        p.setLayout(null);
	        p.setBackground(Color.black);

	        JLabel title = new JLabel("Sign In");
	        title.setFont(new Font("Serif", Font.BOLD, 30));
	        title.setForeground(Color.white);
	        title.setSize(150, 35);
	        title.setLocation(200, 35);
	        p.add(title);
	        
	        
	        JLabel j2=new JLabel("USERNAME");
	        j2.setFont(new Font("Serif", Font.PLAIN, 15));
	        j2.setSize(150, 35);
	        j2.setForeground(Color.white);
	        j2.setLocation(50, 150);
	        p.add(j2);
	        
	        JLabel j3=new JLabel("PASSWORD");
	        j3.setFont(new Font("Serif", Font.PLAIN, 15));
	        j3.setSize(150, 35);
	        j3.setForeground(Color.white);
	        j3.setLocation(50, 220);
	        p.add(j3);
	        
	        JTextField field1=new JTextField();
	        field1.setBounds(150, 150, 200, 30);
	        p.add(field1);
	        
	     
	        
	        JPasswordField field2=new JPasswordField();
	        field2.setBounds(150, 220, 200, 30);
	        p.add(field2);
	        
	        JButton but =new JButton("LOGIN");
	        but.setBounds(150, 300, 100, 40);
	        but.setFont(new Font("Serif", Font.PLAIN, 15));
	        but.setForeground(Color.black);
	        p.add(but);
	        
	        JButton but2 =new JButton("RESET");
	        but2.setBounds(280, 300, 100, 40);
	        but2.setFont(new Font("Serif", Font.PLAIN, 15));
	        but2.setForeground(Color.black);
	        p.add(but2);

	        
	        but2.addActionListener((ActionListener) new ActionListener(){
	          public void actionPerformed(ActionEvent e){
	          	String def = "";
	  			field1.setText(def);
	  			field2.setText(def);
	         
	          	}
	        });
	        
	        but.addActionListener((ActionListener) new ActionListener(){
	          public void actionPerformed(ActionEvent e1){
	         	

	          	try {
	          		try (Connection connection = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/passwordmanagerdb","root","$#An4488")){
		      			String username = field1.getText();
		          		String passd = field2.getText();
		          		PreparedStatement pst = connection.prepareStatement ("select * from account where usrname =? and pasword=? ");
		          		pst.setString(1,username);
		              	pst.setString(2,passd);
		              	ResultSet r=pst.executeQuery();
		             	
		              	if(r.next()){
		              		JOptionPane.showMessageDialog(frame, "login successful");
		              		frame.setVisible(false);
		              		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		              		PasswordMangr mainAppObj = new PasswordMangr();
		              		mainAppObj.MainFrameDisplay();
		              		
		              		
		              	}
		             	
		              	else {
		              		JOptionPane.showMessageDialog(frame, "Password Missmatch");
		              	}
		         		
		          		}
	          			catch(SQLException ex){
	          				System.out.println("The Exception :" + ex);
	          			}
	         	     }
	         	
	      		catch(Exception e11) {
	      			e11.printStackTrace();
	     			
	    		}
	         	
	}	});
	        
	             

	        //Sign Up part

	        JPanel c = new JPanel();								// This is Sign Up panel
	        c.setLayout(null);
	        c.setBackground(Color.LIGHT_GRAY);

	        JLabel titlee;
	        JLabel name;
	        JTextField tname;
	        JLabel mno;
	        JTextField tmno;
	        JLabel gender;
	        JRadioButton male;
	        JRadioButton female;
	        ButtonGroup gengp;
	        JLabel dob;
	        JComboBox date;
	        JComboBox month;
	        JComboBox year;
	        JLabel add;
	        JTextArea tadd;
	        JLabel passl;
	        JPasswordField pass;
	        JLabel cpassl;
	        JPasswordField cpass;
	        JCheckBox term;
	        JButton sub;
	        JButton reset;
	        JLabel res;
	        final String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
	               "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", };
	        final String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
	               "Dec" };
	   
	        final String years[] = { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
	               "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002",
	               "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
	               "2016", "2017", "2018", "2019", "2020", "2021" };

	               
	        titlee = new JLabel("Sign Up");
			titlee.setFont(new Font("Arial", Font.PLAIN, 30));
			titlee.setSize(300, 30);
			titlee.setLocation(300, 30);
			c.add(titlee);

			name = new JLabel("Name");
			name.setFont(new Font("Arial", Font.PLAIN, 20));
			name.setSize(100, 20);
			name.setLocation(100, 100);
			c.add(name);

			tname = new JTextField();
			tname.setFont(new Font("Arial", Font.PLAIN, 15));
			tname.setSize(190, 20);
			tname.setLocation(200, 100);
			c.add(tname);

			mno = new JLabel("Mobile");
			mno.setFont(new Font("Arial", Font.PLAIN, 20));
			mno.setSize(100, 20);
			mno.setLocation(100, 150);
			c.add(mno);

			tmno = new JTextField();
			tmno.setFont(new Font("Arial", Font.PLAIN, 15));
			tmno.setSize(150, 20);
			tmno.setLocation(200, 150);
			c.add(tmno);

			gender = new JLabel("Gender");
			gender.setFont(new Font("Arial", Font.PLAIN, 20));
			gender.setSize(100, 20);
			gender.setLocation(100, 200);
			c.add(gender);

			male = new JRadioButton("Male");
			male.setFont(new Font("Arial", Font.PLAIN, 15));
			male.setSelected(true);
			male.setSize(75, 20);
			male.setLocation(200, 200);
			c.add(male);

			female = new JRadioButton("Female");
			female.setFont(new Font("Arial", Font.PLAIN, 15));
			female.setSelected(false);
			female.setSize(80, 20);
			female.setLocation(275, 200);
			c.add(female);

			gengp = new ButtonGroup();
			gengp.add(male);
			gengp.add(female);

			dob = new JLabel("DOB");
			dob.setFont(new Font("Arial", Font.PLAIN, 20));
			dob.setSize(100, 20);
			dob.setLocation(100, 250);
			c.add(dob);

			date = new JComboBox(dates);
			date.setFont(new Font("Arial", Font.PLAIN, 15));
			date.setSize(50, 20);
			date.setLocation(200, 250);
			c.add(date);

			month = new JComboBox(months);
			month.setFont(new Font("Arial", Font.PLAIN, 15));
			month.setSize(60, 20);
			month.setLocation(250, 250);
			c.add(month);

			year = new JComboBox(years);
			year.setFont(new Font("Arial", Font.PLAIN, 15));
			year.setSize(60, 20);
			year.setLocation(320, 250);
			c.add(year);

			add = new JLabel("Address");
			add.setFont(new Font("Arial", Font.PLAIN, 20));
			add.setSize(100, 20);
			add.setLocation(100, 300);
			c.add(add);

			tadd = new JTextArea();
			tadd.setFont(new Font("Arial", Font.PLAIN, 15));
			tadd.setSize(200, 75);
			tadd.setLocation(200, 300);
			tadd.setLineWrap(true);
			c.add(tadd);

			passl = new JLabel("Password");
			passl.setFont(new Font("Arial", Font.PLAIN, 20));
			passl.setSize(100, 20);
			passl.setLocation(100, 400);
			c.add(passl);

			pass = new JPasswordField();
			pass.setFont(new Font("Arial", Font.PLAIN, 15));
			pass.setSize(250, 20);
			pass.setLocation(200, 400);
			c.add(pass);

			cpassl = new JLabel("Confirm");
			cpassl.setFont(new Font("Arial", Font.PLAIN, 20));
			cpassl.setSize(100, 20);
			cpassl.setLocation(100, 450);
			c.add(cpassl);

			cpass = new JPasswordField();
			cpass.setFont(new Font("Arial", Font.PLAIN, 15));
			cpass.setSize(250, 20);
			cpass.setLocation(200, 450);
			c.add(cpass);

			term = new JCheckBox("Accept Terms And Conditions");
			term.setFont(new Font("Arial", Font.PLAIN, 15));
			term.setSize(250, 20);
			term.setLocation(150, 500);
			c.add(term);

			sub = new JButton("Submit");
			sub.setFont(new Font("Arial", Font.PLAIN, 15));
			sub.setSize(100, 20);
			sub.setLocation(150, 550);
			//sub.addActionListener(this);
			c.add(sub);

			reset = new JButton("Reset");
			reset.setFont(new Font("Arial", Font.PLAIN, 15));
			reset.setSize(100, 20);
			reset.setLocation(270, 550);
			//reset.addActionListener(this);
			c.add(reset);

			res = new JLabel("");
			res.setFont(new Font("Arial", Font.PLAIN, 20));
			res.setSize(500, 25);
			res.setLocation(100, 500);
			c.add(res);

			
			sub.addActionListener((ActionListener) new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	                String usrname = tname.getText();
	                String mobile = tmno.getText();
	                String address = tadd.getText();
	                String pasword = pass.getText();
	                String cnfpass = cpass.getText();
	                int len = mobile.length();
	                String dateob = (String) date.getSelectedItem() + "/" + (String) month.getSelectedItem() + "/"
	                        + (String) year.getSelectedItem();
	        
	                if (e.getSource() == sub) {
	                    if (term.isSelected()) {
	                        if (pasword.equals(cnfpass)) {
	                            if (len == 10) {
	                                try {
	                                    try{
	                                        Connection con=DriverManager.getConnection(  
	                                        "jdbc:mysql://localhost:3306/passwordmanagerdb","root","$#An4488");  
	                                        Statement st=con.createStatement();  
	                                                
	                                        // Adding record 
	                                        String query1="INSERT INTO `passwordmanagerdb`.`account`"
	                                         + " (`usrname`, `mobile`, `dateob`, `address`,`pasword`)"
	                                         + "VALUES('" +usrname+"','"+mobile+"','"+dateob+"','"+address+"','"+pasword+"')";
	                                        int x = st.executeUpdate(query1); 
	                                        
	                                        if (x == 0) {
	                                            JOptionPane.showMessageDialog(sub, "This account alredy exists");
	                                        } else {
	                                            JOptionPane.showMessageDialog(sub,
	                                                    "Welcome, " + "Your account is sucessfully created");
	                                        }	
	                                    }catch(SQLException y) {
	                                        System.out.println(y);
	                                        //Added finally here just undo the error statement
	                                    }
	                                } catch (HeadlessException exception) {
	                                }
	                            } else {
	                                JOptionPane.showMessageDialog(sub, "Enter a valid mobile number.");
	                            }
	                        } else {
	                            JOptionPane.showMessageDialog(sub, "Password Missmatch");
	                        }
	        
	                    } else {
	                        JOptionPane.showMessageDialog(sub, "Accept Terms & Condition");
	                    }
	                }           
	            }
	        });

	        reset.addActionListener((ActionListener) new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	            	
	                String def = "";
	                    tname.setText(def);
	                    tadd.setText(def);
	                    tmno.setText(def);
	                    res.setText(def);
	                    pass.setText(def);
	                    cpass.setText(def);
	                    term.setSelected(false);
	                    date.setSelectedIndex(0);
	                    month.setSelectedIndex(0);
	                    year.setSelectedIndex(0);
	            }
	        });
			
			

	        //Tabbed pane creation 


	        JTabbedPane tp = new JTabbedPane();
	        tp.setBounds(40,20,700,610);
	        tp.add("Sign In",p);  
	        tp.add("Sign Up",c);  

	        frame.add(tp);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.setResizable(true);
	    }
		
	
	
}
