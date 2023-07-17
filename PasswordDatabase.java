import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class PasswordDatabase {
	
	void  my_db_update(String appname, String username,String passd,String notesvar) {
			try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/passwordmanagerdb","root","");  
		Statement st=con.createStatement();  
		
		// Adding record 
		String query1="INSERT INTO `passwordmanagerdb`.`usersdata`"
		 + " (`appn`, `usern`, `passwd`, `note`)"
		 + "VALUES('" +appname+"','"+username+"','"+passd+"','"+notesvar+"')";
		st.executeUpdate(query1); // record added. 
		
		con.close();  
		
		}catch(Exception e){ System.out.println(e);} 
		//////////////////////////////
	}
	
}
