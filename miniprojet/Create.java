package miniprojet;

import java.sql.*;


public class Create {
	
	public static void main(String[] args) {
		
	
	
		Connection con=null;
		Statement stmt=null; 
		try {
	  		Class .forName("com.mysql.cj.jdbc.Driver");
	  	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Piyush");
	  		
	  		// creating query
	  	    String q="create table student(StudentId int primary key,FirstName varchar(30),LastName varchar(30),Department varchar(5),Contactno int unique not null,Email varchar(50) unique not null,City  varchar(10),State varchar(10),Country  varchar(10),ZIP int,Marks int)";
	  		
	  		stmt=con.createStatement();
	  		stmt.executeUpdate(q);
	  		System.out.println("The table is created in the database....");
	  		
	  		con.close();
	  		}catch(Exception e) {
	  			e.printStackTrace();
	  		}
	  		
	 }

}
