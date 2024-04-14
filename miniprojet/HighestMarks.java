package miniprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class HighestMarks {
		static
		{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		}
		public static void highestMarks() {
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
		
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Piyush");
				stmt=con.createStatement();
		        rs = stmt.executeQuery("select * from student where Marks<(select max(Marks) from student");
	            
		        while(rs.next()) {
	            	System.out.println(rs.getInt(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getInt(5)+"::"+rs.getString(6)+"::"+rs.getString(7)+"::"+rs.getString(8)+"::"+rs.getString(9)+"::"+rs.getInt(10)+"::"+rs.getInt(11));
	            }
	        }catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
	        finally {
	            try
	            {
	                if(stmt!=null)
	                {
	                    stmt.close();
	                    stmt=null;
	                }
	            }
	            catch (SQLException e)
	            {
	                e.printStackTrace();
	            }
	 
	            try
	            {
	                if(con!=null)
	                {
	                    con.close();
	                    con=null;
	                }
	            }catch(SQLException e) {
	            	e.printStackTrace();            
	            }
	        }
		}
	}

